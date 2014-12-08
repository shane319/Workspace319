package com.ericsson.mmsc.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.ericsson.ema.downstream.bean.ResponseBean;
import com.ericsson.mmsc.provisioning.ProvisioningStub;

public class ResponseParser {
	static final Logger logger = Logger.getLogger(ResponseParser.class);
	public ResponseBean parseResponse(String rawResp) throws Exception{
		// TODO Auto-generated method stub
		ResponseBean resp = new ResponseBean();
		int errorCode = 0;
		String errorDesc = "Success";
		String newXml = rawResp.replace("xmlns=", "xmlns:soap=");
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder = null;
		
			builder = domFactory.newDocumentBuilder();
		
		Document doc;
		
			doc = builder.parse(new InputSource(new StringReader(newXml)));
		
		if(rawResp.contains("<soap-env:Fault>")){
			
		logger.debug("Fault code present");
			
			XPath xpath = XPathFactory.newInstance().newXPath();
			xpath.setNamespaceContext(new NamespaceContext() {

				@Override
				public Iterator getPrefixes(String arg0) {
					return null;
				}

				@Override
				public String getPrefix(String arg0) {
					return null;
				}

				@Override
				public String getNamespaceURI(String arg0) {
					if ("soap-env".equals(arg0)) {
						return "http://schemas.xmlsoap.org/soap/envelope/";
					}
					return null;
				}
			});

			try {
				XPathExpression expr = xpath
						.compile("/soap-env:Envelope/soap-env:Body/soap-env:Fault/*");
				Object result = expr.evaluate(doc, XPathConstants.NODESET);
				NodeList nodes = (NodeList) result;
				logger.info("Number of items :" + nodes.getLength());
				for(int i=0 ; i<nodes.getLength();i++){
					logger.info("item :" + nodes.item(i).getTextContent());
					if(nodes.item(i).getNodeName().equalsIgnoreCase("faultcode"))
						errorCode = Integer.parseInt(nodes.item(i).getTextContent());
					else if (nodes.item(i).getNodeName().equalsIgnoreCase("faultstring"))
						errorDesc = nodes.item(i).getTextContent();
				}
				
				
				
			} catch (Exception E) {
				System.out.println(E);
			}
		}
		
		resp.setStatusCode(errorCode);
		resp.setErrorMessage(errorDesc);
		
		logger.debug("response : "+resp);
		
		return resp;
	}

}

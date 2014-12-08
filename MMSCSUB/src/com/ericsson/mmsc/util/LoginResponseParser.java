package com.ericsson.mmsc.util;

import java.io.StringReader;
import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import com.ericsson.mmsc.provisioning.ProvisioningStub;

/**
 * @author erameve
 * 
 */
public class LoginResponseParser {
	static final Logger logger = Logger.getLogger(LoginResponseParser.class);

	public String parseResponse(String xml) throws Exception {

		String sessionId = null;
		String newXml = xml.replace("xmlns=", "xmlns:soap=");
		DocumentBuilderFactory domFactory = DocumentBuilderFactory
				.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(newXml)));

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
					.compile("/soap-env:Envelope/soap-env:Header/sessionId");
			Object result = expr.evaluate(doc, XPathConstants.NODESET);
			NodeList nodes = (NodeList) result;
			logger.info("Session Id :" + nodes.item(0).getTextContent());
			sessionId = nodes.item(0).getTextContent();
		} catch (Exception E) {
			System.out.println(E);
		}
		return sessionId;
	}
}
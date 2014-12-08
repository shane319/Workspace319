package com.ericsson.ema.downstream.util;

/**
 * 
 * @author ESUMOND
 */
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import vms.QueryUserResponse;

import com.ericsson.ema.downstream.exception.JavaLinkException;

public class ResponseXmlUtil {

	static final Logger logger = Logger.getLogger(ResponseXmlUtil.class);

	private final String XML_TAG = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>";

	private final String ROOT = "QueryUserResponse";
	private final String RESULT_CODE = "resultCode";
	private final String RESULT_MESSAGE = "resultMessage";
	private final String SERVICE_CLASS = "serviceClass";

	public String generateQueryResponseXml(QueryUserResponse queryUserResponse)
			throws JavaLinkException {

		String xmlString = "";

		try {
			// Creating an empty XML Document

			// We need a Document
			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			// Creating the XML tree

			// create the root element and add it to the document
			Element root = doc.createElement(ROOT);
			doc.appendChild(root);

			// result code

			Element resultCodeElement = doc.createElement(RESULT_CODE);
			resultCodeElement.appendChild(doc.createTextNode(Integer
					.toString(queryUserResponse.getResultcode())));
			root.appendChild(resultCodeElement);

			// result message
			Element resultMessageElement = doc.createElement(RESULT_MESSAGE);
			resultMessageElement.appendChild(doc
					.createTextNode(queryUserResponse.getDescription()));
			root.appendChild(resultMessageElement);

			// service class
			
			if(!ValidatorUtil.isNull(queryUserResponse.getServiceClass())){
				Element serviceClassElement = doc.createElement(SERVICE_CLASS);
				serviceClassElement.appendChild(doc
						.createTextNode(queryUserResponse.getServiceClass()));
				root.appendChild(serviceClassElement);
			}

			// Output the XML

			// set up a transformer
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			// create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			xmlString = sw.toString();

			// print xml
			// System.out.println("Here's the xml:\n\n" + xmlString);

		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new JavaLinkException(e.getMessage());
		}

		//System.out.println("Query response:\n" + XML_TAG + "\n" + xmlString);
		xmlString = XML_TAG + xmlString;
		//xmlString= xmlString.replaceAll("\n","");
		return xmlString;

	}
}

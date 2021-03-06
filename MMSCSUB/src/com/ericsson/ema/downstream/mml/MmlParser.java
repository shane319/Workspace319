package com.ericsson.ema.downstream.mml;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import com.ericsson.ema.downstream.bean.RequestBean;
import com.ericsson.ema.downstream.exception.JavaLinkException;

public class MmlParser extends DefaultHandler {
	static final Logger logger = Logger.getLogger(MmlParser.class);
	
	private RequestBean requestBean = null;
	private String tempVal;
	private String mmlXml;

	private void parseDocument() throws JavaLinkException {
		// get a factory
		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			// get a new instance of parser
			SAXParser sp = spf.newSAXParser();
			// parse the file and also register this class for call backs
			//sp.parse(this.mmlXml, this);
			sp.parse(new ByteArrayInputStream(this.mmlXml.getBytes()),this);
		
		} catch (SAXException se) {
			//se.printStackTrace();
			logger.error(se.getMessage());
			throw new JavaLinkException(se.getMessage());
		} catch (ParserConfigurationException pce) {
			//pce.printStackTrace();
			logger.error(pce.getMessage());
			throw new JavaLinkException(pce.getMessage());
		} catch (IOException ie) {
			//ie.printStackTrace();
			logger.error(ie.getMessage());
			throw new JavaLinkException(ie.getMessage());
		}
	}

	public RequestBean processParsing(String mmlXml) throws JavaLinkException {
		this.mmlXml = mmlXml;
		parseDocument();
		return this.requestBean;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// reset
		tempVal = "";
		if (qName.equalsIgnoreCase(MmlConstant.T_ROOT)) {
			// create a new instance of MmlBean
			requestBean = new RequestBean();
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		tempVal = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase(MmlConstant.T_OPERATION)) {
			requestBean.setOperation(tempVal);
		}else if (qName.equalsIgnoreCase(MmlConstant.T_MSISDN)) {
			requestBean.setMsisdn(tempVal);
		}else if (qName.equalsIgnoreCase(MmlConstant.T_TRANSACTION_ID)) {
			requestBean.setTransactionId(tempVal);
		} else {
			//System.out.println("Input XML " + qName + " tag not matched");
		}
	}
}

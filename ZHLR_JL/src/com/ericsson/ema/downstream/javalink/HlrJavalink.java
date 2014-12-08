/**
 * ------------------------------------------------------------------------
 *
 * (C) Copyright Ericsson AB, 2007
 *
 * The copyright to the computer program (s) herein is the property of
 * Ericsson AB, Sweden. The program (s) may be used and/or
 * copied only with the written permission from Ericsson AB
 * or in accordance with the terms and conditions stipulated in the
 * agreement/contract under which the program (s) has been supplied.
 * All rights reserved.
 */

// Java link connection to ZTE HLR/AUC
// Tue Jul 23 14:22:50 MYT 2013 echeriy

package com.ericsson.ema.downstream.javalink;

import java.io.*;
import java.rmi.RemoteException;
import java.util.regex.*;
import java.net.Socket;
import java.net.InetSocketAddress;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import se.ericsson.ema.downstream.DownStreamConnection;
import se.ericsson.ema.downstream.DownStreamException;

public class HlrJavalink implements DownStreamConnection {
	// for detail debug level traces
	//private static final boolean TRACE = false;

	static final Logger logger = Logger.getLogger(HlrJavalink.class);

	// ZTE message fields
	private static final String FLAG = "`SC`";
	private static final String VERSION = "1.00";
	// private static final String TERM_ID = "ZXWN1000";
	// private static final String TERM_ID = "ZXG10001";
	private static final String SVC_NAME = "HLRAGENT";
	private static final String DLG_CTRL_LGN = "DLGLGN";
	private static final String DLG_CTRL_CON = "DLGCON";
	private static final String DLG_CTRL_END = "DLGEND";
	private static final String DLG_RESV = "FFFF";
	private static final String TRANS_CTRL_BEG = "TXBEG ";
	private static final String TRANS_CTRL_END = "TXEND ";
	private static final String TRANS_AGENT = "FF";
	private static final String TRANS_RESV = "FF";

	private String host; // NE address
	private int port; // NE port
	// private String prompt; // NE prompt
	private String user; // NE login user
	private String passwd; // NE login password
	private String TERM_ID;
	private String hlrin;
	private String timeout;

	// Regex for response string, i.e:
	// "ACK:LOGIN:RETN=000000, DESC=success "
	// "ACK:QRY AUTH : RETN=101030, DESC=IMSI does not exist"
	// "ACK:LOGOUT:RETN=000000,DESC=Operation success   "
	//
	private static final String ackPattern = "ACK\\s*:[^:]+:\\s*RETN\\s*=\\s*(\\d+)\\s*,\\s*DESC\\s*=\\s*(.*)";

	private Pattern ackRegex;

	private static final int SOCK_CONNECT_TIMEOUT = 10 * 1000; // in milli-secs

	private long dialogID;
	private long transID;

	private Socket socket; // socket for the connection

	private static final String LOG4J_CONFIG_FILE = "/var/sog/sdk/downstream/java/ZHLR/log4j.xml";

	// constructor
	public HlrJavalink() {

		DOMConfigurator.configure(LOG4J_CONFIG_FILE);
		
		ackRegex = Pattern.compile(ackPattern);
	}

	// set the NE link parameters
	//
	@Override
	public void setConfiguration(String[] configurations)
			throws DownStreamException {
		logger.debug("setConfiguration(): ...");

		if (configurations == null) {
			logger.error("EMA GUI configuration parameter is null");
			throw new DownStreamException(
					"EMA GUI configuration parameter is null");
		} else if (configurations.length < 5) {
			logger.error("Insufficient EMA GUI input configuration parameter");
			throw new DownStreamException(
					"Insufficient EMA GUI input configuration parameter");
		}

		host = configurations[0];
		port = Integer.parseInt(configurations[1]);
		// prompt = configurations[2];
		user = configurations[3];
		passwd = configurations[4];
		TERM_ID = configurations[5];
		hlrin = configurations[6];
		timeout = configurations[7];

		// if the gui was using dummy simulator,
		// set to the real ZTE HLR parameters
		//
		/*
		 * if (host.equals("127.0.0.1") || host.equals("localhost")) { host =
		 * "10.48.50.8"; port = 3140; user = "DSA"; passwd = "Password"; }
		 */
		/*logger.debug("setConfiguration - host: " + host);
		logger.debug("setConfiguration - port: " + port);
		logger.debug("setConfiguration - user: " + user);
		logger.debug("setConfiguration - passwd: " + passwd);
		logger.debug("setConfiguration - TERM_ID: " + TERM_ID);
		logger.debug("setConfiguration - HRLIN: " + hlrin);
		logger.debug("setConfiguration - Socket read timeout: " + timeout);
		*/
		
		
		logger.info("setConfiguration: "+host+"|"+port+"|"+user+"|"+passwd+"|"+TERM_ID+"|"+hlrin+"|"+timeout);
		
		logger.debug("setConfiguration(): OK");
	}

	// connect to NE
	//
	@Override
	public void connect() throws DownStreamException {
		
		
		
		
		try {
			
			logger.debug("connect(): ...");
			//logger.debug("Setting read timeout: " + Integer.parseInt(timeout));
			
			socket = new Socket();
			socket.connect(new InetSocketAddress(host, port));
			socket.setSoTimeout(Integer.parseInt(timeout));
			
			// must reset prior to login request
			//
			dialogID = 0;
			transID = 0;

			// response to LOGIN must be "RETN=000000,xxxxx"
			//
			
			String loginRequest = "LOGIN:USER=" + user + ",PSWD=" + passwd + ",HLRIN=" + hlrin;
			String loginResponse = sendMessage(loginRequest);
			
			logger.info("Login response: \"" + loginResponse + "\"");
			
			if (loginResponse.indexOf("RETN=000000") == -1){
				throw new DownStreamException("Login failed: " + loginResponse);
			}
						
			logger.debug("connect(): OK");
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			
			throw new DownStreamException("Failed to connect to NE: "+ e.getMessage());
		}
		
	}

	// send request message and return response message as "RESP:<code>,<desc>"
	//
	@Override
	public String sendMessage(String mmlString) throws DownStreamException {
		
		Long start_time = System.currentTimeMillis();
		
		//logger.debug("sendMessage: request = \"" + mmlString + "\"");

		String response = null;
		
		InputStream is = null;
		OutputStream os = null;
		
		
		try {
			is = socket.getInputStream();
			os = socket.getOutputStream();
	
			
			String requestMsg = encode(mmlString);
			os.write(requestMsg.getBytes("US-ASCII"));
			os.flush();

			// read the first 8 bytes message header to get msg body len
			//
			byte[] buffer = new byte[8192];
			int nr = readn(is, buffer, 0, 8);
			if (nr == 0)
				throw new DownStreamException("Peer has disconnected");
			if (nr < 8)
				throw new DownStreamException(
						"Unexpected EOF while in message header");

			int bodyLen;
			String responseHdr = new String(buffer, 0, 8, "US-ASCII");
			String bodyLenHex = responseHdr.substring(4, 8);
			try {
				bodyLen = Integer.parseInt(responseHdr.substring(4, 8), 16);
			} catch (NumberFormatException e) {
				throw new DownStreamException("Bad message body length '"
						+ bodyLenHex + "'H: " + responseHdr);
			}
			if (bodyLen < 56 || bodyLen > 8000) {
				throw new DownStreamException("Bad message body length ("
						+ bodyLen + "): " + responseHdr);
			}

			// read the message body + checksum
			//
			int count = bodyLen + 8; // +8 for checksum
			nr = readn(is, buffer, 8, count);
			if (nr < count)
				throw new DownStreamException(
						"Unexpected EOF while in message body");

			// decode the response message, get response text, dialogID, and
			// transID
			//
			String responseMsg = new String(buffer, 0, bodyLen + 16, "US-ASCII");
			String[] a = decode(responseMsg);
			response = a[0];

			long resp_dialogID = Long.parseLong(a[1]);
			if (dialogID == 0) {
				dialogID = resp_dialogID;
			} else if (resp_dialogID != dialogID) {
				throw new DownStreamException("Mismatched Dialog-ID: "
						+ resp_dialogID + " (expected " + dialogID + ")");
			}

			long resp_transID = Long.parseLong(a[2]);
			if (resp_transID != transID) {
				throw new DownStreamException("Mismatched Transaction-ID"
						+ resp_transID + " (expected " + transID + ")");
			}

		} catch (RemoteException e){
			
			Throwable throwable = e.detail;
			String exceptionType = throwable.getClass().getSimpleName();

			logger.error("RemoteException: "+exceptionType);
			System.out.println("RemoteException: "+exceptionType);
						
			throw new DownStreamException(e.getMessage());
			// e.printStackTrace();
		} catch (Exception e) {
			
			Throwable throwable = e;
			String exceptionType = throwable.getClass().getSimpleName();

			logger.error("Exception: "+exceptionType);
			System.out.println("Exception: "+exceptionType);
			
			
			logger.error("ERR:" + e.getMessage());
			throw new DownStreamException(e.getMessage());
		} 

		/*
		 * // response = "ACK:QRY AUTH : RETN=101030, DESC=IMSI does not exist"
		 * // need to return "RETN=101030, DESC=IMSI does not exist" // String
		 * resp = response; int pos = response.indexOf("RETN="); if (pos >= 0)
		 * resp = response.substring(pos);
		 */
		// return the response as it is (without modification)
		//String resp = response;
		
		//logger.debug("sendMessage: response \"" + resp + "\"");
		
		Long end_time = System.currentTimeMillis();
		Long execution_time = end_time - start_time;
		logger.info("Execution time: "+execution_time+"\nRequest: "+mmlString+"\nResponse: "+response);
	
		
		return response;
	}

	// disconnect
	//
	@Override
	public void disconnect() throws DownStreamException {
		logger.debug("disconnect(): ...");

		// FIXME: need to check the response RETN:xxxx
		String logoutRequest = "LOGOUT:USER=" + user;
		String logoutResponse = sendMessage(logoutRequest);
		
		logger.info("Logout response: \"" + logoutResponse + "\"");

		// close the connection to the NE
		try {
			socket.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			//throw new DownStreamException("Socket close: " + e.getMessage());
		}
		logger.debug("disconnect(): OK");
	}

	// encode request with dialogID and transID into ZTE message
	//
	private String encode(String request) throws DownStreamException {
		// pad spaces so request length is multiples of 4-bytes
		//
		switch (request.length() % 4) {
		case 1:
			request += "   ";
			break; // add 3 spaces
		case 2:
			request += "  ";
			break; // add 2 spaces
		case 3:
			request += " ";
			break; // add 1 space
		}

		transID++; // increment for each transaction
		String dialogCtrl = request.contains("LOGIN") ? DLG_CTRL_LGN
				: DLG_CTRL_CON;

		String messageBody = String.format(
				"%4s%8s%8s%08X%6s%4s%08X%6s%2s%2s%s", VERSION, TERM_ID,
				SVC_NAME, dialogID, dialogCtrl, DLG_RESV, transID,
				TRANS_CTRL_BEG, TRANS_AGENT, TRANS_RESV, request);
		int bodyLen = messageBody.length();
		String messageChecksum = String.format("%08X",
				checksum(messageBody, 0, bodyLen));
		String messageHeader = String.format("%4s%04X", FLAG, bodyLen);

		String message = messageHeader + messageBody + messageChecksum;
		logger.debug("encode: message = \"" + message + "\"");
		
		return message;
	}

	// decode ZTE message and return array (response, dialogID, transID)
	//
	private String[] decode(String message) throws DownStreamException {
		int totalLen = message.length();
		if (totalLen < 72)
			throw new DownStreamException("[decode] Message too short: \""
					+ message + "\"");

		String flag = message.substring(0, 4);
		
		if (!flag.equals(FLAG)) {
			throw new DownStreamException("[decode] Bad Begin-Flag \"" + flag
					+ "\": " + message);
		}

		int bodyLen;
		String bodyLenHex = message.substring(4, 8);
		
		try {
			bodyLen = Integer.parseInt(bodyLenHex, 16);
		} catch (NumberFormatException e) {
			throw new DownStreamException("[decode] Bad message Body-Length '"
					+ bodyLenHex + "'H: " + message);
		}

		String version = message.substring(8, 12);
		
		if (!version.equals(VERSION)) {
			throw new DownStreamException("[decode] Bad Version \"" + version
					+ "\": " + message);
		}

		String terminalID = message.substring(12, 20);
		
		if (!terminalID.equals(TERM_ID)) {
			throw new DownStreamException("[decode] Bad Terminal-ID \""
					+ terminalID + "\": " + message);
		}

		String svcname = message.substring(20, 28);
		
		if (!svcname.equals(SVC_NAME)) {
			throw new DownStreamException("[decode] Bad Service-Name \""
					+ svcname + "\": " + message);
		}

		long resp_dialogID;
		String resp_dialogIDHex = message.substring(28, 36);
		
		try {
			resp_dialogID = Long.parseLong(resp_dialogIDHex, 16);
		} catch (NumberFormatException e) {
			throw new DownStreamException("[decode] Bad Dialog-ID '"
					+ resp_dialogIDHex + "'H: " + message);
		}

		String dialogCtrl = message.substring(36, 42);
		
		if (!(dialogCtrl.equals(DLG_CTRL_CON) || dialogCtrl
				.equals(DLG_CTRL_END))) {
			throw new DownStreamException("[decode] Bad Dialog-Control-Word \""
					+ dialogCtrl + "\": " + message);
		}

		//String dialogResvHex = message.substring(42, 46); // "FFFF"
		
		long resp_transID;
		String resp_transIDHex = message.substring(46, 54);
		
		try {
			resp_transID = Long.parseLong(resp_transIDHex, 16);
		} catch (NumberFormatException e) {
			throw new DownStreamException("[decode] Bad Transaction-ID '"
					+ resp_transIDHex + "'H: " + message);
		}

		String transCtrl = message.substring(54, 60);
		
		if (!transCtrl.equals(TRANS_CTRL_END)) {
			throw new DownStreamException(
					"[decode] Bad Transaction-Control-Word \"" + transCtrl
							+ "\": " + message);
		}

		//String transAgentHex = message.substring(60, 62); // "FF"
		//String transResvHex = message.substring(62, 64); // "FF"
		String response = message.substring(64, totalLen - 8);
		
		logger.debug("decode: response = \"" + response + "\"");
		
		int respLen = response.length();
		if (respLen == 0) {
			throw new DownStreamException("[decode] Empty response info: "
					+ message);
		} else if ((respLen % 4) != 0) {
			throw new DownStreamException(
					"[decode] Response info length not mutiples of 4-bytes: "
							+ message);
		}

		String hisChecksumHex = message.substring(totalLen - 8);

		int hisChecksum;
		try {
			hisChecksum = (int) Long.parseLong(hisChecksumHex, 16);
		} catch (NumberFormatException e) {
			throw new DownStreamException("[decode] Bad checksum '"
					+ hisChecksumHex + "'H: " + message);
		}

		int myChecksum = checksum(message, 8, totalLen - 8);
		if (myChecksum != hisChecksum) {
			String myChecksumHex = String.format("%08X", myChecksum);
			throw new DownStreamException("[decode] Mismatched checksum '"
					+ hisChecksumHex + "'H (expected '" + myChecksumHex
					+ "'H): " + message);
		}

		return new String[] { response, Long.toString(resp_dialogID),
				Long.toString(resp_transID) };
	}

	// return 32-bit xor check sum of string s[beginIndex..endIndex)
	//
	private int checksum(String s, int beginIndex, int endIndex)
			throws DownStreamException {
		if (endIndex < beginIndex || ((endIndex - beginIndex) % 4) != 0) {
			throw new DownStreamException("[checksum] Bad string length \"" + s
					+ "\"");
		}

		byte[] b;
		try {
			b = s.getBytes("US-ASCII"); // was "ISO-8859-1"
		} catch (UnsupportedEncodingException e) {
			throw new DownStreamException("[checksum] Bad string encoding \""
					+ s + "\"");
		}
		int sum = 0;
		for (int i = beginIndex; i < endIndex; i += 4) {
			int x = (b[i + 0] & 0xff) << 24;
			x |= (b[i + 1] & 0xff) << 16;
			x |= (b[i + 2] & 0xff) << 8;
			x |= (b[i + 3] & 0xff);
			sum ^= x;
		}
		return ~sum;
	}

	// attempt to read exactly length bytes, return no of bytes actually read
	//
	private static int readn(InputStream is, byte[] b, int offset, int length)
			throws IOException {
		int nleft = length;
		int pos = offset;
		while (nleft > 0) {
			int nr = is.read(b, pos, nleft);
			if (nr == -1) // EOF
				break;
			if (nr > 0) {
				pos += nr;
				nleft -= nr;
			}
		}
		return length - nleft;
	}
}

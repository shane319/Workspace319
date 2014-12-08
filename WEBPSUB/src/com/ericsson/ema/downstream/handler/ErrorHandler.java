package com.ericsson.ema.downstream.handler;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import javax.xml.soap.SOAPException;
import org.apache.axis.AxisFault;
import org.apache.log4j.Logger;
import com.ericsson.ema.downstream.exception.JavaLinkException;

public class ErrorHandler {
	private static final Logger logger = Logger.getLogger(ErrorHandler.class);

	public void handleError(Exception e) throws JavaLinkException {
		handleCommonError(e);
		throw new JavaLinkException(e.getClass().getSimpleName(), 9099);
		
	}

	public void handleError(AxisFault e) throws JavaLinkException {
		handleCommonError(e);
		throw new JavaLinkException(e.getClass().getSimpleName(), 9023);
	}

	public void handleError(RemoteException e) throws JavaLinkException {
		handleCommonError(e);
		throw new JavaLinkException(e.getClass().getSimpleName(), 9024);
	}

	public void handleError(IllegalAccessException e) throws JavaLinkException {
		handleCommonError(e);
		throw new JavaLinkException(e.getClass().getSimpleName(), 9025);
	}

	public void handleError(InvocationTargetException e)
			throws JavaLinkException {
		handleCommonError(e);
		throw new JavaLinkException(e.getClass().getSimpleName(), 9026);
	}

	public void handleError(SOAPException e) throws JavaLinkException {
		handleCommonError(e);
		throw new JavaLinkException(e.getClass().getSimpleName(), 9027);
	}

	private void handleCommonError(Exception e) throws JavaLinkException {
		
		String exceptionType = e.getClass().getSimpleName();
		if (exceptionType.equals("SocketTimeoutException") 
				|| exceptionType.equals("ConnectTimeoutException")) {
			throw new JavaLinkException("Response Time out", 9002);
		} else if (exceptionType.equals("AxisFault")) {
			throw new JavaLinkException("Connection Error", 9003);
		}
	}
}

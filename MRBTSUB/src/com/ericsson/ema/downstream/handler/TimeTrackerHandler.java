package com.ericsson.ema.downstream.handler;

import com.ericsson.ema.downstream.exception.JavaLinkException;

public class TimeTrackerHandler {
	private static boolean processingFlag = true;
	
	private long startTime = -1;
	private long exitTime = -1;
	
	public boolean isGreen(){
		return processingFlag;
	}
	
	private void stopProcessing(){
		processingFlag = false;
	}
	
	public void startProcessing(){
		processingFlag = true;
	}
	
	public void trackTime() throws JavaLinkException{
		// capture start time
		if(startTime == -1 && exitTime == -1){
			startTime = System.currentTimeMillis();
		}else if(startTime != -1 && exitTime == -1){
		// capture exit time
			exitTime = System.currentTimeMillis();
			
			long executionTime = (exitTime - startTime);
			
		}else{
			throw new JavaLinkException("Time tracking faild");
		}
	}
}

package com.ericsson.ema.downstream.util;
/**
 * 
 * @author ESUMOND
 */
import java.util.Random;

public class RandomUtil {
	public static String getRandom(){
		Random ramdom = new Random();
		String number = Long.toString(ramdom.nextLong() + 1);
		number = number.substring(2,18);
		return number;
	}
}

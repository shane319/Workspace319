/*******************************************************************
 *
 * FILE NAME   : ValidatorUtil.java
 *
 * DESCRIPTION : Logic for necessary validation check
 * 
 * DOCUMENTS   : 
 *
 * AUTHOR      : Subhasish Mondal(esumond)
 *
 * DATE        : Aug-2012
 *      
 *******************************************************************/
/*******************************************************************
 *
 * MODIFICATION HISTORY:
 *
 * 1. Name  :
 *    Date  :
 *    Change:
 *
 *************************************************************/

package com.ericsson.ema.downstream.util;

import java.util.StringTokenizer;
import org.apache.log4j.Logger;

public class ValidatorUtil {
	static final Logger logger = Logger.getLogger(ValidatorUtil.class);

	public static boolean isSignInt(String str) {

		char[] numberKey = new String("0123456789").toCharArray();
		char[] signKey = new String("-+").toCharArray();

		if (str == null || str.length() == 0) {
			return false;
		} else {
			byte i = 0;
			for (byte j = 0; j < signKey.length; j++) {
				if (str.charAt(i) == signKey[j]) {
					i++;
					break;
				}
			}
			for (; i < str.length(); i++) {
				byte j = 0;
				for (; j < numberKey.length; j++) {
					if (str.charAt(i) == numberKey[j]) {
						break;
					}
				}
				if (j == numberKey.length) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isNumeric(String str) {

		char[] numberKey = new String("0123456789").toCharArray();
		if (str == null || str.length() == 0) {
			return false;
		} else {

			for (byte i = 0; i < str.length(); i++) {
				byte j = 0;
				for (; j < numberKey.length; j++) {
					if (str.charAt(i) == numberKey[j]) {
						break;
					}
				}
				if (j == numberKey.length) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean isString(String str) {
		if (str == null || str.length() == 0) {
			return false;
		}

		return true;
	}

	public static boolean isNull(String content) {
		if (content == null || content.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isValidEmail(String content) {
		if (content == null || content.length() == 0) {
			return false;
		} else {

			StringTokenizer str = new StringTokenizer(content, "@");
			while (str.hasMoreTokens()) {

				if (isString(str.nextToken())) {

					if (str.hasMoreTokens()) {
						if (isString(str.nextToken())) {
							if (!str.hasMoreTokens()) {
								return true;
							}
						}
					}
				}
			}
			return false;
		}

	}

	public static boolean isValidIp(String content) {

		boolean result = false;
		String[] parts = content.split("\\.");
		if (parts.length == 4) {
			for (String checkStr : parts) {
				if (isNumeric(checkStr)) {
					int checkInt = Integer.parseInt(checkStr);
					if ((checkInt >= 0) && (checkInt < 255)) {
						result = true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			if (Integer.parseInt(parts[0]) == 0) {
				return false;
			}
		}

		return result;
	}
}

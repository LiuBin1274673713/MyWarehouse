package com.accp.liu.sbwallpaper.entity;

import org.apache.commons.codec.binary.Base64;

public class Encodes {

	/**
	 * Base64½âÂë.
	 */
	public static byte[] decodeBase64(String input) {
	   return Base64.decodeBase64(input.getBytes());
	}
}

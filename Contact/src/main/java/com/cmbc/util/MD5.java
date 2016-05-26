package com.cmbc.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.*;

public class MD5 {

	public static String getMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		MessageDigest md5 = MessageDigest.getInstance("MD5");
		BASE64Encoder base64en = new BASE64Encoder();
		str = base64en.encode(md5.digest(str.getBytes("utf-8")));
		return str;
	}
}

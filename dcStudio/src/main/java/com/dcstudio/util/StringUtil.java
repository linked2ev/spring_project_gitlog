package com.dcstudio.util;

public class StringUtil {
	
	public static String nvl(Object str) {
		return str != null && !"".equals(str) ? str.toString() : "";
	}
}

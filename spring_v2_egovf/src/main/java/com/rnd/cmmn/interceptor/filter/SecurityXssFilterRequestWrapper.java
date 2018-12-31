package com.rnd.cmmn.interceptor.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn.interceptor.filter
* 2. 타입명 : SecurityXssFilterRequestWrapper.java
* 3. 작성일 : 2017. 11. 28.
* 4. 설명 : XSS Filter Config
* </pre>
 */
public class SecurityXssFilterRequestWrapper extends HttpServletRequestWrapper {

	public SecurityXssFilterRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public String[] getParameterValues(String parameter) {
		
		String[] values = super.getParameterValues(parameter);

		if (values == null) {
			return null;
		}

		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				StringBuffer strBuff = new StringBuffer();
				for (int j = 0; j < values[i].length(); j++) {
					
					// DOM 기반 XSS 방지
					//values[i] = values[i].replaceAll("(?i)script|object|applet|embed|form|alert|href|cookie|input|src|fromcharcode|encodeuri|encodeuricomponent|expression|iframe|window|location|style|eval","");
					//values[i] = values[i].replaceAll("(?i)onclick|ondblclick|onmousedown|onmousemove|onmouseout|onmouseup|onmouseover|onmouseleave|onkeydown|onkeypress|onkeyup|onblur|onchange|onfocus|onreset|onselect|onsubmit|onload|onresize|onunload","");

					// SQL Injection 방지
					//values[i] = values[i].replaceAll("(?i)select|having|from|drop|where|join|update|union|insert|and|or|substr|declare|openrowset|user_tables|user_tab_columns|table_name|column_name|row_num","");

//					char c = values[i].charAt(j);
//					switch (c) {
//						case '<':
//							strBuff.append("&lt;");
//							break;
//						case '>':
//							strBuff.append("&gt;");
//							break;
//						case '&':
//							strBuff.append("&amp;");
//							break;
//						case '"':
//							strBuff.append("&quot;");
//							break;
//						case '\'':
//							strBuff.append("&apos;");
//							break;
//						default:
//							strBuff.append(c);
//							break;
//					}
				}
				values[i] = strBuff.toString();
			} else {
				values[i] = null;
			}
		}

		return values;
	}

	public String getParameter(String parameter) {
		
		String value = super.getParameter(parameter);
		
		// DOM 기반 XSS 방지
		//value = value.replaceAll("(?i)script|object|applet|embed|form|alert|href|cookie|input|src|fromcharcode|encodeuri|encodeuricomponent|expression|iframe|window|location|style|eval","");
		//value = value.replaceAll("(?i)onclick|ondblclick|onmousedown|onmousemove|onmouseout|onmouseup|onmouseover|onmouseleave|onkeydown|onkeypress|onkeyup|onblur|onchange|onfocus|onreset|onselect|onsubmit|onload|onresize|onunload","");

		// SQL Injection 방지
		//value = value.replaceAll("(?i)select|having|from|drop|where|join|update|union|insert|and|or|substr|declare|openrowset|user_tables|user_tab_columns|table_name|column_name|row_num","");

//		if (value == null) {
//			return null;
//		}
//
//		StringBuffer strBuff = new StringBuffer();
//
//		for (int i = 0; i < value.length(); i++) {
//
//			char c = value.charAt(i);
//			switch (c) {
//				case '<':
//					strBuff.append("&lt;");
//					break;
//				case '>':
//					strBuff.append("&gt;");
//					break;
//				case '&':
//					strBuff.append("&amp;");
//					break;
//				case '"':
//					strBuff.append("&quot;");
//					break;
//				case '\'':
//					strBuff.append("&apos;");
//					break;
//				default:
//					strBuff.append(c);
//					break;
//			}
//		}
//
//		value = strBuff.toString();

		return value;
	}

}
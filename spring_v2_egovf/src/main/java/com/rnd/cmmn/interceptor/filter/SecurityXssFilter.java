package com.rnd.cmmn.interceptor.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.rnd.cmmn.interceptor.filter.SecurityXssFilterRequestWrapper;


/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn.interceptor.filter
* 2. 타입명 : SecurityXssFilter.java
* 3. 작성일 : 2017. 11. 28.
* 4. 설명 : XSS Filter
* </pre>
 */
public class SecurityXssFilter implements Filter{
	
	@SuppressWarnings("unused")
	private FilterConfig config;	
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		chain.doFilter(new SecurityXssFilterRequestWrapper((HttpServletRequest)request), response);		
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;		
	}
	
	public void destroy() {
		
	}
}

package com.cmmn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


/**
* <pre>
* 1. 패키지명 : com.cmmn.interceptor
* 2. 타입명 : WebAccessInterceptor.java
* 3. 작성일 : 2017. 12. 14.
* 4. 작성자 : linked2ev
* 5. 설명 : WebAccessInterceptor
* </pre>
 */
public class WebAccessInterceptor extends HandlerInterceptorAdapter {

	static final Logger logger = LoggerFactory.getLogger(WebAccessInterceptor.class);
	
//	@Value("#{config['webRootDomain']}")
//  	String webRootDomain;
//	
//	@Value("#{config['file.webRootPath']}")
//  	String webRootPath;
//	
//	@Value("#{config['file.uploadPath']}")
//	String uploadPath;
	
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        /* *** config *** */
//        request.setAttribute("webRootDomain", webRootDomain);
//        request.setAttribute("webRootPath", webRootPath);
//        request.setAttribute("uploadPath", uploadPath);
        
		return true;
    }
    
}

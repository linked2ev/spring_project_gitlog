package com.cmmn.interceptor;

import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.cmmn.resolver.CommandMap;


/**
* <pre>
* 1. 패키지명 : com.cmmn.interceptor
* 2. 타입명 : LoggerInterceptor.java
* 3. 작성일 : 2017. 12. 14.
* 4. 작성자 : linked2ev
* 5. 설명 : LoggerInterceptor
* </pre>
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	
	static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
     
    @SuppressWarnings("unchecked")
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler, CommandMap commandMap) throws Exception {
    	
    	logger.info("======================================          START         ======================================");
    	logger.info(" Class       \t:  " + handler.getClass());
    	logger.info(" Request URI \t:  " + request.getRequestURI());
    	logger.info(" Servlet URI \t:  " + request.getServletPath());
        Enumeration<String> paramNames = request.getParameterNames();
        
//        commandMap 사용
//        while (paramNames.hasMoreElements()) {
//          String key = (String) paramNames.nextElement();  
//          String value = request.getParameter(key);
//          logger.info(" RequestParameter Data >>  " + key + " : " + value + "");
//        }
        logger.info("====================================================================================================");
        
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //Logger.info("======================================           END          ======================================");
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	logger.info("======================================           END          ======================================");
    }
    
}

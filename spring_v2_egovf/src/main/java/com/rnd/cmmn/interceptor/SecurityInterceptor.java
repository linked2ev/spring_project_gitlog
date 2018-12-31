package com.rnd.cmmn.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.rnd.cmmn.security.SessionsUser;

/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn.interceptor
* 2. 타입명 : SecurityInterceptor.java
* 3. 작성일 : 2017. 11. 28.
* 5. 설명 : Web Access Security Interceptor
* </pre>
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	static final Logger logger = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	@Value("#{config['webRootDomain']}")
  	String webRootDomain;
	
	@Value("#{config['admRootDomain']}")
	String admRootDomain;
	
	@Value("#{config['file.webRootPath']}")
  	String webRootPath;
	
	@Value("#{config['file.uploadPath']}")
	String uploadPath;
	
	@Value("#{config['amoreAdminNum']}")
	String amoreAdminNum;
	
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
    	logger.info("=============== SecurityInterceptor :: 시작 ================");

    	boolean result = false;
        
        String uri = request.getRequestURI().toString().trim();
        
        try 
        {
        	/**
        	 * fo 사용자
        	 */
        	if(uri.indexOf("/fo/") > -1)
        	{
        		/**
        		 * 공통 제외 URL
        		 */
                if(excludeUrl(request))
                {
                    result = true;
                }
                else
                {
                    /**
                     * 사용자 세션 NULL 확인
                     */
                    if(SessionsUser.isLogin(request))
                    {
                    	Map<String, Object> sessionUserInfo = SessionsUser.getSessionMap(request, "__SESSION_USER_INFO__");
                    	
                		// Attribute 저장
                		request.setAttribute("SESSION_USER_INFO", sessionUserInfo);
                		request.setAttribute("SESSION_NAME", sessionUserInfo.get("SESSION_NAME"));
                		request.setAttribute("REQUEST_URI", uri);
                		
        				result = true;
                    }
                    else
                    {
                    	// ajax 처리
                    	if(isAjaxRequest(request))
                        {
                            result = true;
                        }
                    	// 예외 url 처리
                        else
                        { 
                        	if(uri.indexOf("/fo/sample/testPage") > -1)
                        	{
                        		String param = "?no=" + request.getParameter("no");
                        		request.setAttribute("loginReturnUrl", uri + param);
                        		
                                result = true;
                        	}
                        	else if(uri.indexOf("/fo/sample/testPage2") > -1)
                        	{
                        		String param = "?no=" + request.getParameter("no");
                        		request.setAttribute("loginReturnUrl", uri + param);
                        		
                        		result = true;
                        	}
                        	else
                        	{
                        		response.sendRedirect(webRootDomain + "/fo/sc/login.do");  
                        		result = false;
                        	}
                        }	
                    }
                }
        	}
        	else
        	{
        		response.sendRedirect(webRootDomain + "/error.jsp");
        		result = true;
        	}
        } 
        catch (Exception e) 
        {
        	logger.error("/n #################### SecurityInterceptor :: Exception ####################");
            //e.printStackTrace();
            //logger.error(e.getMessage());
            logger.error("/n #################### SecurityInterceptor :: Exception ####################");
            return false;
        }
        
        /* *** config *** */
        request.setAttribute("webRootDomain", webRootDomain);
        request.setAttribute("admRootDomain", admRootDomain);
        request.setAttribute("webRootPath", webRootPath);
        request.setAttribute("uploadPath", uploadPath);
        logger.info("=============== SecurityInterceptor :: 종료 ===============");
          
        return result;
    }
    
    private boolean excludeUrl(HttpServletRequest request) {
    	
    	boolean result = false;
    	
        String uri = request.getRequestURI().toString().trim();
        
        if (uri.indexOf("/login.do") > -1 || uri.indexOf("Proc") > -1 || uri.indexOf("/logout.do") > -1)
        {
        	result = true;
        }
        else 
        {
        	result = false;
        }
        
        return result;
    }
    
    private boolean isAjaxRequest(HttpServletRequest request) 
    {
        String requestedWithHeader = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(requestedWithHeader);
    }
    
}

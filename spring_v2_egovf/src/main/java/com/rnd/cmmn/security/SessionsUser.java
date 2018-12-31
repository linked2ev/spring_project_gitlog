package com.rnd.cmmn.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.com.util.StringUtil;

/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn.security
* 2. 타입명 : SessionsUser.java
* 3. 작성일 : 2017. 10. 30.
* 4. 설명 : 사용자 세션 클래스
* </pre>
 */
public class SessionsUser {

	
	static final Logger logger = LoggerFactory.getLogger(SessionsUser.class);
	
    /**
    * <pre>
    * 1. 메소드명 : setSessionUser
    * 2. 작성일 : 2017. 10. 26.
    * 3. 설명 : 사용자 상세정보를 세션에 저장
    * </pre>
    * @param request
    * @param mstPanelMap
     */
    public static void setSessionUser(HttpServletRequest request, Map<String, Object> panelMap)
    {
    	HttpSession session = request.getSession();
        session.invalidate();
        
        session = request.getSession();
        Map<String, Object> sessionUserInfoMap = new HashMap<String, Object>();
        
        sessionUserInfoMap.put("SESSION_USER_ID", StringUtil.getString(panelMap.get("USER_ID"), ""));
        sessionUserInfoMap.put("SESSION_NAME", StringUtil.getString(panelMap.get("NAME"), ""));
    	
        session.setAttribute("__SESSION_USER_INFO__", sessionUserInfoMap);
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getSessionMap
    * 2. 작성일 : 2017. 10. 27.
    * 3. 설명 : 세션을 맵 형태로 가져온다. sessionName : 가져 올 세션맵 이름
    * </pre>
    * @param request
    * @param sessionGbn
    * @return
     */
    @SuppressWarnings("unchecked")
	public static Map<String, Object> getSessionMap(HttpServletRequest request, String sessionName)
	{
        return (Map<String, Object>) request.getSession().getAttribute(sessionName);
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getSessionValue
    * 2. 작성일 : 2017. 10. 30.
    * 3. 설명 : 세션 value값을 가져온다.
    * </pre>
    * @param request
    * @return
     */
    @SuppressWarnings("unchecked")
	public static Map<String, Object> getSessionUserValue(HttpServletRequest request, String sessionName)
    {
        try
        {
            return (Map<String, Object>)request.getSession().getAttribute(sessionName);
        }
        catch (Exception e)
        {
            return new HashMap<String, Object>();
        }
    }
    
    /**
    * <pre>
    * 1. 메소드명 : isLogin
    * 2. 작성일 : 2017. 10. 27.
    * 3. 설명 : 패널 로그인 확인
    * </pre>
    * @param request
    * @return
     */
    public static boolean isLogin(HttpServletRequest request){
    	
    	Map<String, Object> sessionMap = getSessionMap(request, "__SESSION_USER_INFO__");
    	if(sessionMap != null){
    		if(!"".equals(StringUtil.getString(sessionMap.get("SESSION_USER_ID"), ""))){
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
    * <pre>
    * 1. 메소드명 : setSessionDelete
    * 2. 작성일 : 2017. 10. 31.
    * 3. 설명 : 해당 세션을 삭제한다.
    * </pre>
    * @param request
    * @param sessionName : 가져 올 세션맵 이름
     */
    public static void setSessionDelete(HttpServletRequest request, String sessionName){
        HttpSession session = request.getSession();
        session.setAttribute(sessionName, null);
    }
    
}

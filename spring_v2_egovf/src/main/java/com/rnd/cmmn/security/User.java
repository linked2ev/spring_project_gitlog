package com.rnd.cmmn.security;

import java.util.HashMap;
import java.util.Map;

/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn.security
* 2. 타입명 : User.java
* 3. 작성일 : 2017. 10. 30.
* 4. 설명 : 사용자 VO
* </pre>
 */
public class User {

    static public enum USERAUTH{
        user
    }

    static public Map<USERAUTH, Integer> auths = new HashMap<USERAUTH, Integer>();

    static{
    	auths.put(USERAUTH.user, 00);
    }
    
    USERAUTH USER_AUTH = USERAUTH.user;
    
	String loginReqState = "LOGIN_FAIL";  // 로그인 상태 코드
    
    String USER_ID = "";     // 아이디
    String USER_PW = "";     // 비밀번호
    String NAME = "";        // 이름
    
    String IP = "";          // 접속 IP

    
	public static Map<USERAUTH, Integer> getAuths() {
		return auths;
	}

	public static void setAuths(Map<USERAUTH, Integer> auths) {
		User.auths = auths;
	}

	public USERAUTH getUSER_AUTH() {
		return USER_AUTH;
	}

	public void setUSER_AUTH(USERAUTH uSER_AUTH) {
		USER_AUTH = uSER_AUTH;
	}

	public String getLoginReqState() {
		return loginReqState;
	}

	public void setLoginReqState(String loginReqState) {
		this.loginReqState = loginReqState;
	}

	public String getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(String uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSER_PW() {
		return USER_PW;
	}

	public void setUSER_PW(String uSER_PW) {
		USER_PW = uSER_PW;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String iP) {
		IP = iP;
	}
    
}


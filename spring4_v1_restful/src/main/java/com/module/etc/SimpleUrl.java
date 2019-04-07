package com.module.etc;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmmn.util.StringUtil;

/**
* <pre>
* 1. 패키지명 : com.module.etc
* 2. 타입명 : simpleUrl.java
* 3. 작성일 : 2017. 11. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 단축 URL 생성하는 클래스  (NAVER API 관련 문서 확인)
* </pre>
 */
public class SimpleUrl {

	static final Logger logger = LoggerFactory.getLogger(SimpleUrl.class);
	
	/**
	* <pre>
	* 1. 메소드명 : getSimpleUrl
	* 2. 작성일 : 2017. 11. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 단축 URL 생성
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
    public Map<String, Object> getSimpleUrl(HttpServletRequest request, Map<String, Object> commandMap) throws Exception 
    {
    	logger.debug("============================== getSimpleUrl 시작 ==============================");
    	
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	
    	String id = StringUtil.getString(commandMap.get("id"), "");
    	
    	// NAVER KEY 값
        String clientId     = "P0SZCBFMGrhjlbjbSPLA";  // 애플리케이션 클라이언트 아이디값";
        String clientSecret = "JNx9cpq6uh";            // 애플리케이션 클라이언트 시크릿값";
        
        try 
        {
        	// 단축 URL
        	String text = "https://test.com/test.do?id=" + id;
        	
            String apiURL = "https://openapi.naver.com/v1/util/shorturl";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            
            con.setRequestMethod("POST");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            
            // post request
            String postParams = "url=" + text;
            con.setDoOutput(true);
            
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            
            JSONParser jsonParser = new JSONParser();
            
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.toString());
            
            JSONObject result = (JSONObject) jsonObject.get("result");
            String simpleUrl = (String) result.get("url");
            
            returnMap.put("simpleUrl", simpleUrl);
        } 
        catch (Exception e) 
        {
        	logger.error("###################### [SimpleUrl: Exception] ###################### ");
        	e.printStackTrace();
        	logger.error("###################### [SimpleUrl: Exception] ###################### ");
        }
        
    	logger.debug("\n ============================== getSimpleUrl 종료 ==============================");
    
 		return returnMap;
	}      
    
}

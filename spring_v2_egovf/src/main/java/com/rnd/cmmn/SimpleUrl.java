package com.rnd.cmmn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn
* 2. 타입명 : simpleUrl.java
* 3. 작성일 : 2017. 11. 8.
* 4. 설명 : Naver 단축 URL 생성
* </pre>
 */
public class SimpleUrl {

	static final Logger logger = LoggerFactory.getLogger(SimpleUrl.class);
	
	/**
	* <pre>
	* 1. 메소드명 : getSimpleUrl
	* 2. 작성일 : 2017. 11. 8.
	* 3. 설명 : 단축 URL 생성
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws IOException
	 */
    public Map<String, Object> getSimpleUrl(HttpServletRequest request, Map<String, Object> commandMap) throws IOException 
    {
    	logger.info("============================== getSimpleUrl 시작 ==============================");
    	
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	
        String clientId     = "SDACSACESDADASDSTEST";  //애플리케이션 클라이언트 아이디값";
        String clientSecret = "ASCASDw1e2";            //애플리케이션 클라이언트 시크릿값";
        
        try 
        {
        	String text = commandMap.get("textUrl").toString();
        	
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
        	e.printStackTrace();
        }
        
    	logger.info("============================== getSimpleUrl 종료 ==============================");
    
 		return returnMap;
	}      
    
}

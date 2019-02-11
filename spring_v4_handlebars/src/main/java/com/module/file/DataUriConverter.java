package com.module.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cmmn.util.StringUtil;


/**
* <pre>
* 1. 패키지명 : com.module.file
* 2. 타입명 : DataUriConverter.java
* 3. 작성일 : 2017. 12. 27.
* 4. 작성자 : linked2ev
* 5. 설명 : DataUri 형태 데이터를 이미지 파일로 업로드하는 클래스
* </pre>
 */
public class DataUriConverter {
	  
	static final Logger logger = LoggerFactory.getLogger(DataUriConverter.class);
	
	/**
	* <pre>
	* 1. 메소드명 : dataUriUpload
	* 2. 작성일 : 2017. 12. 27.
	* 3. 작성자 : linked2ev
	* 4. 설명 : DataUri 형태 데이터를 이미지 파일로 업로드
	* </pre>
	* @param request
	* @param commandMap
	* @param dirName : 업로드 경로 폴더 이름 ~/upload/{dirName}/파일명.png
	* @return
	* @throws Exception
	 */
	public Map<String, Object> dataUriUpload(HttpServletRequest request, Map<String, Object> commandMap, String dirName) throws Exception
	{ 
		logger.debug("\n=================================== DataUriConverter 시작 ===================================");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		String webRootPath = (String) request.getAttribute("webRootPath");  // 상대경로
		String uploadPath  = (String) request.getAttribute("uploadPath");   // 절대경로
		
		/* *** 데이터 바인딩 *** */
		String id 		= StringUtil.getString(commandMap.get("ID"), "");
	    String userId   = StringUtil.getString(commandMap.get("USER_ID"), "");
		String signData = StringUtil.getString(commandMap.get("AGREE_SIGN_DATAURL"), "");
		String signId   = StringUtil.getString(commandMap.get("AGREE_SIGN_ID"), "");
		
		try 
	    {
			signData = signData.substring(signData.indexOf(",")+1);
			byte[] imgBtyes = Base64.decodeBase64(signData.getBytes());
			 
		    Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		
	        // 디렉토리 경로 설정
	        webRootPath = webRootPath + dirName +"/"+ sdf.format(d) +"/"+"ID"+ id+ "_" +userId +"_"+ signId+".png";
	        uploadPath  = uploadPath  + dirName +"/"+ sdf.format(d) +"/"+"ID"+ id+ "_" +userId +"_"+ signId+".png";
		    
	        // 디렉토리 존재하지 않을 경우 디렉토리 생성
	        File file = new File(uploadPath);
	        if(!file.exists()) 
	        {
	            file.mkdirs();
	        }
	        
	        // 파일 존재 시 파일 삭제
	        if(file.exists()){
	            if(file.delete()){
	            	logger.info("\n >> 파일삭제 성공");
	            }else{
	            	logger.info("\n >> 파일삭제 실패");
	            }
	        }
	        
	        OutputStream os = new FileOutputStream(uploadPath);
			os.write(imgBtyes);
			os.close();
			os.flush();
			
			returnMap.put("webRootPath", webRootPath);  // 상대경로
	        returnMap.put("uploadPath", uploadPath);    // 절대경로
	    }
		catch (IOException e)
		{
			logger.error("\n #################### [DataUriConverter: Exception] ####################");
			logger.error(e.getMessage());
			e.printStackTrace();
			logger.error("\n #################### [DataUriConverter: Exception] ####################");
			returnMap = null;
		}
			
		logger.debug("\n=================================== DataUriConverter 종료 ===================================");
		 
		return returnMap; 
	}

}

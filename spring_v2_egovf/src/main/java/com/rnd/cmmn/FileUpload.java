package com.rnd.cmmn;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn
* 2. 타입명 : FileUpload.java
* 3. 작성일 : 2017. 11. 3.
* 4. 설명 : 파일업로드하는 클래스
* </pre>
 */
public class FileUpload {

	static final Logger logger = LoggerFactory.getLogger(FileUpload.class);
	
	
	/**
	* <pre>
	* 1. 메소드명 : FileUpload
	* 2. 작성일 : 2017. 11. 20.
	* 3. 설명 : 파일첨부 업로드
	* </pre>
	* @param request
	* @param commandMap
	* @param dirName
	* @return
	* @throws Exception
	* @throws FileUploadException
	 */
	public Map<String, Object> FileUpload(MultipartHttpServletRequest request, Map<String, Object> commandMap, String dirName) throws Exception, FileUploadException
	{
		logger.info("============================= FileUpload 시작 =============================");
	
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		String webRootPath = (String) request.getAttribute("webRootPath");
		String uploadPath  = (String) request.getAttribute("uploadPath");
		MultipartFile multipartFile  = null;
		String storedFileName        = null;  // 저장된 파일명
    	String originalFileName      = "";    // 원본 파일명
    	String originalFileExtension = "";    // 원본 확장자명
    	
    	
    	try
    	{
		    Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	        
	        // 디렉토리 경로
	        webRootPath = webRootPath + dirName +"/"+ sdf.format(d);
	        uploadPath  = uploadPath  + dirName +"/"+ sdf.format(d);
	        logger.info("\n >> [uploadPath 경로] : " + uploadPath);
	    	
	        
	        // 디렉토리 존재하지 않을경우 디렉토리 생성
	        File file = new File(uploadPath);
	        if(!file.exists())
	        {
	            file.mkdirs();
	        }
	        
	        // 파일 업로드
	    	Iterator<String> iterator = request.getFileNames();
	    	while(iterator.hasNext())
	    	{
	    		multipartFile = request.getFile(iterator.next());
	    		if(multipartFile.isEmpty() == false)
	    		{
	    			originalFileName = multipartFile.getOriginalFilename();
	    			originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
	    			storedFileName = uploadPath +"/" + UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
	    			
	    		    logger.debug("==================== file data ====================");
		            logger.debug("> ORIGIN_FILE_NAME : " + originalFileName);                                                  // 원 파일명
		            logger.debug("> FILE_NAME        : " + originalFileName.substring(0, originalFileName.lastIndexOf(".")));  // 파일명
		            logger.debug("> FILE_TYPE        : " + originalFileExtension.replace(".", ""));                            // 파일타입
		            logger.debug("> SAVE_URL         : " + storedFileName);                                                    // 저장경로
		            logger.debug("==================== file data ====================");
		            
	                returnMap.put("ORIGIN_FILE_NAME", originalFileName); 
	                returnMap.put("FILE_NAME", originalFileName.substring(0, originalFileName.lastIndexOf(".")));           
                    returnMap.put("FILE_TYPE", originalFileExtension.replace(".", ""));  
                    returnMap.put("SAVE_URL", storedFileName);     
		   
	    			// 업로드 파일 저장
	    			file = new File(storedFileName);
	    			multipartFile.transferTo(file);
	    		}
	    	}
	    	
		}
		catch (Exception e) 
		{
			logger.info("\n #################### [FileUpload: Exception] ####################");
			logger.error(e.getMessage());
			e.printStackTrace();
			logger.info("\n #################### [FileUpload: Exception] ####################");
			returnMap = null;
		}
		
        logger.info("=============================== FileUpload 종료 ===============================");
        
		return returnMap;
	}

}

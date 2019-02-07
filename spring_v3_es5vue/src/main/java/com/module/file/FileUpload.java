package com.module.file;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import egovframework.rte.fdl.property.EgovPropertyService;


/**
* <pre>
* 1. 패키지명 : com.module.file
* 2. 타입명 : FileUpload.java
* 3. 작성일 : 2017. 12. 27.
* 4. 작성자 : JAMUGE
* 5. 설명 : 파일을 업로드하는 클래스
* </pre>
 */
@Component
public class FileUpload {

	static final Logger logger = LoggerFactory.getLogger(FileUpload.class);
	
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
	/**
	* <pre>
	* 1. 메소드명 : FileUpload
	* 2. 작성일 : 2017. 12. 27.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 파일 업로드
	* </pre>
	* @param request
	* @param commandMap
	* @param dirName : 업로드 경로 폴더 이름 ~/upload/{dirName}/파일명.png
	* @return
	* @throws Exception
	 */
	public Map<String, Object> FileUpload(MultipartHttpServletRequest request, Map<String, Object> commandMap, String dirName) throws Exception
	{
		logger.debug("\n=====================================================================================");
		logger.debug("\n================================== FileUpload 시작 ==================================");
	
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		String webRootPath = (String) request.getAttribute("webRootPath");  // 상대경로
		String uploadPath  = (String) request.getAttribute("uploadPath");   // 절대경로
		MultipartFile multipartFile = null;  // 멀티파트파일
		String storedFileName       = null;  // 저장된 파일명
    	String originalFileName     = "";    // 원본 파일명
    	String originalFileExt      = "";    // 원본 확장자명
    	
    	try
    	{
		    Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	        
	        // 디렉토리 경로
	        webRootPath = webRootPath + dirName +"/"+ sdf.format(d);
	        uploadPath  = uploadPath  + dirName +"/"+ sdf.format(d);
	        
	        // 디렉토리 존재하지 않을경우 디렉토리 생성
	        File file = new File(uploadPath);
	        if(!file.exists())
	        {
	            file.mkdirs();
	        }
	         
	        // 파일 업로드
	    	Iterator<String> iterator = request.getFileNames();
	    	System.out.println(">> iterator: " + iterator);
	    	while(iterator.hasNext())
	    	{
	    		multipartFile = request.getFile(iterator.next());
	    		List<CommonsMultipartFile> fileList = (List) request.getFiles(multipartFile.getName());
	    		System.out.println(">> file Name : " + multipartFile);
	    		
	    		if(multipartFile.isEmpty() == false)
	    		{
	    			System.out.println(">> fileList.size() : " + fileList.size());
	    			for(int i=0; i<fileList.size(); i++){
	    				CommonsMultipartFile sFile = fileList.get(i);
	    				
	    				originalFileName = sFile.getOriginalFilename();
	    				originalFileExt  = originalFileName.substring(originalFileName.lastIndexOf("."));
		    			storedFileName   = uploadPath + "/" + UUID.randomUUID().toString().replaceAll("-", "") + originalFileExt;
		    			logger.info("\n ==================== file data ====================");
				        logger.info(">> ORIGIN_FILE_NAME : " + originalFileName);
				        logger.info(">> FILE_NAME        : " + originalFileName.substring(0, originalFileName.lastIndexOf(".")));
				        logger.info(">> FILE_TYPE        : " + originalFileExt.replace(".", ""));
				        logger.info(">> SAVE_URL         : " + storedFileName);
				        logger.info("\n ==================== file data ====================");
	    			}
		            
	                returnMap.put("ORIGIN_FILE_NAME", originalFileName);                                           // 원 파일명
	                returnMap.put("FILE_NAME", originalFileName.substring(0, originalFileName.lastIndexOf(".")));  // 파일명
                    returnMap.put("FILE_EXT", originalFileExt.replace(".", ""));                                   // 파일 확장자
                    returnMap.put("SAVE_URL", storedFileName);                                                     // 저장경로
                    
                    String sss = propertiesService.getString("file.permitExt.image");
                       
                    System.out.println(">> image : " + sss);
                     
                    
//                    returnMap.put("CMN_FLE_WEB_PATH", uploadFile.getSystemPath());
//                    returnMap.put("CMN_FLE_SAVE_PATH", uploadFile.getAttachPath());
//                    returnMap.put("CMN_FLE_ORG_NM", uploadFile.getOriginalFileName());
//                    returnMap.put("CMN_FLE_NM", uploadFile.getFileName());
//                    returnMap.put("CMN_FLE_SIZE", Long.toString(uploadFile.getFileSize()));
//                    returnMap.put("CMN_FLE_EXT", uploadFile.getExt());
//                    returnMap.put("CMN_FLE_TYPE", "Y");
                    
		   
	    			// 파일 업로드
	    			file = new File(storedFileName);
	    			multipartFile.transferTo(file);
	    		}
	    	}
		}
		catch (IOException e)
		{
			logger.error("\n #################### [FileUpload: Exception] ####################");
			logger.error(e.getMessage());
			e.printStackTrace();
			logger.error("\n #################### [FileUpload: Exception] ####################");
			returnMap = null;
		}
		
        logger.debug("\n=================================== FileUpload 종료 ===================================");
        
		return returnMap;
	}

}

package com.module.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import com.cmmn.util.StringUtil;


/**
* <pre>
* 1. 패키지명 : com.module.file
* 2. 타입명 : FileDownload.java
* 3. 작성일 : 2017. 12. 27.
* 4. 작성자 : JAMUGE
* 5. 설명 : 파일을 다운로드 하는 클래스
* </pre>
 */
public class FileDownload {

	static final Logger logger = LoggerFactory.getLogger(FileDownload.class);
	
	
	/**
	* <pre>
	* 1. 메소드명 : FileDownload
	* 2. 작성일 : 2017. 12. 27.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 파일 다운로드
	* </pre>
	* @param request
	* @param response
	* @param commandMap
	* @throws Exception
	 */
	public void FileDownload(HttpServletRequest request, HttpServletResponse response, Map<String, Object> commandMap) throws Exception
	{
		logger.debug("\n=====================================================================================");
		logger.debug("\n================================= FileDownload 시작 =================================");
		
		/* *** 데이터 바인딩 *** */
		String saveurl  = StringUtil.getString(commandMap.get("SAVE_URL"), "");          // 저장된 파일 절대경로
		String filename = StringUtil.getString(commandMap.get("ORIGIN_FILE_NAME"), "");  // 저장된 파일명
		String filetype = StringUtil.getString(commandMap.get("FILE_TYPE"), "");         // 저장된 파일타입
		/* ********************* */
        
        OutputStream outputStream = null;
        
        try {
            File file = new File(saveurl);
    
            if (filetype.trim().equalsIgnoreCase("txt")) {
            	response.setContentType("text/plain");
            } else {
            	response.setContentType("application/octet-stream");
            }
    
            response.setContentLength((int) file.length());
    
            boolean ie = request.getHeader("User-Agent").indexOf("MSIE") != -1;
            if (ie) {
                filename = URLEncoder.encode(filename, "UTF-8").replaceAll("\\+", " ");
            } else {
                filename = new String(filename.getBytes("UTF-8"), "8859_1");
            }
    
            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
    
            outputStream = response.getOutputStream();
            FileInputStream fis = null;
            
            try {
                fis = new FileInputStream(file);
                FileCopyUtils.copy(fis, outputStream);
            } finally {
                if (fis!= null) {
                    fis.close();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                outputStream.close();
                response.flushBuffer();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		
        logger.debug("\n================================== FileDownload 종료 ==================================");
	}

}

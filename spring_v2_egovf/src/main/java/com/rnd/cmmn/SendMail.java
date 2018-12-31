package com.rnd.cmmn;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.com.util.MathUtil;
import com.com.util.StringUtil;
 
/**
* <pre>
* 1. 패키지명 : com.rdpanel.cmmn
* 2. 타입명 : SendMail.java
* 3. 작성일 : 2017. 11. 3.
* 4. 설명 : SMPT 메일/파일 첨부 하는 클래스이다.
* </pre>
 */
public class SendMail {
	
	static final Logger logger = LoggerFactory.getLogger(SendMail.class);
	
	final String emailId = "testemail@gmail.com";
	final String emailPw = "test1234";
	
	final String auth              = "false";
	final String enable            = "true";
	final String host              = "web.testhost.com";
	final String port              = "25";
	final String connectiontimeout = "10000";
	final String timeout           = "12000";
	
	/**
	* <pre>
	* 1. 메소드명 : SendSMTP
	* 2. 작성일 : 2017. 11. 3.
	* 3. 설명 : SMPT (파일 포함)
	* </pre>
	* @param request
	* @param commandMap
	* @param dirName
	* @return
	* @throws Exception
	* @throws FileUploadException
	 */
	@SuppressWarnings("unused") 
	public Map<String, Object> SendSMTP(MultipartHttpServletRequest request, Map<String, Object> commandMap, String dirName) throws Exception, FileUploadException
	{
		logger.info("=================================== SendMail 시작 ===================================");
	
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("SUCCESS", "Y");
		
		String webRootPath = (String) request.getAttribute("webRootPath");
		String uploadPath  = (String) request.getAttribute("uploadPath");
		MultipartFile multipartFile  = null;
		String storedFileName        = null;  // 저장된 파일명
    	String originalFileName      = "";    // 원본 파일명
    	String originalFileExtension = "";    // 원본 확장자명
    	
		
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
    	while(iterator.hasNext())
    	{
    		multipartFile = request.getFile(iterator.next());
    		if(multipartFile.isEmpty() == false)
    		{
    			originalFileName = multipartFile.getOriginalFilename();
    			originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
    			storedFileName = uploadPath +"/" + UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;
    			
    			// 업로드 파일 저장
    			file = new File(storedFileName);
    			multipartFile.transferTo(file);
    		}
    	}
		/* *** [관리자] 패널들에게 이메일 보내기 *** */
		
    	// SMTP 서버 정보 설정
		Properties props = new Properties();
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.starttls.enable", enable);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.connectiontimeout", connectiontimeout);            
		props.put("mail.smtp.timeout", timeout);        
		
		// 메일 인증
        MailAuthentication mailAuth = new MailAuthentication(emailId, emailPw);
        
        // session 생성 및  MimeMessage생성
        Session session = Session.getDefaultInstance(props, mailAuth);
        session.setDebug(true);
       
        MimeMessage msg = new MimeMessage(session);
         
        try
        {
        	String bodyHtml  = "";  // 전체 이메일 내용
        	String fromEmail = "";  // 보내는 사람 이메일
        	String qnaGbn    = "";  // 질문 구분
        	String title     = "";  // 제목
        	String fromName  = "";
            String content   = "";
             
        	msg.setSentDate(new Date());
            
    		// 발신자 이메일 정보
    		fromEmail = StringUtil.getString(commandMap.get("EMAIL"), "");    // 답변받을 사람 이메일
    		fromName  = StringUtil.getString(commandMap.get("NAME"), "");     // 답변받을 사람 이름
    		title     = StringUtil.getString(commandMap.get("TITLE"), "");    // 제목
    		content   = StringUtil.getString(commandMap.get("CONTENTS"), "").replace(System.getProperty("line.separator"), "</br>"); // 내용
    		bodyHtml += "답변받을 사람 이메일 : " + fromName + "</br></br>";
    		bodyHtml += "답변받을 사람 이름   : " + fromEmail + "</br></br>";
    		bodyHtml += "질문내용 : </br>" + content;
    				
    		// 이메일 발신자
            InternetAddress from = new InternetAddress() ;
            from = new InternetAddress(emailId);
            msg.setFrom(from);
            
            // 이메일 수신자(관리자)
        	InternetAddress to = new InternetAddress(emailId);
        	msg.setRecipient(Message.RecipientType.TO, to);
            
        	// 이메일 제목
            msg.setSubject(title, "UTF-8");
             
            // 이메일 헤더
            msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
             
            // bodyHtml
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(bodyHtml, "text/html; charset=utf-8");

            // add it
            MimeMultipart mp = new MimeMultipart();
            mp.addBodyPart(messageBodyPart);
            
        	String filename = storedFileName;
            if(filename != null)
            {
                if(fileSizeCheck(filename))
                {
                    MimeBodyPart mbp2 = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(filename);
                    mbp2.setDataHandler(new DataHandler(fds));
                    mbp2.setFileName(MimeUtility.encodeText(originalFileName, "UTF-8", "B"));                    
                    mp.addBodyPart(mbp2);
                }
                else
                {
            		logger.debug("###################### 업로드 용량 초과 ###################### ");
            		returnMap = null;
                    throw new Exception("file size overflow !");
                }
            }

            msg.setContent(mp);
            
            // 메일보내기
            javax.mail.Transport.send(msg);
            
		}
		catch (AddressException addr_e) 
		{
			logger.error(addr_e.getMessage());
			addr_e.printStackTrace();
			returnMap = null;
		}
		catch (MessagingException msg_e) 
		{
			logger.error(msg_e.getMessage());
			msg_e.printStackTrace();
			returnMap = null;
		}
        
        logger.info("=================================== SendMail 종료 ===================================");
        
		return returnMap;
	}
	
	/**
	* <pre>
	* 1. 메소드명 : SendSMTP
	* 2. 작성일 : 2018. 1. 31.
	* 3. 설명 : SMPT
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	@SuppressWarnings("unused") 
	public void SendSMTP(HttpServletRequest request, Map<String, Object> commandMap) throws Exception
	{
		// SMTP 서버 정보 설정
		Properties props = new Properties();
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.starttls.enable", enable);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.connectiontimeout", connectiontimeout);            
		props.put("mail.smtp.timeout", timeout);        
		
		// 메일 인증
		MailAuthentication mailAuth = new MailAuthentication(emailId, emailPw);
		
		// session 생성 및  MimeMessage생성
		Session session = Session.getDefaultInstance(props, mailAuth);
		session.setDebug(true);
		
		MimeMessage msg = new MimeMessage(session);
		
		try
		{
			String title        = StringUtil.getString(commandMap.get("title"), "");
			String contents     = StringUtil.getString(commandMap.get("contents"), "");
			String receiveEmail = StringUtil.getString(commandMap.get("receiveEmail"), "");
			
			msg.setSentDate(new Date());
			
			// 이메일 발신자
			InternetAddress from = new InternetAddress() ;
			from = new InternetAddress(emailId);
			msg.setFrom(from);

			// 이메일 수신자: 본인
			InternetAddress to = new InternetAddress(receiveEmail);
			msg.setRecipient(Message.RecipientType.TO, to);
			
			// 이메일 제목
			msg.setSubject(title, "UTF-8");
			
			// 이메일 헤더
			msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
			
			// 이메일 내용
			msg.setContent(contents, "text/html; charset=utf-8");
			
			// 메일보내기
			javax.mail.Transport.send(msg);
			
		}
		catch (AddressException addr_e) 
		{
			addr_e.printStackTrace();
		}
		catch (MessagingException msg_e) 
		{
			msg_e.printStackTrace();
		}
	}
	
	/**
	* <pre>
	* 1. 메소드명 : fileSizeCheck
	* 2. 작성일 : 2017. 11. 3.
	* 3. 설명 : 첨부파일 사이즈 체크
	* </pre>
	* @param filename
	* @return
	 */
	protected boolean fileSizeCheck(String filename)
	{
	    if (new File(filename).length() > (1024 * 1024 * 2.5)) 
	    {
	        return false;
	    }
	    return true;
	}    

	/**
	* <pre>
	* 1. 메소드명 : fileSizeCheck
	* 2. 작성일 : 2017. 11. 3.
	* 3. 설명 : 시스템에서 사용하는 인증정보
	* </pre>
	* @param filename
	* @return
	 */
	class MailAuthentication extends Authenticator {
	      
	    PasswordAuthentication pa;
	 
	    public MailAuthentication(String emailId, String emailPw){
	   
	        pa = new PasswordAuthentication(emailId, emailPw);
	    }
	    
	    public PasswordAuthentication getPasswordAuthentication() {
	        return pa;
	    }
	} 

}


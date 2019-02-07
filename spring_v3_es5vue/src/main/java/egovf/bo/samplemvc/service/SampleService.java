package egovf.bo.samplemvc.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
* <pre>
* 1. 패키지명 : egovf.bo.samplemvc.service
* 2. 타입명 : SampleService.java
* 3. 작성일 : 2017. 12. 22.
* 4. 작성자 : JAMUGE
* 5. 설명 : SampleService > Interface
* </pre>
 */
public interface SampleService {

	/**
	* <pre>
	* 1. 메소드명 : getSampleListCnt
	* 2. 작성일 : 2017. 12. 22.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 목록 갯수
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public int getSampleListCnt(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

	/**
	* <pre>
	* 1. 메소드명 : getSampleList
	* 2. 작성일 : 2017. 12. 22.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public List<Map<String, Object>> getSampleList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

	/**
	* <pre>
	* 1. 메소드명 : getSampleView
	* 2. 작성일 : 2017. 12. 26.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 상세정보
	* </pre>
	* @param request
	* @param commandMap
	* @return
	 */
	public Map<String, Object> getSampleView(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

	/**
	* <pre>
	* 1. 메소드명 : insertSample
	* 2. 작성일 : 2017. 12. 27.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 등록(첨부파일)
	* </pre>
	* @param request
	* @param commandMap
	 */
	public int insertSample(MultipartHttpServletRequest request, Map<String, Object> commandMap) throws Exception;

}

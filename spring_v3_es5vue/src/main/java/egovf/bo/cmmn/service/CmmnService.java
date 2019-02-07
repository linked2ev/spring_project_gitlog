package egovf.bo.cmmn.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
* <pre>
* 1. 패키지명 : egovf.bo.cmmn.service
* 2. 타입명 : SampleService.java
* 3. 작성일 : 2017. 12. 22.
* 4. 작성자 : JAMUGE
* 5. 설명 : 공통 Service
* </pre>
 */
public interface CmmnService {


	/**
	* <pre>
	* 1. 메소드명 : getCodeList
	* 2. 작성일 : 2017. 12. 22.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 공통 코드 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public List<Map<String, Object>> getCodeList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

}

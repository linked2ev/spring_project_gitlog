package mall.fo.cmmn.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
* <pre>
* 1. 패키지명 : mall.fo.cmmn.service
* 2. 타입명 : CmmnService
* 3. 작성일 : 2019. 2. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 공통 Service
* </pre>
 */
public interface CmmnService {


	/**
	* <pre>
	* 1. 메소드명 : getCodeList
	* 2. 작성일 : 2019. 2. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 공통 코드 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public List<Map<String, Object>> getCodeList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

}

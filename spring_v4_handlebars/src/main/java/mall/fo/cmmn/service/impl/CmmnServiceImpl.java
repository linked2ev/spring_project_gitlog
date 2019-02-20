package mall.fo.cmmn.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.cmmn.dao.CmmnMapperDAO;

import mall.fo.cmmn.service.CmmnService;


/**
* <pre>
* 1. 패키지명 : mall.fo.cmmn.service.impl
* 2. 타입명 : CmmnServiceImpl
* 3. 작성일 : 2019. 2. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 공통 ServiceImpl
* </pre>
 */
@Service("cmmnService")
public class CmmnServiceImpl implements CmmnService {

	@Resource(name="cmmnMapperDAO")
	private CmmnMapperDAO CmmnMapperDAO;

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
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCodeList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		 return CmmnMapperDAO.selectList("Cmmn.getCodeList", commandMap);
	}
    
}

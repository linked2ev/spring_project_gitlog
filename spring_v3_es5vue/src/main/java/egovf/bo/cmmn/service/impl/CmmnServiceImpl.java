package egovf.bo.cmmn.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.cmmn.dao.CmmnMapperDAO;

import egovf.bo.cmmn.service.CmmnService;


/**
* <pre>
* 1. 패키지명 : egovf.bo.cmmn.service.impl
* 2. 타입명 : CmmnServiceImpl.java
* 3. 작성일 : 2017. 12. 22.
* 4. 작성자 : JAMUGE
* 5. 설명 : 공통 ServiceImpl
* </pre>
 */
@Service("cmmnService")
public class CmmnServiceImpl implements CmmnService {

//    @Resource(name="cmmnAbstractDAO") 
//    private CmmnAbstractDAO cmmnAbstractDAO;
	
	@Resource(name="cmmnMapperDAO")
	private CmmnMapperDAO CmmnMapperDAO;

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
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getCodeList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		 return CmmnMapperDAO.selectList("Cmmn.getCodeList", commandMap);
	}
    
}

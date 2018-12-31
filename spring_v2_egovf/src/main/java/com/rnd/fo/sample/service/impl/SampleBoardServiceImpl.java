package com.rnd.fo.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.rnd.cmmn.dao.ComnAbstractDAO;
import com.rnd.cmmn.security.SessionsUser;
import com.rnd.fo.sample.service.SampleBoardService;

/**
* <pre>
* 1. 패키지명 : com.rnd.fo.qna.service.impl
* 2. 타입명 : SampleBoardServiceImpl.java
* 3. 작성일 : 2017. 9. 27.
* 4. 설명 : SampleBoardServiceImpl
* </pre>
 */
@Service("sampleBoardService")
public class SampleBoardServiceImpl implements SampleBoardService {
	
    @Resource(name="comnAbstractDAO") 
    private ComnAbstractDAO comnAbstractDAO;
    
    
    /**
    * <pre>
    * 1. 메소드명 : selectSampleBoardListCnt
    * 2. 작성일 : 2017. 9. 27.
    * 3. 설명 : 공지사항 목록 갯수
    * </pre>
    * @param commandMap
    * @return
    * @throws Exception
     */
	public int selectSampleBoardListCnt(HttpServletRequest request, Map<String, Object> commandMap) throws Exception 
	{
		Map<String, Object> userInfo = SessionsUser.getSessionMap(request, "__SESSION_USER_INFO__");
		commandMap.put("USER_ID", userInfo.get("SESSION_USER_ID"));
		return comnAbstractDAO.selectCount("SampleBoard.selectSampleBoardListCnt", commandMap);
	}
	
	/**
	* <pre>
	* 1. 메소드명 : selectSampleBoardList
	* 2. 작성일 : 2017. 9. 27.
	* 3. 설명 : 공지사항 목록
	* </pre>
	* @param commandMap
	* @return
	* @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectSampleBoardList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception 
	{
		Map<String, Object> userInfo = SessionsUser.getSessionMap(request, "__SESSION_USER_INFO__");
		commandMap.put("USER_ID", userInfo.get("SESSION_USER_ID"));
		return comnAbstractDAO.selectList("SampleBoard.selectSampleBoardList", commandMap);
	}

	/**
	* <pre>
	* 1. 메소드명 : selectSampleBoardInfo
	* 2. 작성일 : 2017. 10. 10.
	* 3. 설명 : 공지사항 상세정보
	* </pre>
	* @param commandMap
	* @return
	* @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public Map<String, Object> selectSampleBoardInfo (Map<String, Object> commandMap) throws Exception
    {
        return comnAbstractDAO.select("SampleBoard.selectSampleBoardInfo", commandMap);
    }
    
    /**
    * <pre>
    * 1. 메소드명 : insertSampleBoard
    * 2. 작성일 : 2017. 10. 31.
    * 3. 설명 : 공지사항 글쓰기 등록
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
	public int insertSampleBoard(HttpServletRequest request, Map<String, Object> commandMap) throws Exception 
	{
		Map<String, Object> userInfo = SessionsUser.getSessionMap(request, "__SESSION_USER_INFO__");
		commandMap.put("USER_ID", userInfo.get("SESSION_USER_ID"));
		return comnAbstractDAO.insert("QnaBoard.insertQnaBoardAdd", commandMap);
	}

}

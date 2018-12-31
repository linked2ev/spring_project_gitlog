package com.rnd.fo.sample.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
* <pre>
* 1. 패키지명 : com.rnd.fo.qna.service
* 2. 타입명 : SampleBoardService.java
* 3. 작성일 : 2017. 9. 27.
* 4. 설명 : SampleBoardService 
* </pre>
 */
public interface SampleBoardService {

	
	/**
	* <pre>
	* 1. 메소드명 : selectSampleBoardListCnt
	* 2. 작성일 : 2017. 9. 22.
	* 3. 설명 : 공지사항 목록 갯수
	* </pre>
	* @param commandMap
	* @return
	* @throws Exception
	 */
    public int selectSampleBoardListCnt (HttpServletRequest request, Map<String, Object> commandMap) throws Exception;
    
	/**
	* <pre>
	* 1. 메소드명 : selectSampleBoardList
	* 2. 작성일 : 2017. 9. 22.
	* 3. 설명 : 공지사항 목록
	* </pre>
	* @param commandMap
	* @return
	* @throws Exception
	 */
    public List<Map<String, Object>> selectSampleBoardList (HttpServletRequest request, Map<String, Object> commandMap) throws Exception;
    
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
    public Map<String, Object> selectSampleBoardInfo (Map<String, Object> commandMap) throws Exception;
    
    /**
    * <pre>
    * 1. 메소드명 : insertSampleBoard
    * 2. 작성일 : 2017. 10. 31.
    * 3. 설명 : 공지사항 등록
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
	public int insertSampleBoard(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

}

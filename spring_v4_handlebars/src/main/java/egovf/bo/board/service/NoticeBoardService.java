package egovf.bo.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
* <pre>
* 1. 패키지명 : egovf.bo.board.service
* 2. 타입명 : NoticeBoardService
* 3. 작성일 : 2019. 2. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 공지사항 interface
* </pre>
 */
public interface NoticeBoardService {

	/**
	* <pre>
	* 1. 메소드명 : getNoticeBoardListCnt
	* 2. 작성일 : 2019. 2. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 공지사항 목록 갯수
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public int getNoticeBoardListCnt(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

	/**
	* <pre>
	* 1. 메소드명 : getNoticeBoardList
	* 2. 작성일 : 2019. 2. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 공지사항 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public List<Map<String, Object>> getNoticeBoardList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

	/**
	* <pre>
	* 1. 메소드명 : getNoticeBoardInfo
	* 2. 작성일 : 2019. 2. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 공지사항 상세정보
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public Map<String, Object> getNoticeBoardInfo(HttpServletRequest request, Map<String, Object> commandMap) throws Exception;

	/**
	* <pre>
	* 1. 메소드명 : insertNoticeBoard
	* 2. 작성일 : 2019. 2. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 공지사항 등록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public int insertNoticeBoard(MultipartHttpServletRequest request, Map<String, Object> commandMap) throws Exception;

}

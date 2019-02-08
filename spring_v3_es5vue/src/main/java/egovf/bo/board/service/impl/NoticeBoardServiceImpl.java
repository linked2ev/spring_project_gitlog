package egovf.bo.board.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cmmn.dao.CmmnMapperDAO;
import com.module.file.FileUpload;

import egovf.bo.board.service.NtcBoardService;

/**
* <pre>
* 1. 패키지명 : egovf.bo.board.service.impl
* 2. 타입명 : NtcBoardServiceImpl.java
* 3. 작성일 : 2018. 1. 9.
* 4. 작성자 : JAMUGE
* 5. 설명 : 공지사항 Impl
* </pre>
 */
@Service("ntcBoardService")
public class NtcBoardServiceImpl implements NtcBoardService {

	@Autowired
	private FileUpload fileUpload;

	@Resource(name="cmmnMapperDAO")
	private CmmnMapperDAO CmmnMapperDAO;
	
	/**
	* <pre>
	* 1. 메소드명 : getNtcBoardListCnt
	* 2. 작성일 : 2018. 1. 9.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 공지사항 목록 갯수
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	public int getNtcBoardListCnt(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
        return CmmnMapperDAO.selectCount("NtcBoard.getNtcBoardListCnt", commandMap);
	}

	/**
	* <pre>
	* 1. 메소드명 : getNtcBoardList
	* 2. 작성일 : 2018. 1. 9.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 공지사항 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getNtcBoardList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception  {
        return CmmnMapperDAO.selectList("NtcBoard.getNtcBoardList", commandMap);
	}
	
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
	* @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public Map<String, Object> getSampleView (HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
        return CmmnMapperDAO.select("Sample.getSampleView", commandMap);
    }

    /**
    * <pre>
    * 1. 메소드명 : insertSample
    * 2. 작성일 : 2017. 12. 27.
    * 3. 작성자 : JAMUGE
    * 4. 설명 : 등록(첨부파일: 다중파일 포함)
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
	public int insertSample(MultipartHttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		
		fileUpload.FileUpload(request, commandMap, "sample");
		//CmmnMapperDAO.insert("Cmmn.insertCmmnFile", fileUpload.FileUpload(request, commandMap, "sample"));
		
		//return CmmnMapperDAO.insert("Sample.insertSample", commandMap);
		return 1;
	}
    
}

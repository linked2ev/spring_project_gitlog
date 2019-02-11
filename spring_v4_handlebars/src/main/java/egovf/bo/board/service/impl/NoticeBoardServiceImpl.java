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

import egovf.bo.board.service.NoticeBoardService;

/**
* <pre>
* 1. 패키지명 : egovf.bo.board.service.impl
* 2. 타입명 : NoticeBoardServiceImpl
* 3. 작성일 : 2019. 2. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 공지사항 Impl
* </pre>
 */
@Service("noticeBoardService")
public class NoticeBoardServiceImpl implements NoticeBoardService {

	@Autowired
	private FileUpload fileUpload;

	@Resource(name="cmmnMapperDAO")
	private CmmnMapperDAO CmmnMapperDAO;
	
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
	public int getNoticeBoardListCnt(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
        return CmmnMapperDAO.selectCount("NtcBoard.getNtcBoardListCnt", commandMap);
	}

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
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getNoticeBoardList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception  {
        return CmmnMapperDAO.selectList("NtcBoard.getNtcBoardList", commandMap);
	}
	
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
    @SuppressWarnings("unchecked")
	public Map<String, Object> getNoticeBoardInfo (HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
        return CmmnMapperDAO.select("Sample.getSampleView", commandMap);
    }

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
	public int insertNoticeBoard(MultipartHttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		
		fileUpload.FileUpload(request, commandMap, "sample");
		//CmmnMapperDAO.insert("Cmmn.insertCmmnFile", fileUpload.FileUpload(request, commandMap, "sample"));
		//return CmmnMapperDAO.insert("Sample.insertSample", commandMap);
		return 1;
	}
    
}

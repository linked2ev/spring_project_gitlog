package mall.fo.board.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import mall.fo.board.service.NoticeBoardService;

/**
* <pre>
* 1. 패키지명 : mall.fo.board.service.impl
* 2. 타입명 : NoticeBoardServiceImpl
* 3. 작성일 : 2019. 2. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 공지사항 Impl
* </pre>
 */
@Service("noticeBoardService")
public class NoticeBoardServiceImpl implements NoticeBoardService {

	public int insertNoticeBoard(MultipartHttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		
		//CmmnMapperDAO.insert("Cmmn.insertCmmnFile", fileUpload.FileUpload(request, commandMap, "sample"));
		//return CmmnMapperDAO.insert("Sample.insertSample", commandMap);
		return 1;
	}
}

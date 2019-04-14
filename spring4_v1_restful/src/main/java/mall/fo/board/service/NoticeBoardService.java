package mall.fo.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
* <pre>
* 1. 패키지명 : mall.fo.board.service
* 2. 타입명 : NoticeBoardService
* 3. 작성일 : 2019. 2. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 공지사항 interface
* </pre>
 */
public interface NoticeBoardService {

	public int insertNoticeBoard(MultipartHttpServletRequest request, Map<String, Object> commandMap) throws Exception;

}

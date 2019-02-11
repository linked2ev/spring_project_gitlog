
package egovf.bo.board.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.module.pagination.PaginationInfo;

import egovf.bo.board.service.NoticeBoardService;
import egovf.bo.cmmn.service.CmmnService;


/**
* <pre>
* 1. 패키지명 : egovf.bo.board.controller
* 2. 타입명 : NoticeBoardController
* 3. 작성일 : 2019. 2. 8.
* 4. 작성자 : linked2ev
* 5. 설명 : 공지사항 Controller
* </pre>
 */
@Controller
public class NoticeBoardController {
	
	static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);
	
	@Resource(name="cmmnService")
	private CmmnService cmmnService;
	
	@Resource(name="ntcBoardService")
	private NoticeBoardService ntcBoardService;
	
	/**
	* <pre>
	* 1. 메소드명 : noticeBoardList
	* 2. 작성일 : 2019. 2. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 기본 게시판 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	@RequestMapping("/bo/board/noticeBoardList")
	public ModelAndView noticeBoardList(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception{
		ModelAndView mv = new ModelAndView();
		return mv;
	}
	
	/**
	* <pre>
	* 1. 메소드명 : getNoticeBoardList
	* 2. 작성일 : 2019. 2. 8.
	* 3. 작성자 : linked2ev
	* 4. 설명 : 공지사항 목록 가져오기
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	@RequestMapping("/bo/board/getNoticeBoardList")
	public ModelAndView getNoticeBoardList(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		String [] COMM_CD = new String [] { "SURVEY_GBN" };
		
		// 코드 목록
		for(int i=0; i<COMM_CD.length; i++){
			commandMap.put("COMM_CD", COMM_CD[i]);
			mv.addObject(COMM_CD[i] +"_LIST", this.cmmnService.getCodeList(request, commandMap));
		}
		
		// 목록 갯수
		int listCnt = 0;
		//int listCnt = this.ntcBoardService.getNtcBoardListCnt(request, commandMap);
		PaginationInfo paginationInfo = new PaginationInfo(listCnt, commandMap);
		//mv.addObject("paginationInfo", paginationInfo);
		
		// 목록
		List<Map<String, Object>> list = null;
		if(listCnt > 0){
			list = this.ntcBoardService.getNoticeBoardList(request, commandMap);
		}
		
		mv.addObject("commandMap", commandMap);
		mv.addObject("listCnt", listCnt);
		mv.addObject("list", list);
		
		return mv;
	}
	
    
}

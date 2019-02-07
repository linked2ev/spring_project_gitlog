
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

import egovf.bo.board.service.NtcBoardService;
import egovf.bo.cmmn.service.CmmnService;



@Controller
public class NtcBoardController {
	
	static final Logger logger = LoggerFactory.getLogger(NtcBoardController.class);
	
	@Resource(name="cmmnService")
	private CmmnService cmmnService;
	
	@Resource(name="ntcBoardService")
	private NtcBoardService ntcBoardService;
	
	/**
	* <pre>
	* 1. 메소드명 : ntcBoardList
	* 2. 작성일 : 2018. 1. 9.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 기본 게시판 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	@RequestMapping("/bo/board/ntcBoardList")
	public ModelAndView ntcBoardList(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView();
        
		// 목록 갯수
        int listCnt = 0;
		//int listCnt = this.ntcBoardService.getNtcBoardListCnt(request, commandMap);
        PaginationInfo paginationInfo = new PaginationInfo(listCnt, commandMap);
        mv.addObject("paginationInfo", paginationInfo);
        
//        
//        // 목록
//        List<Map<String, Object>> list = null;
//		if(listCnt > 0){
//			list = this.ntcBoardService.getNtcBoardList(request, commandMap);
//		}
		
		mv.addObject("commandMap", commandMap);
//		mv.addObject("listCnt", listCnt);
//		mv.addObject("list", list);
		
		return mv;
	}
	
	/**
	 * <pre>
	 * 1. 메소드명 : getNtcBoardList
	 * 2. 작성일 : 2018. 1. 9.
	 * 3. 작성자 : JAMUGE
	 * 4. 설명 : 기본 게시판 목록 get
	 * </pre>
	 * @param request
	 * @param commandMap
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/bo/board/getNtcBoardList")
	public ModelAndView getNtcBoardList(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView("jsonView");
		commandMap.put("USER_ID", "dgtest001");
		System.out.println(">> getNtcBoardList: ");
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
			list = this.ntcBoardService.getNtcBoardList(request, commandMap);
		}
		
		mv.addObject("commandMap", commandMap);
		mv.addObject("listCnt", listCnt);
		mv.addObject("list", list);
		
		return mv;
	}
	
    
}

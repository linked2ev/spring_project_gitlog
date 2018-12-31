package com.rnd.fo.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.com.util.PaginationInfo;
import com.com.util.StringUtil;
import com.rnd.fo.sample.service.SampleBoardService;

/**
* <pre>
* 1. 패키지명 : com.rnd.fo.sample.controller
* 2. 타입명 : SampleBoardController.java
* 3. 작성일 : 2017. 9. 27.
* 5. 설명 : SampleBoardController
* </pre>
 */
@Controller
public class SampleBoardController {

    @Resource(name="sampleBoardService") 
    private SampleBoardService sampleBoardService;   
    
    /**
    * <pre>
    * 1. 메소드명 : sampleBoardList
    * 2. 작성일 : 2017. 9. 27.
    * 3. 설명 : 공지사항 목록
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
    @RequestMapping("/fo/sample/sampleBoardList.do")
	public ModelAndView sampleBoardList(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView();
        
		/* 필수값 확인 */
        if(!"".equals(StringUtil.getString(commandMap.get("no"), ""))){
            
            String [] COMM_CD = new String [] { "EX_CODE" };
            
            // 코드 목록
            for(int i=0; i<COMM_CD.length; i++){
            	commandMap.put("COMM_CD", COMM_CD[i]);
            	//mv.addObject(COMM_CD[i] +"_LIST", this.cmmnService.selectCmmnList(commandMap));
            }
            
	        // 공지사항 목록 갯수
	        int listCnt = this.sampleBoardService.selectSampleBoardListCnt(request, commandMap);
	        PaginationInfo paginationInfo = new PaginationInfo(listCnt, commandMap);
	        mv.addObject("paginationInfo", paginationInfo);
	        
	        List<Map<String, Object>> list = null; 
	        if (listCnt > 0){
	        	
	        	// 공지사항 목록
	    		list = this.sampleBoardService.selectSampleBoardList(request, commandMap);
	        }
	        
	        mv.addObject("listCnt", listCnt);
	        mv.addObject("list", list);
	        
        }else{
        	mv.addObject("alertMsg", "비정상적인 접근입니다.");
            mv.addObject("returnUrl", request.getAttribute("webRootDomain") + "/fo/sample/index.do");
            mv.setViewName("/fo/common/result");
        }
        
        mv.addObject("commandMap", commandMap);
		 
		return mv;
	}
    
    /**
    * <pre>
    * 1. 메소드명 : sampleBoardInsertAjax
    * 2. 작성일 : 2017. 9. 29.
    * 3. 설명 : 공지사항  등록
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
    @RequestMapping("/fo/sample/sampleBoardInsertAjax.do")
    public ModelAndView sampleBoardInsertAjax(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception {
    	
    	ModelAndView mv = new ModelAndView("jsonView");
    	
    	int result = 0;
    	
		/* 필수값 확인 */
        if(!"".equals(StringUtil.getString(commandMap.get("no"), "")))
        {
        	// 공지사항 글쓰기 등록
        	result = this.sampleBoardService.insertSampleBoard(request, commandMap);
        }
        
        mv.addObject("result", result);
        
        return mv;
    }
}

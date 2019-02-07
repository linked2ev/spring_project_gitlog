package egovf.bo.samplemvc.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.module.file.FileUpload;
import com.module.pagination.PaginationInfo;

import egovf.bo.cmmn.service.CmmnService;
import egovf.bo.samplemvc.service.SampleService;

/**
 * 스프링 MVC 패턴 Sample
 */

/**
* <pre>
* 1. 패키지명 : egovf.bo.samplemvc.controller
* 2. 타입명 : SampleController.java
* 3. 작성일 : 2017. 12. 22.
* 4. 작성자 : JAMUGE
* 5. 설명 : SampleController > View Mapping
* </pre>
 */
@Controller
public class SampleController {
	
	static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Resource(name="cmmnService")
	private CmmnService cmmnService;
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	/**
	* <pre>
	* 1. 메소드명 : sampleList
	* 2. 작성일 : 2017. 12. 22.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 목록
	* </pre>
	* @param request
	* @param CommandMap
	* @return
	* @throws Exception
	 */
	@RequestMapping("/bo/sample/sampleList.do")
	public ModelAndView sampleList(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		commandMap.put("USER_ID", "dgtest001");
		
        String [] COMM_CD = new String [] { "SURVEY_GBN", "TEST_PLAN", "VISIT_AREA" };
        
        // 코드 목록
        for(int i=0; i<COMM_CD.length; i++){
        	commandMap.put("COMM_CD", COMM_CD[i]);
        	mv.addObject(COMM_CD[i] +"_LIST", this.cmmnService.getCodeList(request, commandMap));
        	System.out.println(">> getCodeList: " + this.cmmnService.getCodeList(request, commandMap));
        }
        
		// 목록 갯수
		int listCnt = 0;
		//int listCnt = this.sampleService.getSampleListCnt(request, commandMap);
        PaginationInfo paginationInfo = new PaginationInfo(listCnt, commandMap);
        mv.addObject("paginationInfo", paginationInfo);
        
        List<Map<String, Object>> list = null;
		if(listCnt > 0){
			//list = this.sampleService.getSampleList(request, commandMap);
		}
		
		mv.addObject("commandMap", commandMap);
		mv.addObject("listCnt", listCnt);
		mv.addObject("list", list);
		
		return mv;
	}
	
	/**
	* <pre>
	* 1. 메소드명 : sampleView
	* 2. 작성일 : 2017. 12. 26.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 상세정보
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
    @RequestMapping("/bo/sample/sampleView.do")
    public ModelAndView sampleView(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();
    	commandMap.put("USER_ID", "dgtest001");
    	
		// 시험모집 상세정보
		Map<String, Object> info = this.sampleService.getSampleView(request, commandMap);
		mv.addObject("info", info);
    	
    	mv.addObject("commandMap", commandMap);
    	
    	return mv;
    }
    
    /**
    * <pre>
    * 1. 메소드명 : sampleForm
    * 2. 작성일 : 2017. 12. 27.
    * 3. 작성자 : JAMUGE
    * 4. 설명 : 등록 Form
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
    @RequestMapping("/bo/sample/sampleForm.do")
	public ModelAndView sampleForm(HttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception {
		
		ModelAndView mv = new ModelAndView();
        
        mv.addObject("commandMap", commandMap);
		 
		return mv;
	}
    
    /**
    * <pre>
    * 1. 메소드명 : sampleProc
    * 2. 작성일 : 2017. 12. 27.
    * 3. 작성자 : JAMUGE
    * 4. 설명 : 등록 Proc
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
    @RequestMapping("/bo/sample/sampleProc.do")
    public ModelAndView sampleProc(MultipartHttpServletRequest request, @RequestParam Map<String, Object> commandMap) throws Exception {
    	
    	ModelAndView mv = new ModelAndView();  
    	
    	this.sampleService.insertSample(request, commandMap);
    	//Map<String, Object> returnMap = fu.FileUpload(request, commandMap, "sample");
        //System.out.println(">> returnMap: " + returnMap);
    	
    	return mv;
    }
    
}

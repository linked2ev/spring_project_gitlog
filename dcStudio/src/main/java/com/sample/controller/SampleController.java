package com.sample.controller;

import java.util.Map;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {
    Logger log = Logger.getLogger(this.getClass());
     
    /**
     * controller과 URL 매핑 테스트
     * @param commandMap
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/sample/openSampleMain.do")
    public ModelAndView openSampleBoardList(Map<String,Object> commandMap) throws Exception{
        ModelAndView mv = new ModelAndView("/sample/sampleMain");
        log.debug(">> URL 매핑 테스트");
        
        return mv;
    }

}

package com.apps.board.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.com.baseController;

@RestController
@RequestMapping("/board")
public class FaqBoardController extends baseController {

	private static final Logger logger = LoggerFactory.getLogger(FaqBoardController.class);

	@GetMapping("faq")
	public ResponseEntity faq() throws Exception {
		
		HashMap<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("buyer_email", "notice List");
		rmap.put("buyer_name", "YOUNG JUN, KIM");
		rmap.put("buyer_tel", "01048111234");
		rmap.put("buyer_country", "KOREA");
		rmap.put("Integer", 15000);
		
		return res(rmap, true);
	}
	
	@GetMapping("faq/{id}")
	public ResponseEntity faq(@PathVariable int id) throws Exception {
		
		HashMap<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("buyer_email", "notice Detail");
		rmap.put("buyer_name", "YOUNG JUN, KIM");
		rmap.put("buyer_tel", "01048111234");
		rmap.put("buyer_country", "KOREA");
		rmap.put("Integer", 15000);
		
		return res(rmap, true);
	}
}

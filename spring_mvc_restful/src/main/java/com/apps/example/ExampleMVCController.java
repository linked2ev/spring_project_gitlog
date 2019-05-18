package com.apps.example;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class ExampleMVCController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExampleMVCController.class);
	
	// @Controller > view 처리
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("rmsg", "Hello Spring MVC !");
		return "/mvc/index";
	}
	
	@GetMapping("example")
	public ResponseEntity<String> example() {
		String rmsg = "Spring MVC example";
		return new ResponseEntity<String>(rmsg, HttpStatus.OK);
	}
	
	@GetMapping("example/{str}")
	public ResponseEntity<String> test2(@PathVariable String str) {
		String rmsg = "[GET] RESTful @PathVariable: " + str;
		return new ResponseEntity<String>(rmsg, HttpStatus.OK);
	}
	
	@GetMapping("json")
	public ResponseEntity<HashMap> json() {
		
		HashMap<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("buyer_email", "test@email.com");
		rmap.put("buyer_name", "YOUNG JUN, KIM");
		rmap.put("buyer_tel", "01048111234");
		rmap.put("buyer_country", "KOREA");
		rmap.put("Integer", 15000);
		
		return new ResponseEntity<HashMap>(rmap, HttpStatus.OK);
	}
	
	// Error
	@GetMapping("json2")
	public HashMap json2() {
		
		HashMap<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("buyer_email", "test@email.com");
		rmap.put("buyer_name", "YOUNG JUN, KIM");
		rmap.put("buyer_tel", "01048111234");
		rmap.put("buyer_country", "KOREA");
		rmap.put("Integer", 15000);
		
		return rmap;
	}
}

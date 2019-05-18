package com.apps.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps.board.service.NoticeBoardService;
import com.com.baseController;

@RestController
@RequestMapping("/board")
public class NoticeBoardController extends baseController {

	private static final Logger logger = LoggerFactory.getLogger(NoticeBoardController.class);

	@Resource(name="noticeBoardService")
	private NoticeBoardService noticeBoardService;
	
	
	@GetMapping("notice")
	public ResponseEntity notice(HttpServletRequest request, ModelMap p) throws Exception {
		
		// 목록 갯수
		int totalCnt = this.noticeBoardService.getNoticeBoardListCnt(request, p);
		
		// 목록
		List<Map<String, Object>> list = null;
		if(totalCnt > 0){
			list = this.noticeBoardService.getNoticeBoardList(request, p);
		}
		
		return res(list, true);
	}
	
	@GetMapping("notice/{id}")
	public ResponseEntity notice(HttpServletRequest request, @PathVariable int id, ModelMap p) throws Exception {
		p.put("id", id);
		Map<String, Object> detail = this.noticeBoardService.getNoticeBoard(request, p);
		
		return res(detail, true);
	}
}

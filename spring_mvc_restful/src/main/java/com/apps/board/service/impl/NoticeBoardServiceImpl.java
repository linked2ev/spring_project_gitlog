package com.apps.board.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.apps.board.service.NoticeBoardService;

@Service("noticeBoardService")
public class NoticeBoardServiceImpl implements NoticeBoardService {


	public int getNoticeBoardListCnt(HttpServletRequest request, Map<String, Object> p) throws Exception {
		List<Map<String, Object>> list = this.getNoticeBoardList(request, p);
		return list.size();
	}

	public List<Map<String, Object>> getNoticeBoardList(HttpServletRequest request, Map<String, Object> p) throws Exception {
		
		List<Map<String, Object>> rmap = new ArrayList<Map<String, Object>>();
		
		HashMap<String, Object> row = new HashMap<String, Object>();
		for (int i=0; i<15; i++) {
			row = new HashMap<String, Object>();
			
			row.put("id", i);
			row.put("title", "공지사항 제목_"+i);
			row.put("content", "공지사항 내용_"+i);
			row.put("topFlag", "Y");
			row.put("regdate", "2019-01-01");
			row.put("adminno", 14001);
			
			rmap.add(row);
		}
	
		return rmap;
	}
	
	public Map<String, Object> getNoticeBoard(HttpServletRequest request, Map<String, Object> p) throws Exception {
		int id = Integer.parseInt(p.get("id").toString());
		List<Map<String, Object>> list = (List<Map<String, Object>>) this.getNoticeBoardList(request, p);
		return list.get(id);
	}
}
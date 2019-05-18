package com.apps.board.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;


public interface NoticeBoardService {


	public int getNoticeBoardListCnt(HttpServletRequest request, Map<String, Object> p) throws Exception;

	public List<Map<String, Object>> getNoticeBoardList(HttpServletRequest request, Map<String, Object> p) throws Exception;
	
	public Map<String, Object> getNoticeBoard(HttpServletRequest request, Map<String, Object> p) throws Exception;

}
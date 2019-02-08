package com.module.pagination;

import java.text.MessageFormat;

/**
* <pre>
* 1. 패키지명 : com.cmmn.pagination
* 2. 타입명 : ImgPaginationRenderer.java
* 3. 작성일 : 2017. 9. 26.
* 4. 작성자 : linked2ev
* 5. 설명 :
 * firstPageLabel = [<<]
 * previousPageLabel = [<]
 * currentPageLabel = 현재 페이지 번호
 * otherPageLabel = 현재 페이지를 제외한 페이지 번호
 * nextPageLabel = [>]
 * lastPageLabel = [>>]
* </pre>
 */
public class ImgPaginationRenderer {
	
    public String firstPageLabel;
    public String previousPageLabel;
    public String currentPageLabel;
    public String otherPageLabel;
    public String nextPageLabel;
    public String lastPageLabel;

    // ImgPaginationRenderer: pagination Img 역할
	public ImgPaginationRenderer() {
        firstPageLabel    = "<a href=\"javascript:;\" onclick=\"{0}({1}); return false;\" class=\"page-first\"><em class=\"page-arrow first dis\"></em><span class=\"screen_out\">처음 페이지</span></a> ";
        previousPageLabel = "<a href=\"javascript:;\" onclick=\"{0}({1}); return false;\" class=\"page-prev\"><em class=\"page-arrow prev dis\"></em><span class=\"screen_out\">이전 페이지</span></a> ";
        currentPageLabel  = "<span class=\"pageNumbering\"><a href=\"javascript:;\" class=\"page current\">{0}</a></span> ";
        otherPageLabel    = "<span class=\"pageNumbering\"><a href=\"javascript:;\" class=\"page\" onclick=\"{0}({1}); return false;\">{1}</a></span> ";
        nextPageLabel     = "<a href=\"javascript:;\" onclick=\"{0}({1}); return false;\" class=\"page-next\"><em class=\"page-arrow next\"></em><span class=\"screen_out\">다음 페이지</span></a> ";
        lastPageLabel     = "<a href=\"javascript:;\" onclick=\"{0}({1}); return false;\" class=\"page-end\"><em class=\"page-arrow end\"></em><span class=\"screen_out\">마지막 페이지</span></a> ";
	}
	
	// renderPagination:  PaginationInfo 데이터로 페이징 렌더링하는 역할
	public String renderPagination(PaginationInfo paginationInfo, String jsFunction){
		StringBuffer strBuff = new StringBuffer();
        
		if (paginationInfo != null){
	        int firstPageNo = paginationInfo.getFirstPageNo();
	        int firstPageNoOnPageList = paginationInfo.getFirstPageNoOnPageList();
	        int totalPageCount = paginationInfo.getTotalPageCount();
			int pageSize = paginationInfo.getPageSize();
			int lastPageNoOnPageList = paginationInfo.getLastPageNoOnPageList();
			int currentPageNo = paginationInfo.getCurrentPageNo();
			int lastPageNo = paginationInfo.getLastPageNo();
			
			if(totalPageCount > pageSize){
				if(firstPageNoOnPageList > pageSize){
					strBuff.append(MessageFormat.format(firstPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo)}));
					strBuff.append(MessageFormat.format(previousPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNoOnPageList-1)}));
		        }else{
		        	strBuff.append(MessageFormat.format(firstPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo)}));
					strBuff.append(MessageFormat.format(previousPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNo)}));
		        }
			}
			
			for(int i=firstPageNoOnPageList;i<=lastPageNoOnPageList;i++){
				if(i==currentPageNo){
	        		strBuff.append(MessageFormat.format(currentPageLabel,new Object[]{Integer.toString(i)}));
	        	}else{
	        		strBuff.append(MessageFormat.format(otherPageLabel,new Object[]{jsFunction,Integer.toString(i),Integer.toString(i)}));
	        	}
	        }
	        
			if(totalPageCount > pageSize){
				if(lastPageNoOnPageList < totalPageCount){
		        	strBuff.append(MessageFormat.format(nextPageLabel,new Object[]{jsFunction,Integer.toString(firstPageNoOnPageList+pageSize)}));
		        	strBuff.append(MessageFormat.format(lastPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo)}));
		        }else{
		        	strBuff.append(MessageFormat.format(nextPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo)}));
		        	strBuff.append(MessageFormat.format(lastPageLabel,new Object[]{jsFunction,Integer.toString(lastPageNo)}));
		        }
			}
		}
		return strBuff.toString();
	}

}

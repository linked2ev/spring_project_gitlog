package com.module.pagination;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


/**
* <pre>
* 1. 패키지명 : com.cmmn.pagination
* 2. 타입명 : PaginationTag.java
* 3. 작성일 : 2017. 9. 26.
* 4. 작성자 : JAMUGE
* 5. 설명 :
*  ImgPaginationRenderer가 반환한 String 데이터를 출력을 하는 태그 역할을 한다.
* </pre>
 */
public class PaginationTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;
	
	private PaginationInfo paginationInfo;
	private String jsFunction;
	

	public PaginationInfo getPaginationInfo() {
		return paginationInfo;
	}
	public void setPaginationInfo(PaginationInfo paginationInfo) {
		this.paginationInfo = paginationInfo;
	}
	public String getJsFunction() {
		return jsFunction;
	}
	public void setJsFunction(String jsFunction) {
		this.jsFunction = jsFunction;
	}

	@Override
	public int doEndTag() throws JspException{
		
		try {
			JspWriter out = pageContext.getOut();
            
			ImgPaginationRenderer imgPagingRenderer = new ImgPaginationRenderer();
            
            String contents = imgPagingRenderer.renderPagination(paginationInfo, jsFunction);
            out.println(contents);
            
            return EVAL_PAGE; 
            
        } catch (IOException e) {
            throw new JspException();
        }
	}

}

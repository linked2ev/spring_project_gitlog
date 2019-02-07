package com.cmmn.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cmmn.util.StringUtil;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;


/**
* <pre>
* 1. 패키지명 : com.cmmn.dao
* 2. 타입명 : CmmnAbstractMapperDAO.java
* 3. 작성일 : 2017. 12. 26.
* 4. 작성자 : JAMUGE
* 5. 설명 : Data Access Object (mybatis)
* </pre>
 */
@Repository("cmmnMapperDAO")
public class CmmnMapperDAO extends EgovAbstractMapper {

	static final Logger logger = LoggerFactory.getLogger(CmmnMapperDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
		 
//	@Resource(name = "sqlSession")
//	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
//		super.setSqlSessionFactory(sqlSession);
//	}
    
    protected void printQueryId(String queryID) {
        if(logger.isDebugEnabled()){
        	logger.debug("\t QueryId  \t:  " + queryID);
        }
    }
    
    /** 등록 */
    @SuppressWarnings("rawtypes")
	public int insert(String queryID, Map params) throws Exception {
        printQueryId(queryID);
        return (Integer) StringUtil.getInt(super.insert(queryID, params), 1);
    }
     
    /** 수정 */
    @SuppressWarnings("rawtypes")
	public int update(String queryID, Map params) throws Exception {
        printQueryId(queryID);
        return (Integer) super.update(queryID, params);
    }
     
    /** 삭제 */
    @SuppressWarnings("rawtypes")
	public int delete(String queryID, Map params) throws Exception {
        printQueryId(queryID);
        return (Integer) super.delete(queryID, params);
    }
     
    /** 단건 조회 */
	@SuppressWarnings("rawtypes")
	public Map select(String queryID, Map params) throws Exception {
        printQueryId(queryID);
        return (Map) super.selectByPk(queryID, params);
    }
     
    /** 단건 조회 */
    @SuppressWarnings("rawtypes")
	public Object selectObj(String queryID, Object obj) throws Exception {
    	printQueryId(queryID);
    	return (Map) super.selectByPk(queryID, obj);
    }
    
    /** 목록 조회 */
    @SuppressWarnings("rawtypes")
    public List selectList(String queryID, Map params) throws Exception {
        printQueryId(queryID);
        List returnList = super.list(queryID, params);
        if(returnList == null){
        	returnList = new ArrayList();
        }
        return returnList;
    }
    
    /** 목록 총 갯수 조회 */
    @SuppressWarnings("rawtypes")
	public int selectCount(String queryID, Map params) throws Exception {
    	printQueryId(queryID);
        return (Integer) super.selectOne(queryID, params);
    }
    
}

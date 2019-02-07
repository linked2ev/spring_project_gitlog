package egovf.bo.samplemvc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.cmmn.dao.CmmnMapperDAO;
import com.module.file.FileUpload;

import egovf.bo.samplemvc.service.SampleService;


/**
* <pre>
* 1. 패키지명 : egovf.bo.samplemvc.service.impl
* 2. 타입명 : SampleServiceImpl.java
* 3. 작성일 : 2017. 12. 22.
* 4. 작성자 : JAMUGE
* 5. 설명 : SampleServiceImpl > implementation
* </pre>
 */
@Service("sampleService")
public class SampleServiceImpl implements SampleService {

//    @Resource(name="cmmnAbstractDAO") 
//    private CmmnAbstractDAO cmmnAbstractDAO;
	
	@Autowired
	private FileUpload fileUpload;

	@Resource(name="cmmnMapperDAO")
	private CmmnMapperDAO CmmnMapperDAO;
	
    /**
    * <pre>
    * 1. 메소드명 : getSampleListCnt
    * 2. 작성일 : 2017. 12. 22.
    * 3. 작성자 : JAMUGE
    * 4. 설명 : 목록 갯수
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
	public int getSampleListCnt(HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
        return CmmnMapperDAO.selectCount("Sample.getSampleListCnt", commandMap);
	}

	/**
	* <pre>
	* 1. 메소드명 : getSampleList
	* 2. 작성일 : 2017. 12. 22.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 목록
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> getSampleList(HttpServletRequest request, Map<String, Object> commandMap) throws Exception  {
        return CmmnMapperDAO.selectList("Sample.getSampleList", commandMap);
	}
	
	/**
	* <pre>
	* 1. 메소드명 : getSampleView
	* 2. 작성일 : 2017. 12. 26.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : 상세정보
	* </pre>
	* @param request
	* @param commandMap
	* @return
	* @throws Exception
	 */
    @SuppressWarnings("unchecked")
	public Map<String, Object> getSampleView (HttpServletRequest request, Map<String, Object> commandMap) throws Exception {
        return CmmnMapperDAO.select("Sample.getSampleView", commandMap);
    }

    /**
    * <pre>
    * 1. 메소드명 : insertSample
    * 2. 작성일 : 2017. 12. 27.
    * 3. 작성자 : JAMUGE
    * 4. 설명 : 등록(첨부파일: 다중파일 포함)
    * </pre>
    * @param request
    * @param commandMap
    * @return
    * @throws Exception
     */
	public int insertSample(MultipartHttpServletRequest request, Map<String, Object> commandMap) throws Exception {
		
		fileUpload.FileUpload(request, commandMap, "sample");
		//CmmnMapperDAO.insert("Cmmn.insertCmmnFile", fileUpload.FileUpload(request, commandMap, "sample"));
		
		//return CmmnMapperDAO.insert("Sample.insertSample", commandMap);
		return 1;
	}
    
}

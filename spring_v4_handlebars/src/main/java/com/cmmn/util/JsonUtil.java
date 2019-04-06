package com.cmmn.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
* <pre>
* 1. 패키지명 : com.cmmn.util
* 2. 타입명 : JsonUtil
* 3. 작성일 : 2019. 2. 25.
* 4. 작성자 : linked2ev
* 5. 설명 : json data 유틸
* </pre>
 */
public class JsonUtil {

	static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	
	/**
	 * <pre>
	 * 1. 메소드명: getJson2Map
	 * 2. 직성일: 2019. 2. 25.
	 * 3. 작성자: linked2ev
	 * 4. 설명: convert Json to Map
	 * </pre>
	 * @param json
	 * @return
	 */
	public static Map<String, Object> getJson2Map(String json){
		json = json.replaceAll("&quot;", "\"");
		
		Map<String, Object> m = new HashMap<String, Object>();
		ObjectMapper om = new ObjectMapper();
		
		try {
			m = om.readValue(json, new TypeReference<HashMap<String,Object>>(){});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return m;
	}
	
	/**
	 * <pre>
	 * 1. 메소드명: getMap2Json
	 * 2. 직성일: 2019. 2. 25.
	 * 3. 작성자: linked2ev
	 * 4. 설명: convert Map to Json
	 * </pre>
	 * @param map
	 * @return
	 */
	public static String getMap2Json(Map<String, Object> map) {
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			json = mapper.writeValueAsString(map);
			//json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	
	/**
	 * <pre>
	 * 1. 메소드명: getMap2JsonFile
	 * 2. 직성일: 2019. 2. 25.
	 * 3. 작성자: linked2ev
	 * 4. 설명: convert Map to JsonFile
	 * </pre>
	 * @param map
	 * @return
	 */
	public static boolean getMap2JsonFile(Map<String, Object> map) {

		ObjectMapper mapper = new ObjectMapper();

		List<Object> list = new ArrayList<>();
		list.add("msg 1");
		list.add("msg 2");
		list.add("msg 3");

		map.put("messages", list);
		map.put("messages2", "개발팀");

		// write JSON to a file
		try {
			mapper.writeValue(new File("C:\\project\\spring_gitlog\\configJson\\dd.json"), map);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return true;
	}
}

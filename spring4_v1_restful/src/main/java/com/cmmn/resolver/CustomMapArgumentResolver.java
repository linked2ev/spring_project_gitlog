package com.cmmn.resolver;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.cmmn.interceptor.LoggerInterceptor;
import com.cmmn.resolver.CommandMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
* 1. 패키지명 : com.cmmn.resolver
* 2. 타입명 : CustomMapArgumentResolver.java
* 3. 작성일 : 2017. 12. 16.
* 4. 작성자 : linked2ev
* 5. 설명 : Controller에 가기 전 Parameter를 handling
 * </pre>
 */
public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver {

	static final Logger logger = LoggerFactory.getLogger(CustomMapArgumentResolver.class);

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return CommandMap.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		CommandMap commandMap = new CommandMap();

		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		//Enumeration<?> enumeration = request.getParameterNames();

		String json = request.getParameter("json");
		
		//_____ form JSON data to Map 방식 _____
		if (json != null && json != "") {
			ObjectMapper objectMapper = new ObjectMapper();
			Map m = new HashMap<String, Object>();
			json = json.replace("&quot;", "\"");
			m = (Map) objectMapper.readValue(json, Map.class);
			
			Iterator<String> keys = m.keySet().iterator();
			while( keys.hasNext() ){
				String key = keys.next();
				logger.info(" params:  " + key + " : " + m.get(key));
			}
			commandMap.putAll(m);
		}

		//____ form data object 방식 _____
		//String key = null; String[] values = null;
		//while(enumeration.hasMoreElements()){ key = (String)
		//	enumeration.nextElement(); 
		//	values = request.getParameterValues(key);
		//	if(values != null){
		//		String str = ""; 
		//		commandMap.put(key, (values.length > 1) ? values:values[0] );
		//		for (int i=0; i < values.length; i++) {
		//			str += (i==0) ?
		//			"":","; str += values[i];
		//		}
		//		logger.info(" params:  " + key + " : " + str); 
		//	}
		//}
		return commandMap;
	}
}

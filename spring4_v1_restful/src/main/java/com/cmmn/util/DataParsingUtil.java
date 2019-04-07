package com.cmmn.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataParsingUtil {

	/**
	 * <pre>
	 * 1. 메소드명: getDataInstanceofObjectParsing
	 * 2. 직성일: 2019. 2. 24.
	 * 3. 작성자: linked2ev
	 * 4. 설명: 커스텀 후 사용, map안에 들어있는 data의 타입에 따라 파싱하는 메소드
	 * </pre>
	 * @param dataMap
	 * @return
	 */
	public static Map<String, Object> getDataInstanceofObjectParsing (Map<String, Object> dataMap) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		Map<String, Object> linkedMap = new HashMap<String, Object>();
		for(String key : dataMap.keySet()){
		
		    if(dataMap.get(key) instanceof String){
		        String str = dataMap.get(key).toString();
		    
		    }else if(dataMap.get(key) instanceof Integer){
		        String str = dataMap.get(key).toString();
		        
		    }else if(dataMap.get(key) instanceof java.util.ArrayList){
		        //e.g) checkbox=[1, 2, 4]
		        ArrayList<String> arrList = new ArrayList<String>();
		        arrList = (ArrayList<String>) dataMap.get(key);
		        String str = "";
		        for(int i=0; i < arrList.size(); i++){
		            str += arrList.get(i);
		        }
		            
		    //LinkedHashMap : 순서를 유지하는 해시맵
		    }else if(dataMap.get(key) instanceof java.util.LinkedHashMap){
		        //e.g) m.get(key):{1=4, 2=4, 3=4, 4=4, 5={1=4, 2=4, 3=4}} 
		        int sseq = Integer.parseInt(key);
		        int mseq = 0;
		        linkedMap = (Map<String, Object>) dataMap.get(key);
		        
		        Map<String, Object> linkedInMap = new LinkedHashMap<String, Object>();
		        
		        for(String linkedMapKey : linkedMap.keySet()){
		            mseq = Integer.parseInt(linkedMapKey);

		            if(linkedMap.get(linkedMapKey) instanceof java.util.LinkedHashMap){
		                linkedInMap = (Map<String, Object>) linkedMap.get(linkedMapKey);
		                for(String multiKey : linkedInMap.keySet()){
		                    // ... key: 5, value: {1=4, 2=4, 3=4}
		                }  
		            }   
		            else{
		                //key: 1, value: 4
		                String str = linkedMap.get(linkedMapKey).toString();
		            }
		        }
		    }
		}
		
		return returnMap;
	}

}

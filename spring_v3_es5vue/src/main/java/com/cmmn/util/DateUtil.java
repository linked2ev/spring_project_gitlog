package com.cmmn.util;


/**
* <pre>
* 1. 패키지명 : com.cmmn.util
* 2. 타입명 : DateUtil.java
* 3. 작성일 : 2017. 12. 27.
* 4. 작성자 : linked2ev
* 5. 설명 : DateUtil
* </pre>
 */
public class DateUtil {

	
    /**
    * <pre>
    * 1. 메소드명 : getDateFmt
    * 2. 작성일 : 2017. 10. 11.
    * 3. 작성자 : linked2ev
    * 4. 설명 : 날짜 형식이 1~9일, 1월~9월 일 경우 01~09 형식으로 return
    * </pre>
    * @param obj
    * @return
     */
    public static String getDateFmt(Object obj){
    	if(obj.toString().length() < 2){
    		return "0" + obj.toString();
    	}else{
    		return obj.toString();
    	}
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getDateReFmt
    * 2. 작성일 : 2017. 12. 1.
    * 3. 작성자 : linked2ev
    * 4. 설명 : 날짜 형식이 01~09일, 01월~09월 일 경우 1~9 형식으로 return
    * </pre>
    * @param obj
    * @return
     */
    public static String getDateReFmt(Object obj){
    	String str = obj.toString();
       	if(str.length() == 2 && "0".equals(str.substring(0, 1))){
    		return str.replace("0", "");
    	}else{
    		return str;
    	}
    }
    
    /***** add Method *****/
    
}

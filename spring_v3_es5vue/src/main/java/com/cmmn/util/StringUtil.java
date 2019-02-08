package com.cmmn.util;

/**
* <pre>
* 1. 패키지명 : com.cmmn.util
* 2. 타입명 : StringUtil.java
* 3. 작성일 : 2017. 9. 26.
* 4. 작성자 : linked2ev
* 5. 설명 : StringUtil
* </pre>
 */
public class StringUtil {


	/**
	* <pre>
	* 1. 메소드명 : getInt
	* 2. 작성일 : 2017. 9. 26.
	* 3. 작성자 : linked2ev
	* 4. 설명 : String형을 int형으로 변환한다. null 또는 ""이면 0으로 return
	* </pre>
	* @param obj
	* @return
	 */
    public static int getInt(Object obj){
        if(obj == null || "".equals(obj.toString())) {
            return 0;
        } else {
            return Integer.parseInt(obj.toString());
        }
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getInt
    * 2. 작성일 : 2017. 9. 26.
    * 3. 작성자 : linked2ev
    * 4. 설명 : String형을 int형으로 변환한다. null 또는 ""이면 defaultNum(임의값)으로 return
    * </pre>
    * @param obj
    * @param defNum
    * @return
     */
    public static int getInt(Object obj, int defaultNum){
        if(obj == null || "".equals(obj.toString())) {
            return defaultNum;
        } else {
            return Integer.parseInt(obj.toString());
        }
    }

    /**
    * <pre>
    * 1. 메소드명 : isNull
    * 2. 작성일 : 2017. 12. 15.
    * 3. 작성자 : linked2ev
    * 4. 설명 : 특정 값이 null 또는 ""이면 false 아니면 true return
    * </pre>
    * @param obj
    * @return
     */
    public static boolean isNull(Object obj){
    	if(obj == null || "".equals(obj.toString())){
    		return false;
    	}else{
    		return true;
    	}
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getString
    * 2. 작성일 : 2017. 12. 16.
    * 3. 작성자 : JAMUGE
    * 4. 설명 : null 또는 ""이면 "" return
    * </pre>
    * @param obj
    * @return
     */
    public static String getString(Object obj){
    	if(obj == null || "".equals(obj.toString())){
    		return "";
    	}else{
    		return obj.toString();
    	}
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getString
    * 2. 작성일 : 2017. 9. 26.
    * 3. 작성자 : JAMUGE
    * 4. 설명 : null 또는 ""이면 defaultStr(임의값)으로 return
    * </pre>
    * @param obj
    * @param defStr
    * @return
     */
    public static String getString(Object obj, String defaultStr){
        if(obj == null || "".equals(obj.toString())){
            return defaultStr;
        } else {
            if ("".equals(obj.toString())){
                return defaultStr;
            } else {
                return obj.toString();
            }
        }
    }
    
    /***** add Method *****/
    
}

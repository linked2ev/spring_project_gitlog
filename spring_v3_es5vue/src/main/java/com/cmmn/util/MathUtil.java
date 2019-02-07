package com.cmmn.util;

/**
* <pre>
* 1. 패키지명 : com.cmmn.util
* 2. 타입명 : MathUtil.java
* 3. 작성일 : 2017. 11. 6.
* 4. 작성자 : JAMUGE
* 5. 설명 : MathUtil
* </pre>
 */
public class MathUtil {
	
	
	/**
	* <pre>
	* 1. 메소드명 : randomNum
	* 2. 작성일 : 2017. 11. 6.
	* 3. 작성자 : JAMUGE
	* 4. 설명 : (int)(Math.random() * 최대값) + 최소값
	* </pre>
	* @return
	 */
	public static int randomNum(int min, int max){
		double randomVal = Math.random();
		int randomNum = (int)(randomVal * max) + min;
		return randomNum;
	}
	
    /**
    * <pre>
    * 1. 메소드명 : calStringToByte
    * 2. 작성일 : 2017. 11. 24.
    * 3. 작성자 : JeongHo
    * 4. 설명 : String의 byte 계산
    * </pre>
    * @param str
    * @return
     */
    public static int calStringToByte(String str){
    	
        // 바이트 체크 (영문 1, 한글 2, 특문 1)
        int en = 0;
        int ko = 0;
        int etc = 0;
 
        char[] txtChar = str.toCharArray();
        for (int j = 0; j < txtChar.length; j++) {
            if (txtChar[j] >= 'A' && txtChar[j] <= 'z') {
                en++;
            } else if (txtChar[j] >= '\uAC00' && txtChar[j] <= '\uD7A3') {
                ko++;
                ko++;
            } else {
                etc++;
            }
        }
        int txtByte = en + ko + etc;
        
        return txtByte;
    }
    
    /***** add Method *****/

}

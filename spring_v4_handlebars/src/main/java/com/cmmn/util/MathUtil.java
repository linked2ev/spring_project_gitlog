package com.cmmn.util;

/**
* <pre>
* 1. 패키지명 : com.cmmn.util
* 2. 타입명 : MathUtil.java
* 3. 작성일 : 2017. 11. 6.
* 4. 작성자 : linked2ev
* 5. 설명 : MathUtil
* </pre>
 */
public class MathUtil {
	
	
	/**
	* <pre>
	* 1. 메소드명 : randomNum
	* 2. 작성일 : 2017. 11. 6.
	* 3. 작성자 : linked2ev
	* 4. 설명 : (int)(Math.random() * 최대값) + 최소값
	* </pre>
	* @return
	 */
	public static int randomNum(int min, int max){
		double randomVal = Math.random();
		int randomNum = (int)(randomVal * max) + min;
		return randomNum;
	}
	
    /***** add Method *****/

}

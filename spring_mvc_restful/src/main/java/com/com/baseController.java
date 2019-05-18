package com.com;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class baseController {
	
	public static ResponseEntity<Object> res (Object obj, boolean bret) throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=UTF-8");
		
		return new ResponseEntity<Object>(obj, headers, HttpStatus.OK);
	}
}

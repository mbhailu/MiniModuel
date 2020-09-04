package com.MiniModulesAPI.Utilites;

import org.springframework.web.bind.annotation.ControllerAdvice;



@ControllerAdvice
public class ExceptionHandling extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ExceptionHandling() throws Exception {
		
		
		
		super( "{\r\n" + 
				"    \"RESPONSE_DATA\": {\r\n" + 
				"        \"SERVERRESPONSE\":\"API FAILD\",\r\n" +  
				"        \"returnCode\": 0,\r\n" + 
				"        \"returnMessage\": \"Please contact to admistration\"\r\n" + 
				"    }\r\n" + 
				"}");
		System.out.println("inside the handler");	
		
		
		
	}

}

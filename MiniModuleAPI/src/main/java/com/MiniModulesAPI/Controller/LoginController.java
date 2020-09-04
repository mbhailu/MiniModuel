package com.MiniModulesAPI.Controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MiniModulesAPI.Utilites.ExceptionHandling;
import com.MiniModulesAPI.Utilites.UtilyClass;

@RestController
public class LoginController {

	private String username, password;

	
	@PostMapping("/login")
	public String loginAuthantication(@RequestBody String jsonString ) throws ExceptionHandling {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy");  
		LocalDateTime now = LocalDateTime.now();  
		
		try {

		 JSONArray array = new JSONArray(jsonString);
		 JSONObject json = array.getJSONObject(0);
		 JSONObject childObject = json.getJSONObject("RESPONSE_DATA");
		 
		 username = childObject.getString("username");
		 password = childObject.getString("password");
		
		if ((username.equalsIgnoreCase("abhishek") || username.equalsIgnoreCase("harsh")) && password.equalsIgnoreCase("admin@123")) {
			return  "{\r\n" + 
					"    \"RESPONSE_DATA\": {\r\n" + 
					"        \"__type\": \"ClientActivationResponse\",\r\n" +  
					"        \"date&time\": \""+dtf.format(now)+"\",\n" + 
					"        \"transactionId\": 0,\r\n" + 
					"        \"returnCode\": 1,\r\n" + 
					"        \"returnMessage\": \"Success\"\r\n" + 
					"    }\r\n" + 
					"}";
				
		}else {
			 return "{\r\n" + 
					"    \"RESPONSE_DATA\": {\r\n" + 
					"        \"__type\": \"ClientActivationResponse\",\r\n" +  
					"        \"date&time\": \""+dtf.format(now)+"\",\n" + 
					"        \"transactionId\": 0,\r\n" + 
					"        \"returnCode\": 0,\r\n" + 
					"        \"returnMessage\": \"Bad Request.Please Contact administration.\"\r\n" + 
					"    }\r\n" + 
					"}";
		}
	}catch (Exception e) {
		
		UtilyClass.writeLog("API FAILED", e);
		
		return "{\r\n" + 
				"    \"RESPONSE_DATA\": {\r\n" + 
				"        \"SERVERRESPONSE\":\"API FAILD\",\r\n" +  
				"        \"returnCode\": 0,\r\n" + 
				"        \"returnMessage\": \"Please contact to admistration\"\r\n" + 
				"    }\r\n" + 
				"}";
	}

}

}

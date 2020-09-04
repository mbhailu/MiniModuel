package com.MiniModulesAPI.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPIController {
	
	@GetMapping("/home") 
	public String  home() {
		return "api called";
	}
	
	

}

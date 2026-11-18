package com.tmt.doc.management.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docmanagment")
public class DocManagementController {

	@GetMapping("/getdocs")	
	public @ResponseBody ResponseEntity<String> getTasks(){
		return ResponseEntity.ok("All docs are ok");
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";

	}
	
}

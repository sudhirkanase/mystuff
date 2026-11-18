package com.tmt.taskmanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taskmanagement")
public class TaskManagementController {

	
	@GetMapping("/getTasks")	
	public @ResponseBody ResponseEntity<String> getTasks(){
		return ResponseEntity.ok("All tasks are ok");
	}
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";

	}
	
}

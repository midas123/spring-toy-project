package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponseMessage;
import com.example.demo.dto.Person;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/hello/json")
	public Map<String, Object> hellojson(){
		Map<String, Object> json = new HashMap<>();
		json.put("name", "john");
		return json;
	}
	
	@GetMapping("/hello/jsons")
	public List<Map<String, Object>> hellojsons(){
		List<Map<String, Object>> jsons = new ArrayList<>();
		Map<String, Object> json = new HashMap<>();
		json.put("name", "john");
		jsons.add(json);
		Map<String, Object> json2 = new HashMap<>();
		json2.put("name", "kelly");
		jsons.add(json2);
		return jsons;
	}
	
	@PostMapping("/person/save")
	public ResponseEntity<ApiResponseMessage> savePersonInfo(Person person){
		return new ResponseEntity<>(new ApiResponseMessage("Code1", "성공"), HttpStatus.OK);
	}
}

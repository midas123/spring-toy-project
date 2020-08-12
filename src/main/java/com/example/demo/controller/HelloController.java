package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Member;
import com.example.demo.dto.ApiResponseMessage;
import com.example.demo.service.HelloService;

@RestController
public class HelloController {
	
	//@Autowired
	//private HelloService helloService; //필드 주입
	
	
//	private HelloService helloService; //setter 주입
//	
//	@Autowired
//	public void setHelloService(HelloService helloService) {
//		this.helloService = helloService;
//	}
	
	
	//생성자 주입, 어플리케이션 최초 구동시 의존주입이 발생하므로 이 방법을 권장함(어떤 방식이든 런타임 중에 의존 주입X) 
	private final HelloService helloService;
	
	@Autowired
	public HelloController(HelloService helloService) { 
		this.helloService = helloService;
	}
	
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
	public ResponseEntity<ApiResponseMessage> savePersonInfo(Member person){
		return new ResponseEntity<>(new ApiResponseMessage("Code1", "성공"), HttpStatus.OK);
	}
}

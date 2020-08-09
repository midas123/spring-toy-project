package com.example.demo.dto;


public class ApiResponseMessage {
	private String code;
	private String message;
	
	public ApiResponseMessage() {
		
	}
	
	public ApiResponseMessage(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}	
}

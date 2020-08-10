package com.example.demo.service;

import com.example.demo.repository.HelloRepository;

public class HelloService {
	private final HelloRepository helloRepository;
	
	public HelloService(HelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}
}

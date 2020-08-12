package com.example.demo.service;

import com.example.demo.repository.SpringHelloRepository;

public class HelloService {
	private final SpringHelloRepository helloRepository;
	
	public HelloService(SpringHelloRepository helloRepository) {
		this.helloRepository = helloRepository;
	}
}

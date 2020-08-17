package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.service.HelloService;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.SpringHelloRepository;

@Configuration
public class HelloSpringConfig {
	
	@Bean
	public HelloService HelloService() {
		return new HelloService(helloRepository());
	}
	
	@Bean 
	public SpringHelloRepository helloRepository() {
		return new MemberRepository();
	}
}

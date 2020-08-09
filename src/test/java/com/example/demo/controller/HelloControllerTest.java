package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.example.demo.dto.ApiResponseMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void return_hello() throws Exception {
		String hello = "hello";
		mvc.perform(get("/hello"))
		.andExpect(status().isOk())
		.andExpect(content().string(hello));
	}
	
	@Test
	public void return_json() throws Exception {
		mvc.perform(get("/hello/json"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
        .andExpect(jsonPath("$.name").value("john"));
	}
	
	@Test
	public void return_jsons() throws Exception {
		mvc.perform(get("/hello/jsons"))
		.andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.length()", is(2)))
		.andExpect(jsonPath("$[0].name", is("john")))
		.andExpect(jsonPath("$[1].name", is("kelly")));
	}
	
	@Test
	public void return_message_savePerson() throws Exception {
		MvcResult result = mvc.perform(post("/person/save")
		.param("name", "john")
		.param("password", "1234")
		).andExpect(status().isOk()).andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		ObjectMapper mapper = new ObjectMapper();
		ApiResponseMessage arm = mapper.readValue(content, ApiResponseMessage.class);
		assertTrue(arm.getCode().equals("Code1"));
	}
	
	@Test
	public void return_message_savePerson2() throws Exception {
		mvc.perform(post("/person/save")
		).andExpect(status().isOk())
		.andExpect(content().json("{'code':'Code1', 'message':'성공'}"));
	}
}

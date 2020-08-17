package com.example.demo.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import com.example.demo.domain.Member;

public class HelloRepositoryTest {
	
	MemberRepository helloRepository = new MemberRepository();
	
	@After
	public void afterEach() { //테스트 간에 영향이 없도록 각 테스트 실행 후 저장 공간 클리어
		helloRepository.clearStore();
	}
	
	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		helloRepository.save(member);
		
		Member result = helloRepository.findById(member.getId()).get();
		assertThat(member).isEqualTo(result);
	}
	
	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("spring1");
		helloRepository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		helloRepository.save(member2);
		
		Member result = helloRepository.findByName("spring1").get();
		assertThat(result).isEqualTo(member1);
	}
	
	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		helloRepository.save(member1);
		
		Member member2 = new Member();
		member2.setName("spring2");
		helloRepository.save(member2);
		
		List<Member> result = helloRepository.findAll();
		assertThat(result.size()).isEqualTo(2);
		
	}
}

package com.example.demo.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Test;

import com.example.demo.domain.Member;

public class MemberServiceTest {
	MemberService memberService = new MemberService();
	
	@Test
	void 회원가입() {
		//given
		Member member = new Member();
		member.setName("name");
		
		//when
		Long saveId = memberService.join(member);
		
		//then
		Member result = memberService.findMember(saveId).get();
		assertThat(member.getName()).isEqualTo(result.getName());
	}
	
	@Test
	public void 중복_회원_예외() {
		//given
		Member member = new Member();
		member.setName("spring");
		
		Member member2 = new Member();
		member2.setName("spring");
		
		//when
		memberService.join(member);
		//assertThrows(IllegalArgumentException.class, () -> memberService.join(member2));
		
		/*
		 * try { memberService.join(member2); fail(); } catch (IllegalArgumentException
		 * e) { assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다."); }
		 */
	}
}

package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

public class MemberService {
	private final MemberRepository memberRepository = new MemberRepository();
	
	public Long join(Member member) {
		checkMemberDuplicate(member);
		memberRepository.save(member);
		return member.getId();
	}
	
	public void checkMemberDuplicate(Member member) {
		memberRepository.findByName(member.getName()).ifPresent(
				m -> {throw new IllegalArgumentException("이미 존재하는 회원입니다.");
				});
	}
	
	public List<Member> findMembers(){
		return memberRepository.findAll();
	}
	
	public Optional<Member> findMember(Long id) {
		return memberRepository.findById(id);
	}

}

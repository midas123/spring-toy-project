package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.domain.Member;

public class HelloRepository implements SpringHelloRepository  {

	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(sequence, member);
		return member;
	}

	@Override
	public Optional<Member> findByName(String name) {
		return store.values().stream().filter(
				member -> member.getName().equals(name)).findAny();
	}

	@Override
	public Optional<Member> findById(long id) {
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}
	
}

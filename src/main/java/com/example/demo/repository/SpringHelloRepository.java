package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import com.example.demo.domain.Member;

public interface SpringHelloRepository {
	Member save(Member person);
	Optional<Member> findByName(String name);
	Optional<Member> findById(long id);
	List<Member> findAll();
}

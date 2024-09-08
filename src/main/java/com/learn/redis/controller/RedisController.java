package com.learn.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.redis.entity.Student;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisTemplate<String, Student> rdsTemplate;

	@PostMapping
	public ResponseEntity<?> registerStudent(@RequestParam("name") String name) {

		HashOperations<String, String, Student> opsForHash = rdsTemplate.opsForHash();
		opsForHash.put("std", name, new Student(name));

		return new ResponseEntity<>(name + " added successfully", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getAllStudent() {

		HashOperations<String, String, Student> opsForHash = rdsTemplate.opsForHash();

		List<Student> values = opsForHash.values("std");
		Student student = opsForHash.get("std", "Mike");
		System.out.println(student);
		return new ResponseEntity<>(values, HttpStatus.OK);
	}

}

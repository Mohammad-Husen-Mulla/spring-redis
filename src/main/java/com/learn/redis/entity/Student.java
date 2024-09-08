package com.learn.redis.entity;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = -6822771895225649094l;
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	
}

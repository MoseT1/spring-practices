package com.bitacademy.container.user;

import org.springframework.stereotype.Component;

@Component
public class Friend {
	
	
	private Long no = 1L;
	
	private String name = "페이커";
	
	// Annotation 기반 scanning(Auto Configuration)은 기본 생성자로 생성안하면 에러난다.
//	public Friend(String name) {
//		this.name = name;
//	}
	
	
	@Override
	public String toString() {
		return "Friend [no=" + no + ", name=" + name + "]";
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}

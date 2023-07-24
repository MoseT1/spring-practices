package com.bitacademy.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// annotation 없으면 spring환경에서 테스트 안한다. 그냥 junit 테스트
public class MyTest {
	
	@Test
	public void test01() {
		int i = 10;
		assertTrue( i - 10 == 0);   //assert안에게 성공해야 테스트 통과
	}
	
	@Test
	public void test02() {
		int i = 10;
		assertEquals( 10, i);   // i는 10과 같아야한다. 
	}
}

package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.container.user.User;

public class XmlConfigTest {

	public static void main(String[] args) {
		// 1. XML Auto Configuration (Annotation Configuration)  (자동 설정)
		
		//testXMLAutoConfiguration();
		
		// 2. XML Explicit Configuration  (명시적 설정)
		
		testXMLExplicitConfiguration();
	}
	
	private static void testXMLAutoConfiguration() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext01.xml");
		
		
		User user = ac.getBean(User.class);
		System.out.println(user);
		
		

		// Annotation Scan 설정에서는 Bean id 가 자동으로 부여된다.
		user = (User)ac.getBean("user");
		System.out.println(user);
		
		
		
	}
	
	private static void testXMLExplicitConfiguration() {
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext("com/bitacademy/container/config/user/applicationContext02.xml");
		
		User user = null;
		
		
		// 오류 : id로 가져오기
//		// 명시적 빈 설정인 경우에는 id를 자동으로 부여하지 않는다.
//		user = (User)ac.getBean("user");
//		System.out.println(user);
		
		
		//id로 가져오기
		user = (User)ac.getBean("user2");
		System.out.println(user);
		
		//  User [no=0, name=홍길동, friend=null]     friend 주입은 안됨.
		
		//name으로 가져오기
		user = (User)ac.getBean("usr2");
		System.out.println(user);
		
		// Type으로 빈 가져오기
		// 같은 타입의 빈이 2개 이상 있으면, Type으로만 가져오기는 실패	
		// 1. id + Type으로 가져오거나
		// 2. name + Type으로 가져와야한다.
		
			// 에러
//		user = ac.getBean(User.class);
//		System.out.println(user);
		
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		
		user = ac.getBean("usr2", User.class);
		System.out.println(user);
		
		//파라미터 1개인 생성자로 생성된 빈 가져오기
		
		user = ac.getBean("user3", User.class);
		System.out.println(user);
		
		user = ac.getBean("user4", User.class);
		System.out.println(user);
		
		user = ac.getBean("user5", User.class);
		System.out.println(user);
		

		user = ac.getBean("user6", User.class);
		System.out.println(user);
		
		user = ac.getBean("user7", User.class);
		System.out.println(user);
		
		user = ac.getBean("user9", User.class);
		System.out.println(user);
	}

}

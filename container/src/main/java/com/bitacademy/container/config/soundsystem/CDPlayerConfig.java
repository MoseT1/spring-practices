package com.bitacademy.container.config.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bitacademy.container.user.User;


// 설정파일에는 @Configuration 꼭 달아줘야한다.  
@Configuration
@ComponentScan(basePackages= {"com.bitacademy.container.soundsystem"})
public class CDPlayerConfig {
	
	
	
	// 이게 리턴하는 bean을 컨테이너에 갖다논다.
	@Bean
	public User user() {
		return new User();
	}
	
}

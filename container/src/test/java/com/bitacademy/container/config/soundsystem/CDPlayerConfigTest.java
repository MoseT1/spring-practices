package com.bitacademy.container.config.soundsystem;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.soundsystem.CDPlayer;



//Spring환경에서 테스트하겠다는 annotation  ,  컨테이너 안에서 빈으로 만들어서 테스트하겠다.6
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes= {CDPlayerConfig.class})   // xml의 annotationconfig하고 같다.
public class CDPlayerConfigTest {
	
	@Autowired
	private CDPlayer cdPlayer;
	
	@Test
	public void testCDPlayerNotNull() {
		assertNotNull(cdPlayer);
	}
	
	@Test
	public void testPlay() {
		
		assertEquals("Playing 붕붕 by 김하온", cdPlayer.play());
	}
}

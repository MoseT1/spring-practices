package com.bitacademy.container.config.videosystem.mixing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.bitacademy.container.videosystem.DVDPlayer;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={DVDPlayerConfig.class})
public class DVDPlayerMixingConfigTest01 {
	@Autowired
	private DVDPlayer dvdPlayer;
	
	@Test
	public void testPlay() {
		assertEquals("Playing Movie MARVEL's Avengers Infinity War", dvdPlayer.play());
	}
}

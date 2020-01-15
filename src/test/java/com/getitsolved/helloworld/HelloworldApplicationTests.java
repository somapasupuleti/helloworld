package com.getitsolved.helloworld;

import com.getitsolved.helloworld.controller.helloSpring;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloworldApplicationTests {

	@Mock
	helloSpring HelloSpring;

	@Test
	void contextLoads() {
	}

	@Test
	public void helloworldTest(){

		Mockito.when(HelloSpring.hello()).thenReturn("Hello Spring Test");

	}

}

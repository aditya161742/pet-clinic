package com.springboot.petclinic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)        // This annotation is of JUnit5 ealrier it was Runwith annotation
@SpringBootTest
class PetLinicApplicationTests {

	@Test
	void contextLoads() {
	}

}

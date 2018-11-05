package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

import guru.springframework.sfgpetclinic.ControllerTests;

class IndexControllerTest implements ControllerTests {
	IndexController indexController;
	
	@BeforeEach
	void setUp() throws Exception {
		indexController = new IndexController();
	}

	@Test
	void testIndex() {
		assertEquals("index", indexController.index(), () -> "Wrong View");
		assertThat(indexController.index()).isEqualTo("index");
	}

	@Test
	void testOopsHandler() {
		assertThrows(ValueNotFoundException.class, () -> indexController.oopsHandler());
	}

	@Disabled("Demo of Timeout")
	@Test
	void testTimeOut() {
		assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);
			System.out.println("testTimeOut");
		});
	}
	
	@Disabled("Demo of Timeout")
	@Test
	void testTimeOutPrempt() {
		assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
			Thread.sleep(2000);
			System.out.println("testTimeOutPrempt");
		});
	}
	
	@Test
	void TestAssumptionTrue() {
		assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}	
	
	@Test
	void TestAssumptionTrueAssumptionIsTrue() {
		assumeTrue("GURU".equalsIgnoreCase("GURU"));
	}
	
	@Test
	@EnabledOnOs(OS.MAC)
	void testOnMac() {
		
	}
	
	@EnabledOnOs(OS.WINDOWS) 
	@Test
	void testOnWindows() {
	}
	
	@EnabledOnJre(JRE.JAVA_8)
	@Test
	void testOnJre8() {
		
	}
	
	@EnabledOnJre(JRE.JAVA_11)
	@Test
	void testOnJre11() {
		
	}
	
	@EnabledIfEnvironmentVariable(named = "HOMEDRIVE", matches = "C:")
	@Test
	void testIfEnv() {
		
	}
}

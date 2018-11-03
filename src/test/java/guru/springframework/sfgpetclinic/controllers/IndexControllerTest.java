package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class IndexControllerTest {
	IndexController indexController;
	
	@BeforeEach
	void setUp() throws Exception {
		indexController = new IndexController();
	}

	@Test
	void testIndex() {
		assertEquals("index", indexController.index(), () -> "Wrong View");
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
}


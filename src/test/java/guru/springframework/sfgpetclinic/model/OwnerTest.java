package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ModelTests;

class OwnerTest implements ModelTests {

	@Test
	void testDependendAssertions() {
		Owner owner = new Owner(1L, "John", "Doe");
		owner.setCity("Key West");
		owner.setTelephone("5555555555");
		//assertThat
		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("John", owner.getFirstName(), "first name did not match"),
						() -> assertEquals("Doe", owner.getLastName())),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity(), "City did not match"),
						() -> assertEquals("5555555555", owner.getTelephone())));
		}
		
		
}

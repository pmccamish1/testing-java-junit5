package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OwnerTest {

	@Test
	void testDependendAssertions() {
		Owner owner = new Owner(1L, "John", "Doe");
		owner.setCity("Key West");
		owner.setTelephone("5555555555");

		assertAll("Properties Test",
				() -> assertAll("Person Properties",
						() -> assertEquals("John", owner.getFirstName(), "first name did not match"),
						() -> assertEquals("Doe", owner.getLastName())),
				() -> assertAll("Owner Properties",
						() -> assertEquals("Key West", owner.getCity(), "City did not match"),
						() -> assertEquals("5555555555", owner.getTelephone())));

	}

}

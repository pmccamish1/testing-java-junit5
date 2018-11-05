package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ModelTests;

class PersonTest implements ModelTests {

	@Test
	@DisplayName("Testing Grouped assertions")
	void testGroupedAssertions() {
		//given
		Person person = new Person(1L,"John","Doe");
		
		
		//then
		assertAll("Test Props Set",
		() -> assertEquals("John", person.getFirstName(), "First name failed"),
		() -> assertEquals("Doe", person.getLastName(), "Second name failed"));
		
		person.setFirstName("Jane");
		person.setLastName("Dee");
		
		assertAll("Test Props Set",
		() -> assertEquals("Jane", person.getFirstName(), "First name failed"),
		() -> assertEquals("Dee", person.getLastName(), "Second name failed"));
	}

}

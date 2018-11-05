package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

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
	
	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions} ")
	@DisplayName("Repeated Tests")
	void myRepeatedTest() {
		
	}
	
	@RepeatedTest(5)
	@DisplayName("More Repeated Tests ")
	void moreRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getDisplayName() +" : "+repetitionInfo.getCurrentRepetition()+" - "+repetitionInfo.getTotalRepetitions());
	}
	
	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions} ")
	@DisplayName("Extra Repeated Tests")
	void extraRepeatedTest() {
	}

}

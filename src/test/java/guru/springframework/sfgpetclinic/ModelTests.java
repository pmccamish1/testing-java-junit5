package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@Tag("model")
public interface ModelTests {

//	@BeforeEach
//	default void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
//		System.out.println("ModelTests - Before Each : " + testInfo.getDisplayName() +" : "+repetitionInfo.getCurrentRepetition()+" - "+repetitionInfo.getTotalRepetitions());
//	}
	
	@BeforeEach
	default void beforeEach(TestInfo testInfo) {
		System.out.println("ModelTests - Before Each : " + testInfo.getDisplayName());
	}
	
}

package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
@Tag("controller")
public interface ControllerTests {
	
	@BeforeAll
	default void beforeAll() {
		System.out.println("Controller Tests - before All");
	}
}

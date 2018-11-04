package guru.springframework.sfgpetclinic.services.map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;

@DisplayName("Owner Map Service Test -")
class OwnerMapServiceTest {
	PetTypeService petTypeService;
	PetService petService;
	OwnerMapService ownerMapService;

	@BeforeEach
	void setUp() throws Exception {
		petTypeService = new PetTypeMapService();
		petService = new PetMapService();
		ownerMapService = new OwnerMapService(petTypeService, petService);
	}

	@DisplayName("Verify Zero Owners")
	@Test
	void testOwnersAreZero() {
		assertThat(ownerMapService.findAll().size()).isZero();
	}

	@DisplayName("Pet Type - ")
	@Nested
	class TestCreatePetTypes {
		@BeforeEach
		void setUp() {
			PetType petType = new PetType(1L, "Dog");
			PetType petType2 = new PetType(2L, "Cat");
			petTypeService.save(petType);
			petTypeService.save(petType2);
		}

		@Test
		void testPetCount() {
			int petTypeCount = petTypeService.findAll().size();
			assertThat(petTypeCount).isEqualTo(2);

		}

		@DisplayName("Save Owners Tests - ")
		@Nested
		class SaveOwnersTest {
			@BeforeEach
			void setUp() {
				ownerMapService.save(new Owner(1L, "Before", "Each"));

			}

			@Test
			void saveOwner() {
				Owner owner = new Owner(2L, "John", "Doe");
				assertThat(ownerMapService.save(owner)).isNotNull();

			}

			@DisplayName("Save Owners Tests - ")
			@Nested
			class testFindOwner {
				@DisplayName("Find Owner Not Found")
				@Test
				void testFindOwnerNotFound() {
					assertThat(ownerMapService.findById(2L)).isNull();
				}

				@DisplayName("Find Owner Found")
				@Test
				void testFindOwner() {
					assertThat(ownerMapService.findById(1L)).isNotNull();
				}
			}

		}
	}

	@DisplayName("Verify Still Zero Owners")
	@Test
	void ownersAreStillZero() {
		assertThat(ownerMapService.findAll().size()).isZero();
	}

}

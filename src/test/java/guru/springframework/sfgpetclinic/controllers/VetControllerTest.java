package guru.springframework.sfgpetclinic.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import guru.springframework.sfgpetclinic.ControllerTests;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.SpecialtyService;
import guru.springframework.sfgpetclinic.services.VetService;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;


class VetControllerTest implements ControllerTests {
	VetService vetService;
	SpecialtyService specialtyService;
	VetController vetController;
	@BeforeEach
	void setUp() throws Exception {
		specialtyService = new SpecialityMapService();
		vetService = new VetMapService(specialtyService);
		vetController = new VetController(vetService);
		Set<Speciality> specialtySet = new HashSet<>();
		specialtySet.add(new Speciality("Awesome"));
		Vet v1 = new Vet(1L,"John","Doe",specialtySet);
		Vet v2 = new Vet(2L,"Jane","Doe",specialtySet);
		vetService.save(v1);
		vetService.save(v2);
	}

	@Test
	void testListVets() {
		Model model = new ModelMapImpl();


		assertThat(vetController.listVets(model)).isEqualTo("vets/index");
		Set<Vet> s = (Set<Vet>) ((ModelMapImpl)model).getMap().get("vets");
		
		assertThat(s.size()).isEqualTo(2);
		assertThat(((ModelMapImpl)model).getMap().size()).isEqualTo(1);

	}

}

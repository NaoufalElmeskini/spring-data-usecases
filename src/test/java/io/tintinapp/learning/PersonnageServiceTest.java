package io.tintinapp.learning;

import io.tintinapp.learning.domain.infra.AccessoireRepo;
import io.tintinapp.learning.domain.infra.PersonnageRepository;
import io.tintinapp.learning.domain.infra.entity.Accessoire;
import io.tintinapp.learning.domain.infra.entity.Personnage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class PersonnageServiceTest {

	@Autowired
	private PersonnageService personnageService;

	@Autowired
	private PersonnageRepository personnageRepository;

	@Autowired
	private AccessoireRepo accessoireRepository;

	private Personnage tintin;

	@BeforeEach
	public void setUp() {
		tintin = Personnage.builder()
			.name("Tintin").build();
		personnageRepository.save(tintin);
	}


	@Test
	@DisplayName("step 1 : relation bi-directionnelle Personnage-accessoire")
	public void verifierLAssociationBiDirectionnelle() {
		// given
		Accessoire besace = Accessoire.builder()
			.name("besace").build();
		tintin.ajouterAccessoire(besace);
		personnageRepository.save(tintin);
		// when
		List<Accessoire> allAccessoires = accessoireRepository.findAll();
		// then
		assertThat(allAccessoires).hasSize(1);
		assertEquals(tintin.getName(), allAccessoires.getFirst().getProprio().getName());
	}


	@Test
	@DisplayName("step 2 : constater probleme N+1")
	public void verifierXXX() {
		// given : j'ai 2 personnage ayant chacun 1 accessoires
		
		// when : je recupere tous les personnages
		// then : je constate 1+2 (=3) requetes sql  
	}
}
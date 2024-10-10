package io.tintinapp.learning;

import io.tintinapp.learning.domain.infra.AccessoireRepo;
import io.tintinapp.learning.domain.infra.PersonnageRepository;
import io.tintinapp.learning.domain.infra.entity.Accessoire;
import io.tintinapp.learning.domain.infra.entity.Personnage;
import org.junit.jupiter.api.BeforeEach;
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
		// Add Tintin and his friends to the in-memory database
		
		tintin = new Personnage("Tintin");
		personnageRepository.save(tintin);
	}


	@Test
	public void verifierLAssociationBiDirectionnelle() {
		// given
		Accessoire besace = new Accessoire();
		besace.setName("besace");
		tintin.ajouterAccessoire(besace);
		personnageRepository.save(tintin);
		// when
		List<Accessoire> allAccessoires = accessoireRepository.findAll();
		// then
		assertThat(allAccessoires).hasSize(1);
		assertEquals(tintin.getName(), allAccessoires.getFirst().getProprio().getName());
	}
}
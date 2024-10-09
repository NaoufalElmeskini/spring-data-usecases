package io.tintinapp.learning;

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


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Transactional
public class PersonnageServiceTest {

	@Autowired
	private PersonnageService personnageService;

	@Autowired
	private PersonnageRepository personnageRepository;

	@BeforeEach
	public void setUp() {
		// Add Tintin and his friends to the in-memory database
		Accessoire besace = new Accessoire();
		besace.setName("besace");
		
		Personnage tintin = new Personnage("Tintin");
		tintin.setAccessoires(List.of(besace));
		personnageRepository.save(tintin);
		personnageRepository.save(new Personnage("Milou"));
	}

	@Test
	public void tintinScenario() {
		// Given: I am Tintin
		Personnage tintin = personnageRepository.findByName("Tintin").orElseThrow();

		// When: I retrieve all my friends
		List<Personnage> friends = personnageService.getFriendsOfTintin();

		// Then: Milou is returned
		assertThat(friends).extracting(Personnage::getName).contains("Milou");
	}
}
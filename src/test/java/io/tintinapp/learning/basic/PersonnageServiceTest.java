package io.tintinapp.learning.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import io.tintinapp.learning.MesBuilders;
import io.tintinapp.learning.basic.domain.infra.PersonnageService;
import io.tintinapp.learning.basic.domain.infra.entity.Personnage;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
// @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersonnageServiceTest {

	@Autowired
	private PersonnageService personnageService;

	@BeforeAll
	public void setUp() {
		List<Personnage> allPersonnages = List.of(
				MesBuilders.unPersonnage(
						"Tintin",
						MesBuilders.unAccessoire("besace")),
				MesBuilders.unPersonnage(
						"Milou",
						MesBuilders.unAccessoire("musoliere")));
		personnageService.creer(allPersonnages.toArray(new Personnage[0]));
	}

	@Test
	@DisplayName("step 0 : Lazy initialisation probleme")
	public void step0LaziInit() {
		// given : ...
		// when : ...

		assertThrows(LazyInitializationException.class,
			 () -> personnageService.someAccessoire());
	}

	@Test
	@Transactional
	@DisplayName("step 0 : Lazy initialisation probleme - corrige")
	public void step0LaziInitCorrige() {
		// given : ...
		// when : ...

		assertThat(personnageService.someAccessoire()).isPresent();
	}

	// @Test
	// @DisplayName("step 2 (wip) : constater probleme N+1")
	// public void constaterProblemeNPlus1() {
	// 	// given : j'ai 2 personnage ayant chacun 1 accessoires

	// 	// when : je cree tous les personnages
	// 	List<String> accessoireNoms = personnageService.getAllAccessoiresDesPersonnages();

	// 	log.info(accessoireNoms.toString());
	// 	assertThat(accessoireNoms).hasSize(2);
	// }
}
package io.tintinapp.learning.basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import io.tintinapp.learning.MesBuilders;
import io.tintinapp.learning.basic.domain.infra.AccessoireRepo;
import io.tintinapp.learning.basic.domain.infra.PersonnageRepository;
import io.tintinapp.learning.basic.domain.infra.PersonnageService;
import io.tintinapp.learning.basic.domain.infra.entity.Accessoire;
import io.tintinapp.learning.basic.domain.infra.entity.Personnage;
import lombok.extern.slf4j.Slf4j;


@SpringBootTest
@Slf4j
// @DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PersonnageServiceTest {

	@Autowired
	private PersonnageService personnageService;

	@Autowired
	private PersonnageRepository personnageRepository;

	@Autowired
	private AccessoireRepo accessoireRepository;

	@Test
	@DisplayName("step 1 : relation bi-directionnelle Personnage-accessoire")
	public void verifierLAssociationBiDirectionnelle() {
		// given
		Personnage tintin = MesBuilders.unPersonnage(
			"Tintin", 
			MesBuilders.unAccessoire("besace"));
		personnageRepository.save(tintin);
		// when
		List<Accessoire> allAccessoires = accessoireRepository.findAll();
		// then
		assertThat(allAccessoires).hasSize(1);
		assertEquals(tintin.getNom(), allAccessoires.getFirst().getProprio().getNom());
	}

	@Test
	@DisplayName("step 2 (wip) : constater probleme N+1")
	public void constaterProblemeNPlus1() {
		// given : j'ai 2 personnage ayant chacun 1 accessoires		
		Personnage tintin = MesBuilders.unPersonnage(
			"Tintin", 
			MesBuilders.unAccessoire("besace"));
		Personnage milou = MesBuilders.unPersonnage(
			"Milou", 
			MesBuilders.unAccessoire("musoliere"));
		
		tintin = personnageRepository.save(tintin);
		milou = personnageRepository.save(milou);

		tintin.ajouterAccessoire(MesBuilders.unAccessoire("lunettes"));
		// when : je recupere tous les personnages
		List<Personnage> allPersonnages = personnageService.getAll();

		// then : je constate 1+2 (=3) requetes sql  ?
		// for (Personnage p : allPersonnages) {
		// 	for (Accessoire a : p.getAccessoires()) {
		// 		System.out.println(a.getNom());  // Forcer l'accès complet aux accessoires
		// 	}
		// }
		
		assertThat(allPersonnages
			// .stream()
			// 	.flatMap(p -> p.getAccessoires().stream())
			// 	.toList()
				)
			.hasSize(2);
	}
}
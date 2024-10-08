package io.tintinapp.learning;

import io.tintinapp.learning.entity.Person;
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
public class PersonServiceTest {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonRepository personRepository;

	@BeforeEach
	public void setUp() {
		// Add Tintin and his friends to the in-memory database
		personRepository.save(new Person("Tintin"));
		personRepository.save(new Person("Milou"));
	}

	@Test
	public void tintinScenario() {
		// Given: I am Tintin
		Person tintin = personRepository.findByName("Tintin").orElseThrow();

		// When: I retrieve all my friends
		List<Person> friends = personService.getFriendsOfTintin();

		// Then: Milou is returned
		assertThat(friends).extracting(Person::getName).contains("Milou");
	}
}
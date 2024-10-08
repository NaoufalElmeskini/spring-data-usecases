package io.tintinapp.learning;



import io.tintinapp.learning.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> getFriendsOfTintin() {
		// Here we assume Tintin has a specific set of friends stored in the DB.
		return personRepository.findAll();
	}
}
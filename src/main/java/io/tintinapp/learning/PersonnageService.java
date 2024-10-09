package io.tintinapp.learning;



import io.tintinapp.learning.domain.infra.PersonnageRepository;
import io.tintinapp.learning.domain.infra.entity.Personnage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnageService {

	private final PersonnageRepository personnageRepository;

	public PersonnageService(PersonnageRepository personnageRepository) {
		this.personnageRepository = personnageRepository;
	}

	public List<Personnage> getFriendsOfTintin() {
		// Here we assume Tintin has a specific set of friends stored in the DB.
		return personnageRepository.findAll();
	}
}
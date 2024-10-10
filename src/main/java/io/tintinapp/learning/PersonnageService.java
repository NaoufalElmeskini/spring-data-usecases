package io.tintinapp.learning;



import io.tintinapp.learning.domain.infra.AccessoireRepo;
import io.tintinapp.learning.domain.infra.entity.Personnage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnageService {

	private final AccessoireRepo personnageRepository;

	public PersonnageService(AccessoireRepo personnageRepository) {
		this.personnageRepository = personnageRepository;
	}

	public List<Personnage> getFriendsOfTintin() {
		// Here we assume Tintin has a specific set of friends stored in the DB.
		return personnageRepository.findAll();
	}
}
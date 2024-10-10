package io.tintinapp.learning;



import io.tintinapp.learning.domain.infra.AccessoireRepo;
import io.tintinapp.learning.domain.infra.PersonnageRepository;
import io.tintinapp.learning.domain.infra.entity.Accessoire;
import io.tintinapp.learning.domain.infra.entity.Personnage;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonnageService {

	private final PersonnageRepository personnageRepository;

    public List<Personnage> getAll() {
		return personnageRepository.findAll();		
    }
}
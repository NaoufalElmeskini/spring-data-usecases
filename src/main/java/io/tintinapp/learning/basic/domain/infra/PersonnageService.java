package io.tintinapp.learning.basic.domain.infra;



import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import io.tintinapp.learning.basic.domain.infra.entity.Accessoire;
import io.tintinapp.learning.basic.domain.infra.entity.Personnage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonnageService {

	private final PersonnageRepository personnageRepository;

    public List<Personnage> getAll() {
		return personnageRepository.findAll();		
    }
}
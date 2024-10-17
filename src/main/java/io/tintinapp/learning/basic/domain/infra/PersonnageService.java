package io.tintinapp.learning.basic.domain.infra;

import java.util.List;

import org.springframework.stereotype.Service;

import io.tintinapp.learning.basic.domain.infra.entity.Personnage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonnageService {

  private final PersonnageRepository personnageRepository;

  public List<Personnage> getAll() {
    return personnageRepository.findAll();
  }
}
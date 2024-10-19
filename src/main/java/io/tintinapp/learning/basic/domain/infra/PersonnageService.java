package io.tintinapp.learning.basic.domain.infra;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import io.tintinapp.learning.basic.domain.infra.entity.Accessoire;
import io.tintinapp.learning.basic.domain.infra.entity.Personnage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonnageService {

  private final PersonnageRepository personnageRepository;

  public List<Personnage> getAll() {
    return personnageRepository.findAll();
  }

  public void creer(Personnage... personnage) {
    personnageRepository.saveAll(List.of(personnage));
  }

  public List<String> getAllAccessoiresDesPersonnages() {
    return getAll().stream()
        .flatMap(perso -> perso.getAccessoires().stream())
        .map(acc -> acc.getNom())
        .toList();
  }

  public Optional<Accessoire> someAccessoire() {
    return getAll().stream()
      .findAny()
      .map(perso -> perso.getAccessoires().stream().findAny())
        .orElseThrow();
  }
}
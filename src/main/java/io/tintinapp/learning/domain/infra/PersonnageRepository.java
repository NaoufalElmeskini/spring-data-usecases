package io.tintinapp.learning.domain.infra;


import io.tintinapp.learning.domain.infra.entity.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Long> {
    Optional<Personnage> findByNom(String name);
}

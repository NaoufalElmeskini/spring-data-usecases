package io.tintinapp.learning.basic.domain.infra;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.tintinapp.learning.basic.domain.infra.entity.Accessoire;
import io.tintinapp.learning.basic.domain.infra.entity.Personnage;

import java.util.Optional;

@Repository
public interface AccessoireRepo extends JpaRepository<Accessoire, Long> {
    Optional<Accessoire> findByNom(String name);
}

package io.tintinapp.learning.domain.infra;


import io.tintinapp.learning.domain.infra.entity.Accessoire;
import io.tintinapp.learning.domain.infra.entity.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccessoireRepo extends JpaRepository<Accessoire, Long> {
    Optional<Accessoire> findByName(String name);
}

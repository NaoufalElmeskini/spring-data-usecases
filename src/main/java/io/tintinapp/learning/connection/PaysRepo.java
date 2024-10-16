package io.tintinapp.learning.connection;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.tintinapp.learning.connection.Pays;

import java.util.Optional;

@Repository
public interface PaysRepo extends JpaRepository<Pays, Long> {
    Optional<Pays> findByNom(String name);
}

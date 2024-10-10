package io.tintinapp.learning;

import io.tintinapp.learning.domain.infra.entity.Accessoire;
import io.tintinapp.learning.domain.infra.entity.Personnage;

public class MesBuilders {

    public static Personnage unPersonnage(String nom, Accessoire accessoire) {
        Personnage personnage = Personnage.builder()
            .build();
        personnage.ajouterAccessoire(accessoire);
        return personnage;
    }

    public static Accessoire unAccessoire(String nom) {
        return Accessoire.builder()
            .nom(nom).build();
    }

}

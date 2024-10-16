package io.tintinapp.learning;

import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;

import io.tintinapp.learning.basic.domain.infra.entity.Accessoire;
import io.tintinapp.learning.basic.domain.infra.entity.Personnage;
import io.tintinapp.learning.connection.Pays;

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

    public static Pays unPays(String nom) {
        return Pays.builder()
                .nom(nom)
                .build();
    }
    public static Pays unPays() {
        return unPays(RandomStringUtils.randomAlphabetic(5));
    }

    public static List<Pays> plusieursPays(int size) {
        return IntStream.range(0, size)
            .mapToObj(i -> unPays())
            .toList();
    }

}

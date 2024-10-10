package io.tintinapp.learning.domain.infra.entity;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Personnage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprio")
    private List<Accessoire> accessoires = new ArrayList();


    public Personnage(String name) {
        this.name = name;
    }


    public void ajouterAccessoire(Accessoire accessoire) {
        accessoires.add(accessoire);
        accessoire.setProprio(this);
    }

}

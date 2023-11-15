package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter  Long id;
    private @Getter @Setter String nom;
    @OneToMany(mappedBy = "categorie")
    private @Setter @Getter List<Sous_Categorie>sous_Categorie;

    public Categorie(String nom) {
        this.nom = nom;
    }

}

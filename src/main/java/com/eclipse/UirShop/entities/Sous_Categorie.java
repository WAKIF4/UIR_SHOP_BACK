package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
public class Sous_Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;
    private @Getter @Setter String nom;
    @JoinColumn(name = "categorie", referencedColumnName = "id")
    @ManyToOne
    private @Setter @Getter Categorie categorie;

    public Sous_Categorie(String nom) {
        this.nom = nom;
    }
}

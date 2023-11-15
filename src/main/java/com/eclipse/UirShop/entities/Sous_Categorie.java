package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor
@Data
public class Sous_Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String nom;
    @JoinColumn(name = "categorie", referencedColumnName = "id")
    @ManyToOne
    private  Categorie categorie;

    public Sous_Categorie(String nom) {
        this.nom = nom;
    }
}

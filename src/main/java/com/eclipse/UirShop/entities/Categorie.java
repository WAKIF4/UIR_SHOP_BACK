package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;
    private  String nom;
    @OneToMany(mappedBy = "categorie")
    private  List<Sous_Categorie>sous_Categorie;

    public Categorie(String nom) {
        this.nom = nom;
    }

}

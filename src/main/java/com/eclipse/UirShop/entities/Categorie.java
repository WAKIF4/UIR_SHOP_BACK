package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private   Long id;
//    @NotBlank(message = "name is required")
    @Column(unique = true)
    private  String nom;
    @OneToMany(mappedBy = "categorie")

    private  List<SousCategorie>sous_Categorie;

    public Categorie(String nom) {
        this.nom = nom;
    }

}

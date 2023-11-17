package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name is required")
    @Column(unique = true)
    private String nom;
    @OneToMany(mappedBy = "categorie")
    private List<SousCategorie> sous_Categorie;

    public Categorie(String nom) {
        this.nom = nom;
    }

}

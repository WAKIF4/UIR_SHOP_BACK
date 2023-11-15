package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class SousCategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
//    @NotBlank(message = "Name is required")
    @Column(unique = true)
    private  String nom;
    @JoinColumn(name = "categorie", referencedColumnName = "id")
    @ManyToOne
//    @NotBlank(message = "Category is required")
    private  Categorie categorie;

    public SousCategorie(String nom) {
        this.nom = nom;
    }
}

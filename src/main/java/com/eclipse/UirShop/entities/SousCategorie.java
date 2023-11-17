package com.eclipse.UirShop.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class SousCategorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(unique = true)
    private  String nom;

    @JoinColumn(name = "categorie", referencedColumnName = "id")
    @ManyToOne
    private  Categorie categorie;

    @OneToMany(mappedBy = "souscategorie")
    private List<Product> products;

    public SousCategorie(String nom) {
        this.nom = nom;
    }
}

package com.eclipse.UirShop.enitiesDto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Data
public class CategorieDtoWNList {
    private  Long id;
    private  String nom;

    public CategorieDtoWNList(String nom) {
        this.nom = nom;
    }
}

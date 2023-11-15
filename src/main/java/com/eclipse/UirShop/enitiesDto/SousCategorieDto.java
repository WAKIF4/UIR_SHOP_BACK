package com.eclipse.UirShop.enitiesDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SousCategorieDto {
    private  Long id;
    @NotBlank(message = "name is required")
    private  String nom;

    private  CategorieDtoWNList categorieDtoWNList;

    public SousCategorieDto(String nom, CategorieDtoWNList categorieDtoWNList) {
        this.nom = nom;
        this.categorieDtoWNList = categorieDtoWNList;
    }

    public SousCategorieDto(CategorieDtoWNList categorieDtoWNList) {
        this.categorieDtoWNList = categorieDtoWNList;
    }
}

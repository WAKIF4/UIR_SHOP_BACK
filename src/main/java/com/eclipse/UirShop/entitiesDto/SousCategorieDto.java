package com.eclipse.UirShop.entitiesDto;

import com.eclipse.UirShop.entitiesDto.CategorieDtoWNList;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SousCategorieDto {
    private  Long id;
    @NotBlank(message = "name is required")
    private  String nom;

    private CategorieDtoWNList category;

    public SousCategorieDto(String nom, CategorieDtoWNList categorieDtoWNList) {
        this.nom = nom;
        this.category = categorieDtoWNList;
    }

    public SousCategorieDto(CategorieDtoWNList categorieDtoWNList) {
        this.category = categorieDtoWNList;
    }
}

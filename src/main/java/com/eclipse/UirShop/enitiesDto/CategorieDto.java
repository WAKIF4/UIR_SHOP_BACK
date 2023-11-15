package com.eclipse.UirShop.enitiesDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@Data
public class CategorieDto {
    private  Long id;
//    @NotBlank(message = "name is required")
    private  String nom;
    private  List<SousCategorieDto> sous_Categorie;
}

package com.eclipse.UirShop.enitiesDto;

import com.eclipse.UirShop.entities.Categorie;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Data
public class Sous_CategorieDto {
    private  Long id;
    private  String nom;
    private  CategorieDtoWNList categorieDtoWNList;
}

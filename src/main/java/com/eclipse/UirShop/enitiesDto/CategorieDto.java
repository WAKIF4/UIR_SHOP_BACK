package com.eclipse.UirShop.enitiesDto;

import com.eclipse.UirShop.entities.Sous_Categorie;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Data
public class CategorieDto {
    private  Long id;
    private  String nom;
    private  List<Sous_CategorieDto> sous_Categorie;
}

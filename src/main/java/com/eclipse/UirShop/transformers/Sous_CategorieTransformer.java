package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.enitiesDto.CategorieDtoWNList;
import com.eclipse.UirShop.enitiesDto.Sous_CategorieDto;
import com.eclipse.UirShop.entities.Sous_Categorie;

public class Sous_CategorieTransformer {
    public Sous_Categorie toEntity(Sous_CategorieDto sgDto){
        Sous_Categorie sg=new Sous_Categorie();
        sg.setNom(sgDto.getNom());
        return  sg;
    }

    public Sous_CategorieDto toDto(Sous_Categorie sousCategorie){
        Sous_CategorieDto sgdto=new Sous_CategorieDto();
        sgdto.setNom(sousCategorie.getNom());
        sgdto.setCategorieDtoWNList(CategorieTransformer.toDtoWl(sousCategorie.getCategorie()));
        return sgdto;
    }
}

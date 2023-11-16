package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.entitiesDto.SousCategorieDto;
import com.eclipse.UirShop.entities.SousCategorie;

public class Sous_CategorieTransformer {

    public static SousCategorie toEntity(SousCategorieDto sgDto){
        SousCategorie sg=new SousCategorie();
        sg.setId(sgDto.getId());
        sg.setNom(sgDto.getNom());
        sg.setCategorie(CategorieTransformer.toEntity(sgDto.getCategory()));
        return  sg;
    }

    public static SousCategorieDto toDto(SousCategorie sousCategorie){
       SousCategorieDto sgdto=new SousCategorieDto();
        sgdto.setId((sousCategorie.getId()));
        sgdto.setNom(sousCategorie.getNom());
        sgdto.setCategory((CategorieTransformer.toDtoWl(sousCategorie.getCategorie())));
        return sgdto;
    }
}

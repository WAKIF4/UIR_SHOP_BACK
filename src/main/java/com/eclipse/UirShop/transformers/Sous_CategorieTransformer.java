package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.enitiesDto.SousCategorieDto;
import com.eclipse.UirShop.entities.SousCategorie;

public class Sous_CategorieTransformer {
//    @Autowired
//    private Sous_Categorie sg;

//    @Autowired
//    private Sous_CategorieDto sgdto;

    public static SousCategorie toEntity(SousCategorieDto sgDto){
        SousCategorie sg=new SousCategorie();
        sg.setId(sgDto.getId());
        sg.setNom(sgDto.getNom());
        sg.setCategorie(CategorieTransformer.toEntity(sgDto.getCategorieDtoWNList()));
        return  sg;
    }

    public static SousCategorieDto toDto(SousCategorie sousCategorie){
       SousCategorieDto sgdto=new SousCategorieDto();
        sgdto.setId((sousCategorie.getId()));
        sgdto.setNom(sousCategorie.getNom());
        sgdto.setCategorieDtoWNList(CategorieTransformer.toDtoWl(sousCategorie.getCategorie()));
        return sgdto;
    }
}

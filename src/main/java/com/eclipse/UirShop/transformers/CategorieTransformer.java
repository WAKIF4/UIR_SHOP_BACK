package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.enitiesDto.CategorieDto;
import com.eclipse.UirShop.enitiesDto.CategorieDtoWNList;
import com.eclipse.UirShop.entities.Categorie;

import java.util.ArrayList;

public class CategorieTransformer {

//    public Categorie toEntity(CategorieDto categorieDto){
//        Categorie c=new Categorie();
//        c.setNom(categorieDto.getNom());
//        c.setSous_Categorie(categorieDto.getSous_Categorie());
//        return c;
//    }
    public static CategorieDto toDto(Categorie categorie){
        CategorieDto cdt=new CategorieDto();

        cdt.setNom(cdt.getNom());
        cdt.setSous_Categorie(cdt.getSous_Categorie());
        return cdt;
    }

    public static CategorieDtoWNList toDtoWl(Categorie categorie){
        CategorieDtoWNList cdtw=new CategorieDtoWNList();
        cdtw.setId(categorie.getId());
        cdtw.setNom(categorie.getNom());
        return cdtw;
    }

}

package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.entitiesDto.CategorieDto;
import com.eclipse.UirShop.entitiesDto.CategorieDtoWNList;
import com.eclipse.UirShop.entities.Categorie;

public class CategorieTransformer {


    public static Categorie toEntity(CategorieDtoWNList categorieDtoWNList){
        Categorie c=new Categorie();
        c.setId(categorieDtoWNList.getId());
        c.setNom(categorieDtoWNList.getNom());
        return c;
    }
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

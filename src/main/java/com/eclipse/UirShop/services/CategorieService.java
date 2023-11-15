package com.eclipse.UirShop.services;

import com.eclipse.UirShop.enitiesDto.CategorieDtoWNList;
import com.eclipse.UirShop.entities.Categorie;
import com.eclipse.UirShop.repositories.ICategorieRepository;
import com.eclipse.UirShop.transformers.CategorieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private ICategorieRepository categorieRepository;

    public List<CategorieDtoWNList>getAll(){
        Optional<List<Categorie>>categorie= Optional.of(categorieRepository.findAll());
        List<CategorieDtoWNList>cwl=categorie.get().stream().map(CategorieTransformer::toDtoWl).toList();
        return cwl;
    }

}

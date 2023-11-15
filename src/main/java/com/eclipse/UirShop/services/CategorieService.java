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

    private final ICategorieRepository categorieRepository;

    public CategorieService(ICategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<CategorieDtoWNList>getAll(){
        Optional<List<Categorie>>categorie= Optional.of(categorieRepository.findAll());
        List<CategorieDtoWNList>cwl=categorie.get().stream().map(CategorieTransformer::toDtoWl).toList();
        return cwl;
    }

    public Optional<CategorieDtoWNList>getById(Long id){
        Optional<Categorie> c=categorieRepository.findById(id);
        return Optional.of(CategorieTransformer.toDtoWl(c.orElseThrow()));
    }

    public Optional<CategorieDtoWNList>addCategorie(CategorieDtoWNList cdtl){
        Categorie categorie=categorieRepository.save(CategorieTransformer.toEntity(cdtl));
        return Optional.of(CategorieTransformer.toDtoWl(categorie));
    }

    public Optional<CategorieDtoWNList>updateCategorie(CategorieDtoWNList cdtl,Long id){
        Categorie categorie=CategorieTransformer.toEntity(cdtl);
        Optional<Categorie> catToUpdate=categorieRepository.findById(id);
        if(catToUpdate.isPresent()){
           Categorie cat=catToUpdate.get();
           cat.setNom(categorie.getNom());
           return Optional.of(CategorieTransformer.toDtoWl(categorieRepository.save(cat)));
        }
        return Optional.empty();
    }
    public void deleteCategorie(Long id){
        categorieRepository.deleteById(id);
    }

}

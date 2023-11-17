package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entitiesDto.SousCategorieDto;
import com.eclipse.UirShop.entities.SousCategorie;
import com.eclipse.UirShop.repositories.ICategorieRepository;
import com.eclipse.UirShop.repositories.ISousCategorieRepository;
import com.eclipse.UirShop.transformers.Sous_CategorieTransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SousCategorieService {
    private final ISousCategorieRepository sousCategorieRepository;
    private final ICategorieRepository categorieRepository;




    public List<SousCategorieDto> getAll(){
        Optional<List<SousCategorie>>sousCategories=Optional.of(sousCategorieRepository.findAll());
        List<SousCategorieDto>scdto=sousCategories.get().stream().map(Sous_CategorieTransformer::toDto).toList();
        return  scdto;
    }

    public Optional<SousCategorieDto>getById(Long id){

        Optional<SousCategorie>sg=sousCategorieRepository.findById(id);
        return Optional.of(Sous_CategorieTransformer.toDto(sg.orElseThrow()));}

    public Optional<SousCategorieDto>addSousCategorie(SousCategorieDto sousCategorieDto){

        SousCategorie sousCategorie=sousCategorieRepository.save(Sous_CategorieTransformer.toEntity(sousCategorieDto));
        return Optional.of(Sous_CategorieTransformer.toDto(sousCategorie));
    }

    public Optional<SousCategorieDto>updateSousCategorie(SousCategorieDto sgdto, Long id){
        SousCategorie sousCategorie=Sous_CategorieTransformer.toEntity(sgdto);
        Optional<SousCategorie> sgUpdate=sousCategorieRepository.findById(id);
        if(sgUpdate.isPresent()){
            SousCategorie sg=sgUpdate.get();
            sg.setCategorie(sousCategorie.getCategorie());
            sg.setNom(sousCategorie.getNom());
            return Optional.of(Sous_CategorieTransformer.toDto(sousCategorieRepository.save(sg)));

        }
        return Optional.empty();

    }
    public void delete(Long id){
        sousCategorieRepository.deleteById(id);
    }
}

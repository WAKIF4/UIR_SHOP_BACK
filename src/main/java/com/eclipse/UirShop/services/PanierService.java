package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Panier;
import com.eclipse.UirShop.entitiesDto.PanierDto;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.PanierRepository;
import com.eclipse.UirShop.transformers.PanierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanierService {

    private PanierRepository panierRepository;

    @Autowired
    public PanierService(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    public PanierDto createPanier(PanierDto panierDto) {
        try {
            Panier panier = PanierMapper.mapToPanier(panierDto);
            Panier savePanier = panierRepository.save(panier);
            return PanierMapper.mapToPanierDto(savePanier);

        }catch (Exception e) {
            throw new RuntimeException("Error creating Panier: " + e.getMessage(), e);
        }
    }

    public List<PanierDto> getAllPanier() {
        List<Panier> paniers = panierRepository.findAll();
        return paniers.stream()
                .map(PanierMapper::mapToPanierDto)
                .collect(Collectors.toList());
    }


    public PanierDto getPanierById(Long id) {
        Panier panier = panierRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Panier not found with id: " + id));

        return PanierMapper.mapToPanierDto(panier);
    }


    public Optional<PanierDto> updatePanier(Long id, PanierDto panierDto) {
        Panier p=PanierMapper.mapToPanier(panierDto);
        Optional<Panier> existingPanier = panierRepository.findById(id);
        // problem those note site ref
        if(existingPanier.isPresent()){
            Panier p1=existingPanier.get();
            p1.setRef(p.getRef());
            p1.setTotalPrice(p.getTotalPrice());
            return Optional.of(PanierMapper.mapToPanierDto(panierRepository.save(p1)));
        }

        return Optional.empty();
    }

    public void deletePanier(Long id) {
        panierRepository.deleteById(id);
    }


}

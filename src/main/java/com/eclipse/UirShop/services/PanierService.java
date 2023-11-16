package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.Panier;
import com.eclipse.UirShop.entitiesDto.PanierDto;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.PanierRepository;
import com.eclipse.UirShop.transformers.PanierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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


    public PanierDto updatePanier(Long id, PanierDto panierDto) {

        Panier existingPanier = panierRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Panier not found with id: " + id));

        // problem those note site ref

        existingPanier.setTotalPrice(panierDto.getTotalPrice());
        Panier updatedPanier = panierRepository.save(existingPanier);
        return PanierMapper.mapToPanierDto(updatedPanier);
    }

    public void deletePanier(Long id) {
        panierRepository.deleteById(id);
    }


}

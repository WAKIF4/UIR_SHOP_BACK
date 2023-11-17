package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.entitiesDto.PanierDto;
import com.eclipse.UirShop.entitiesDto.ProductDto;
import com.eclipse.UirShop.services.PanierService;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/paniers")
public class PanierController {

    private final PanierService panierService;

    public PanierController(PanierService panierService) {
        this.panierService = panierService;
    }

    // http://localhost:8080/api/paniers
    @GetMapping
    public ResponseEntity<List<PanierDto>> getALlPaniers() {
        List<PanierDto> panierDtos = panierService.getAllPanier();
        return new ResponseEntity<>(panierDtos, HttpStatus.OK);
    }

    //http://localhost:8080/api/paniers
    @PostMapping
    public ResponseEntity<PanierDto> createPanier(@Valid @RequestBody PanierDto panierDto) {
        PanierDto savePanier = panierService.createPanier(panierDto);
        return new ResponseEntity<>(savePanier, HttpStatus.CREATED);
    }

    // http://localhost:8080/api/paniers/1
    @GetMapping("{id}")
    public ResponseEntity<PanierDto> getPanierById(@PathVariable("id") Long id) {
        PanierDto panierDto = panierService.getPanierById(id);
        return new ResponseEntity<>(panierDto, HttpStatus.OK);
    }

    //http://localhost:8080/api/paniers/1
    @PutMapping("{id}")
    public ResponseEntity<Optional<PanierDto>> updatePanier(@PathVariable("id") Long id,
                                                           @RequestBody PanierDto panierDto) {
        Optional<PanierDto> updatePanier = panierService.updatePanier(id, panierDto);
        return new ResponseEntity<>(updatePanier, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePanier(@PathVariable("id") Long id) {
        panierService.deletePanier(id);
        return new ResponseEntity<>("Panier successfully deleted!", HttpStatus.OK);
    }

}

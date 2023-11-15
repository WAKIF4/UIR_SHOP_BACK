package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.entitiesDto.PanierDto;
import com.eclipse.UirShop.entitiesDto.ProductDto;
import com.eclipse.UirShop.services.PanierService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/paniers")
public class PanierController {

    private PanierService panierService;

    // http://localhost:8080/api/paniers
    @GetMapping
    public ResponseEntity<List<PanierDto>> getALlPaniers() {
        List<PanierDto> panierDtos = panierService.getAllPanier();
        return new ResponseEntity<>(panierDtos, HttpStatus.OK);
    }

    //http://localhost:8080/api/paniers
    @PostMapping
    public ResponseEntity<PanierDto> createPanier(@RequestBody PanierDto panierDto) {
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
    public ResponseEntity<PanierDto> updatePanier(@PathVariable("id") Long id,
                                                    @RequestBody PanierDto panierDto) {
        PanierDto updatePanier = panierService.updatePanier(id, panierDto);
        return new ResponseEntity<>(updatePanier, HttpStatus.OK);
    }


}

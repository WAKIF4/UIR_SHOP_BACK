package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.enitiesDto.SousCategorieDto;
import com.eclipse.UirShop.services.SousCategorieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SousCategorieController {
    @Autowired
    private SousCategorieService sousCategorieService;
    @GetMapping("/souscategorie")
    public ResponseEntity<List<SousCategorieDto>> getAll() {
        List<SousCategorieDto>sfdto=sousCategorieService.getAll();
        return new ResponseEntity<>(sfdto, HttpStatus.OK);
    }
    @GetMapping("/souscategorie/{id}")
    public ResponseEntity<Optional<SousCategorieDto>> getById(@PathVariable Long id) {
        Optional<SousCategorieDto>sgdto=sousCategorieService.getById(id);
        return  new ResponseEntity<>(sgdto,HttpStatus.OK);
    }
    @PostMapping("/souscategorie")
    public ResponseEntity<Optional<SousCategorieDto>> addSousCategorie( @RequestBody SousCategorieDto sousCategorieDto) {
        Optional<SousCategorieDto>sgdto= sousCategorieService.addSousCategorie(sousCategorieDto);
        return new ResponseEntity<>(sgdto,HttpStatus.CREATED);
    }
    @PutMapping("/souscategorie/{id}")
    public ResponseEntity<Optional<SousCategorieDto>> updateSousCategorie(@RequestBody SousCategorieDto sgdto, @PathVariable Long id) {
        Optional<SousCategorieDto>sg=sousCategorieService.updateSousCategorie(sgdto, id);
        return new ResponseEntity<>(sg,HttpStatus.OK);
    }
    @DeleteMapping("/souscategorie/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        sousCategorieService.delete(id);
        return new ResponseEntity<>("Sous categorie supprime avec succes", HttpStatus.OK);
    }
}

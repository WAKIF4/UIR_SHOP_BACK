package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.enitiesDto.CategorieDtoWNList;
import com.eclipse.UirShop.services.CategorieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
@GetMapping("/categories")
    public ResponseEntity<List<CategorieDtoWNList>> getAll() {
       List<CategorieDtoWNList>catL= categorieService.getAll();
    return new ResponseEntity<>(catL, HttpStatus.OK);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<Optional<CategorieDtoWNList>> getById(@PathVariable Long id) {
      Optional<CategorieDtoWNList> cdt= categorieService.getById(id);
        return new ResponseEntity<>(cdt, HttpStatus.OK);
    }
    @PostMapping("/categories")
    public ResponseEntity<Optional<CategorieDtoWNList>> addCategorie(@Valid @RequestBody CategorieDtoWNList cdtl) {
        Optional<CategorieDtoWNList> cdt= categorieService.addCategorie(cdtl);
        return  new ResponseEntity<>(cdt,HttpStatus.CREATED);
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<Optional<CategorieDtoWNList>> updateCategorie(@RequestBody CategorieDtoWNList cdtl,@PathVariable Long id) {
        Optional<CategorieDtoWNList> cdt= categorieService.updateCategorie(cdtl, id);
        return  new ResponseEntity<>(cdt,HttpStatus.OK);
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategorie(@PathVariable Long id) {
        categorieService.deleteCategorie(id);
        return new ResponseEntity<>("Categorie supprime avec succes", HttpStatus.OK);
    }


}

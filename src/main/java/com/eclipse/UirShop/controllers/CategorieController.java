package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.enitiesDto.CategorieDtoWNList;
import com.eclipse.UirShop.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
@GetMapping("/categories")
    public List<CategorieDtoWNList> getAll() {
        return categorieService.getAll();
    }
}

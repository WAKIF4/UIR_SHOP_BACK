package com.eclipse.UirShop.enitiesDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Data
public class CategorieDtoWNList {
    private  Long id;
//    @NotBlank(message = "name is required")
    private  String nom;

    public CategorieDtoWNList(String nom) {
        this.nom = nom;
    }
}

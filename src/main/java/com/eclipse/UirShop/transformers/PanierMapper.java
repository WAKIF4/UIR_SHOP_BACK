package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.entities.Panier;
import com.eclipse.UirShop.entitiesDto.PanierDto;

public class PanierMapper {

    public static PanierDto mapToPanierDto(Panier panier) {
        PanierDto panierDto = new PanierDto(
                panier.getId(),
                panier.getRef(),
                panier.getTotalPrice()
        );
        return panierDto;
    }

    public static Panier mapToPanier(PanierDto panierDto) {
        Panier panier = new Panier(
                panierDto.getRef(),
                panierDto.getTotalPrice()

        );
        return panier;
    }
}

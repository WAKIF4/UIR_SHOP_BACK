package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CommandeProduit {
    @EmbeddedId
    CommandeProduit_key id;

    @ManyToOne
    @MapsId("Product_id")
    @JoinColumn(name = "product")
    private Product product;

    @ManyToOne
    @MapsId("Order_id")
    @JoinColumn(name = "orders")
    private Order orders;
}

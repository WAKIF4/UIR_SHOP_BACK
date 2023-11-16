package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "paniers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Panier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String ref;

//    @NotBlank(message = "Total Price cannot be null")
    private   double totalPrice;


    @OneToMany(mappedBy = "paniers", cascade = CascadeType.ALL)
    private List<Product> products;


    public Panier(String ref, double totalPrice) {
        this.ref = ref;
        this.totalPrice = totalPrice;
    }
}

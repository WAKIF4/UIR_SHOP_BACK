package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Entity
@Table(name="products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter Long id;
    private @Getter String ref;

    @NotBlank(message = "Name cannot be empty")
    private @Getter @Setter String name;

    @DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0.0")
    @NotBlank(message = "Price cannot be null")
    private @Getter @Setter double price;
    @ElementCollection
    @Size(min = 2, max = 5, message = "Images should have between 2 and 5 elements")
    private @Getter @Setter List<String> images;
    @NotBlank(message = "Quantity cannot be null")
    private @Getter @Setter int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "panier_id")
    private Panier panier;

    public Product(String ref, String name, double price, List<String> images, int quantity) {
        this.ref = ref;
        this.name = name;
        this.price = price;
        this.images = images;
        this.quantity = quantity;
    }
}

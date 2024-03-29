package com.eclipse.UirShop.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Product {

    @Id
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String ref;

    @NotBlank(message = "Name cannot be empty")
    private  String name;

    //@DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0.0")
    // @NotBlank(message = "Price cannot be null")
    private  double price;
//    @ElementCollection
//    @Size(min = 2, max = 5, message = "Images should have between 2 and 5 elements")
    private  List<String> images;
    // @NotBlank(message = "Quantity cannot be null")
    private  int quantity;
    private Long nbview=0L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paniers_id")
    private Panier paniers;

    @JoinColumn(name = "souscategorie", referencedColumnName = "id")
    @ManyToOne
    private  SousCategorie souscategorie;
    @OneToMany(mappedBy ="product",cascade = CascadeType.ALL)

    private @Setter @Getter List<CommandeProduit> commandeProduits;

    @JoinColumn(name = "student", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.PERSIST)
    private  Student student;








    public Product(Long id,String ref, String name, double price, List<String> images, int quantity,Long view) {
        this.ref = ref;
        this.name = name;
        this.price = price;
        this.images = images;
        this.quantity = quantity;
        this.nbview=0L;
    }

}

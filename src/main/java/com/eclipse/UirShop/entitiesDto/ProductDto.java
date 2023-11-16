package com.eclipse.UirShop.entitiesDto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {


    private Long id;
    private String ref;
    private Long nbview;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    //@DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0.0")
    //@NotBlank(message = "Price cannot be null")
    private double price;

    private List<String> images;

    //@NotBlank(message = "Quantity cannot be null")
    private int quantity;
    private SousCategorieDto sousCategorie;
    private StudentDto studentDto;

//    public ProductDto(Long id,String ref, String name, double price, List<String> images, int quantity,Long nbview) {
//        this.id=id;
//        this.ref = ref;
//        this.name = name;
//        this.price = price;
//        this.images = images;
//        this.quantity = quantity;
//        this.nbview=nbview;
//    }
}

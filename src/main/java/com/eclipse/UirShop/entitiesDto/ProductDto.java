package com.eclipse.UirShop.entitiesDto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Long id;
    private String ref;
    @NotBlank(message = "Name cannot be empty")
    private String name;
    @DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0.0")
    @NotBlank(message = "Price cannot be null")
    private double price;
    @DecimalMin(value = "0.0", inclusive = false, message = "Value must be greater than 0.0")
    @NotBlank(message = "Price cannot be null")
    private List<String> images;

    @NotBlank(message = "Quantity cannot be null")
    private int quantity;




}

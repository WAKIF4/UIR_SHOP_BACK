package com.eclipse.UirShop.entitiesDto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDto {

    private Long id;
    private String ref;
    @NotBlank(message = "Total Price cannot be null")
    private double totalPrice;

}

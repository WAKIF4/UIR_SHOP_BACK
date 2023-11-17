package com.eclipse.UirShop.entitiesDto;


import com.eclipse.UirShop.entities.Product;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @NotBlank(message = "Full Name is required")
    @Size(min= 6, message = "Full Name must be at least 6 characteres")
    @Pattern( regexp = "^[a-zA-Z]+( [a-zA-Z]+)*$", message = "Invalid full name format. Please enter a valid full name.")
    @Getter @Setter
    private String fullname;

    @NotBlank(message = "Phone Number is required")
    @Getter @Setter
    private String phonenumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Getter @Setter
    private String email;

    @Getter @Setter
    private String biography;



    @NotBlank(message = "Image is required")
    @Getter @Setter
    private String image;

    /*
    @Getter
    @Setter
    private MultipartFile imageFile;*/

    @Getter @Setter
    private String instagram;

    @Getter @Setter
    private String facebook;

    @Getter @Setter
    private String tiktok;




}


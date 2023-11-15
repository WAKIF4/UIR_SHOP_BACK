package com.eclipse.UirShop.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
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

    @Getter @Setter
    private String instagram;

    @Getter @Setter
    private String facebook;

    @Getter @Setter
    private String tiktok;

    @OneToMany
    @Getter @Setter
    List<Product> productList;

}

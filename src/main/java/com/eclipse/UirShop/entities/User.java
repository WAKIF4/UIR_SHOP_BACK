package com.eclipse.UirShop.entities;

import com.eclipse.UirShop.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @Getter Long id;
    @NotBlank(message = "First name is required")
    @Size(min = 3, message = "Last name must be at least 3 characters")
    @Size(max = 20, message = "Last name must be at most 20 characters")
    private @Setter @Getter String firstname;
    @NotBlank(message = "Last name is required")
    @Size(min = 3, message = "Last name must be at least 3 characters")
    @Size(max = 20, message = "Last name must be at most 20 characters")
    private @Setter @Getter String lastname;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private @Setter @Getter String email;

    @NotBlank(message = "Password is required")
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$",
            message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and be at least 8 characters long."
    )
    private @Getter @Setter String password;
    @Pattern(
            regexp = "^(06|07|08|05)\\d{9}$",
            message = "Phone number should start with 06, 07, 08, or 05 followed by 9 digits"
    )
    private @Setter @Getter String phone;
    private @Setter @Getter Role role;

    public User(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.role = Role.CLIENT;
    }
}

package com.eclipse.UirShop.entitiesDto;


import com.eclipse.UirShop.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.context.properties.bind.DefaultValue;

@Data
@NoArgsConstructor
public class UserDto {
    private @Getter  Long id;

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
    @Column(unique = true)
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
    @Enumerated(EnumType.STRING)
    private @Setter @Getter Role role;

    public UserDto(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.role = Role.CLIENT;
    }}

//public class UserDto {
//>>>>>>> origin/Entity-Products-Panier
//}

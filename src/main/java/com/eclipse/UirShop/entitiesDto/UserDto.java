package com.eclipse.UirShop.entitiesDto;

import com.eclipse.UirShop.enums.Role;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private Role role;
}

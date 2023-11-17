package com.eclipse.UirShop.entitiesDto;

import com.eclipse.UirShop.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDtoWPass {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
}

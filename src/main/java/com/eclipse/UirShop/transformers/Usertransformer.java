package com.eclipse.UirShop.transformers;

import com.eclipse.UirShop.entities.User;
import com.eclipse.UirShop.entitiesDto.UserDto;
import com.eclipse.UirShop.exceptions.TransformationException;

public class Usertransformer {
    public static UserDto toDto(User user) {
        if (user == null) {
            throw new TransformationException("User is null. Cannot transform to UserDto.");
        }

        try {
            UserDto userDto = new UserDto();
            userDto.setEmail(user.getEmail());
            userDto.setId(user.getId());
            userDto.setFirstname(user.getFirstname());
            userDto.setLastname(user.getLastname());
            userDto.setRole(user.getRole());
            userDto.setPhone(user.getPhone());

            return userDto;
        }
        catch (Exception e) {
            throw new TransformationException("Error transforming User entity to UserDto.", e);
        }
    }

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            throw new TransformationException("UserDto is null. Cannot transform to User entity.");
        }

        try {
            User user = new User();
            user.setEmail(userDto.getEmail());
            user.setFirstname(userDto.getFirstname());
            user.setLastname(userDto.getLastname());
            user.setRole(userDto.getRole());
            user.setPhone(userDto.getPhone());

            return user;
        } catch (Exception e) {
            throw new TransformationException("Error transforming UserDto to User entity.", e);
        }
    }


}

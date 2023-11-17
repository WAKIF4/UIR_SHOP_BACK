package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.User;
import com.eclipse.UirShop.entitiesDto.UserDto;
import com.eclipse.UirShop.entitiesDto.UserDtoWPass;
import com.eclipse.UirShop.enums.Role;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.UserRepository;
import com.eclipse.UirShop.transformers.Usertransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDtoWPass getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return Usertransformer.toDtoPass(user);
    }

    public UserDto AddUser(UserDto userDto) {
        userDto.setRole(Role.CLIENT);
        User user = userRepository.save(Usertransformer.toEntity(userDto));
        return Usertransformer.toDto(user);
    }

    public List<UserDtoWPass> getByRole(Role role) {
        return userRepository.findAllByRole(role).stream().map(Usertransformer::toDtoPass).toList();
    }

    public List<UserDtoWPass> getAll() {
        return userRepository.findAll().stream().map(Usertransformer::toDtoPass).toList();
    }
}

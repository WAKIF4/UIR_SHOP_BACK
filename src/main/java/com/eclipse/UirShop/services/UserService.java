package com.eclipse.UirShop.services;

import com.eclipse.UirShop.entities.User;
import com.eclipse.UirShop.entitiesDto.UserDto;
import com.eclipse.UirShop.exceptions.NotFoundException;
import com.eclipse.UirShop.repositories.UserRepository;
import com.eclipse.UirShop.transformers.Usertransformer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserDto getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));

        return Usertransformer.toDto(user);
    }

    public UserDto AddUser(UserDto userDto) {
        User user = userRepository.save(Usertransformer.toEntity(userDto));
        return Usertransformer.toDto(user);
    }
}

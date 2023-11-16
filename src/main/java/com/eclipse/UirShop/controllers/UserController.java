package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.entities.User;
import com.eclipse.UirShop.entitiesDto.UserDto;
import com.eclipse.UirShop.entitiesDto.UserDtoWPass;
import com.eclipse.UirShop.enums.Role;
import com.eclipse.UirShop.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDtoWPass> getUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        UserDto user = userService.AddUser(userDto);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDtoWPass>> getAllByRole(@PathVariable Role role) {
        return ResponseEntity.ok().body(userService.getByRole(role));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDtoWPass>> getAll() {
        return ResponseEntity.ok().body(userService.getAll());
    }

}

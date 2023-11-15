package com.eclipse.UirShop.controllers;

import com.eclipse.UirShop.entitiesDto.UserDto;
import com.eclipse.UirShop.services.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        UserDto userDto = userService.getById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<UserDto> addUser(@Valid @RequestBody UserDto userDto) {
        UserDto user = userService.AddUser(userDto);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

}

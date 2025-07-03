package com.example.create_user.controller;

import com.example.create_user.dto.CreateRequestUserDto;
import com.example.create_user.dto.UserDto;
import com.example.create_user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usersAccount")
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@RequestBody @Valid CreateRequestUserDto requestUserDto) {
        return userService.save(requestUserDto);
    }

    @GetMapping
    public List<UserDto> findAll() {
        return userService.findAll();
    }
}

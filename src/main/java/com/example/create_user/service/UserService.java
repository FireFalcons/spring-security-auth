package com.example.create_user.service;

import com.example.create_user.dto.CreateRequestUserDto;
import com.example.create_user.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto save(CreateRequestUserDto requestUserDto);
    List<UserDto> findAll();
}

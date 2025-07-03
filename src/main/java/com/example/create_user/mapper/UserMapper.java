package com.example.create_user.mapper;

import com.example.create_user.dto.CreateRequestUserDto;
import com.example.create_user.dto.UserDto;
import com.example.create_user.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toModel(CreateRequestUserDto requestUserDto);
}

package com.example.create_user.service;

import com.example.create_user.dto.CreateRequestUserDto;
import com.example.create_user.dto.UserDto;
import com.example.create_user.mapper.UserMapper;
import com.example.create_user.model.User;
import com.example.create_user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto save(CreateRequestUserDto requestUserDto) {
        if (!requestUserDto.getPassword().equals(requestUserDto.getRepeat_password())) {
            throw new IllegalArgumentException("Password do not match");
        }

        User user = userMapper.toModel(requestUserDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto)
                .toList();
    }
}

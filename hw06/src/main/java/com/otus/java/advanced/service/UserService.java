package com.otus.java.advanced.service;

import com.otus.java.advanced.dto.UserDto;
import com.otus.java.advanced.model.UserMapper;
import com.otus.java.advanced.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper mapper;

    @Cacheable("users")
    public UserDto save(UserDto user){
        return mapper.toDto(userRepository.save(mapper.toEntity(user)));
    }
}

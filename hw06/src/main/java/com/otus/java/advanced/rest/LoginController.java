package com.otus.java.advanced.rest;

import com.otus.java.advanced.dto.UserDto;
import com.otus.java.advanced.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UserService userService;

    @PutMapping("/api/login")
    public UserDto saveBook( @RequestBody UserDto user) {
        return userService.save(user);
    }
}

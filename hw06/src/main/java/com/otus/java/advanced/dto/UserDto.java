package com.otus.java.advanced.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {
    private  String login;
    private String password;



    @Override
    public int hashCode() {
        return (int) (Math.random()*Integer.MAX_VALUE);
    }


}

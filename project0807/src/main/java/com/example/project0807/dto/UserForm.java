package com.example.project0807.dto;

import com.example.project0807.entity.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserForm {
    private Long id;
    private String name;
    private String email;

    public User toEntity() {
        return new User(null, name, email);
    }
}

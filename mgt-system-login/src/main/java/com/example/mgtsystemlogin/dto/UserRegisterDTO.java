package com.example.mgtsystemlogin.dto;

import lombok.Data;

@Data
public class UserRegisterDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String email;

    public UserRegisterDTO() {
    }
}

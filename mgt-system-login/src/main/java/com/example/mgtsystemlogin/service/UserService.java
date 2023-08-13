package com.example.mgtsystemlogin.service;

import com.example.mgtsystemlogin.dto.UserRegisterDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService implements UserDetailsService {

    void save(UserRegisterDTO userRegisterDTO);
}

package com.example.mgtsystemlogin.service;

import com.example.mgtsystemlogin.dto.UserRegisterDTO;
import com.example.mgtsystemlogin.model.Role;
import com.example.mgtsystemlogin.model.User;
import com.example.mgtsystemlogin.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserRegisterDTO userRegisterDTO) {
        User newUser = new User(
                userRegisterDTO.getFirstName(),
                userRegisterDTO.getLastName(),
                userRegisterDTO.getPassword(),
                userRegisterDTO.getEmail(),
                Arrays.asList(new Role("ROLE_USER"))
        );

        userRepository.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}

package com.example.mgtsystemlogin.repository;

import com.example.mgtsystemlogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.example.Security2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String u);
}

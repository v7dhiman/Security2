package com.example.Security2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    MyUserRepository myUserRepository;
    //Logic for getting user details
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  myUserRepository.findByUsername(username);
    }
}

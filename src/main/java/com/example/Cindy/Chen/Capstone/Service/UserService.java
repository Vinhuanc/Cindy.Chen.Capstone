package com.example.Cindy.Chen.Capstone.Service;
//This is an interface for the UserService
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Cindy.Chen.Capstone.UserRegistrationDto;
import com.example.Cindy.Chen.Capstone.Entity.User;



public interface UserService extends UserDetailsService {
   User findByEmail(String email);
   User save(UserRegistrationDto registration);
}
package com.example.Cindy.Chen.Capstone.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Cindy.Chen.Capstone.UserRegistrationDto;
import com.example.Cindy.Chen.Capstone.Entity.Role;
import com.example.Cindy.Chen.Capstone.Entity.User;
import com.example.Cindy.Chen.Capstone.Repository.UserRepository;



@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private BCryptPasswordEncoder passwordEncoder;

//This method finds whether a user has had a previous account, if the user has had a account,
// a message of "account already created" is displayed. If an user doesn't have a account,it directs
// user to the sign-up page   
   @Override
   public User findByEmail(String email){
       return userRepository.findByEmail(email);
   }
//This method registers a user to a new account. By creating a new User everytime, and inputting the user information by the information the User inputted, saves to the database, and saves to the userRepository.
   @Override
   public User save(UserRegistrationDto registration){
       User user = new User();
       user.setFirstName(registration.getFirstName());
       user.setLastName(registration.getLastName());
       user.setEmail(registration.getEmail());
       user.setPassword(passwordEncoder.encode(registration.getPassword()));
       user.setRoles(Arrays.asList(new Role("ROLE_USER")));
       return userRepository.save(user);
   }
//This method decides whether the username and password of the user matches. If the user has created an account but the inputs are wrong, the "invalid username or password" shows up.
//if the user has the login credentials correctly, then it authrozies the user access to the website.   
   @Override
   public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user = userRepository.findByEmail(email);
       if (user == null){
           throw new UsernameNotFoundException("Invalid username or password.");
       }
       return new org.springframework.security.core.userdetails.User(user.getEmail(),
               user.getPassword(),
               mapRolesToAuthorities(user.getRoles()));
   }

   private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
       return roles.stream()
               .map(role -> new SimpleGrantedAuthority(role.getName()))
               .collect(Collectors.toList());
   }

}



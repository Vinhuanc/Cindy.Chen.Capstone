package com.example.Cindy.Chen.Capstone.config;
//This class is the security configuration for the project. If a user successfully created an account
//then this configuration file allows the user to access the Home, Medication, and About page.If creating
//or login into an account fails, then it takes the user back to the login page. If the user wanted to 
//logout, after the user clicks the logout, it prevents the user from accessing the website without
//logging in
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.Cindy.Chen.Capstone.Service.UserServiceImpl;




@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
// We will create userService class in upcoming step
	
   @Lazy // pings when you tell it to (going to a route)
   @Autowired // pinging the repo / service frequently
   private UserServiceImpl userService;

   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http
               .authorizeRequests()
                   .antMatchers(
                		   "/login**",
                           "/registration**",
                           "/js/**",
                           "/css/**",
                           "/img/**",
                           "/webjars/**").permitAll()
                   .anyRequest().authenticated()
               .and()
                   .formLogin()
                       .loginPage("/login")
                           .permitAll()
               .and()
                   .logout()
                       .invalidateHttpSession(true)
                       .clearAuthentication(true)
                       .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                       .logoutSuccessUrl("/login?logout")
               .permitAll();
   }

   @Bean
   public BCryptPasswordEncoder passwordEncoder(){
       return new BCryptPasswordEncoder();
   }

   @Bean
   public DaoAuthenticationProvider authenticationProvider(){
       DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
       auth.setUserDetailsService(userService);
       auth.setPasswordEncoder(passwordEncoder());
       return auth;
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.authenticationProvider(authenticationProvider());
   }

}


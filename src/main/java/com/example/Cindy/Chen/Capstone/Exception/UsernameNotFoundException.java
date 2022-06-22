package com.example.Cindy.Chen.Capstone.Exception;
import org.springframework.http.HttpStatus;  
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsernameNotFoundException extends RuntimeException{
	UsernameNotFoundException(String userName){
		super("Couldn't find user with User Name: " + userName);
	}
}

package com.example.Cindy.Chen.Capstone.ServiceTest;
//This class is a Junit testing for testing the service class requirement

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.Cindy.Chen.Capstone.Entity.User;


public class UserServiceImplTest {
	
	@BeforeAll
	public static void setUp() {
		
		System.out.println("This is the before all of the test.");
	}
	
	@Test
	public void testCreateUser() {
		User user3 = new User();
		user3.setFirstName("Eli");
		user3.setLastName("Anderson");
		user3.setEmail("Eli.Anderson@gmail.com");
		user3.setPassword("eli123");
		
		assertEquals("Eli", user3.getFirstName());
		assertEquals("Anderson", user3.getLastName());
		assertEquals("Eli.Anderson@gmail.com", user3.getEmail());
		assertEquals("eli123", user3.getPassword());
		
		System.out.println("This is the test case.");
	}
	
	@AfterAll
	 public static void afterAll() {
	 System.out.println("This is the after all of the test.");
	 }
}

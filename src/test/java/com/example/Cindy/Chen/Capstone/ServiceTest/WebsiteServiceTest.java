package com.example.Cindy.Chen.Capstone.ServiceTest;
//This class is a Junit testing for testing the service class requirement


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Cindy.Chen.Capstone.Repository.WebsiteRepository;


public class WebsiteServiceTest {
	@Autowired
	private WebsiteRepository websiteRepository;
	
	@BeforeAll
	public static void setUp() {
		
		System.out.println("This is the before all of the test.");
	}
	
	@Test
	public void testList() {
	String[] list = {"https://www.webmd.com/drugs/2/drug-841/atorvastatin-oral/details","https://www.webmd.com/drugs/2/drug-1531-3295/amoxicillin-oral/amoxicillin-oral/details","https://www.webmd.com/drugs/2/drug-6873-9371/lisinopril-oral/lisinopril-oral/details"};
	assertNotNull(list);
	System.out.println("This is the tested case.");
	}
	
	@AfterAll
	 public static void afterAll() {
	 System.out.println("This is the after all of the test.");
	 }
}

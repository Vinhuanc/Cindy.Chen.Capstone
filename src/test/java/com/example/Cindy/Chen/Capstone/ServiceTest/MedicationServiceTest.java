package com.example.Cindy.Chen.Capstone.ServiceTest;
//This class is a Junit testing for testing the service class requirement
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.example.Cindy.Chen.Capstone.Entity.Medication;




public class MedicationServiceTest {

 @BeforeAll
 public static void setUp() {
	
	 System.out.println("This is the before all of the test.");
 }
	 


 @Test
 public void testGet() {
	 Medication medication = new Medication();
	 medication.setMedicationID(100);
	 medication.setGenericName("testGenericName");
	 medication.setBrandName("testBrandName");
	 
	 String actual = medication.getBrandName();
	assertTrue(actual.contains("testBrandName"));
	System.out.println("This is the tested case.");
 }
 
 @AfterAll
 public static void afterAll() {
 System.out.println("This is the after all of the test.");
 }
}

package com.example.Cindy.Chen.Capstone.Queries;
//This class is a Junit testing for 1/3 of the custom query testing requirements

import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Cindy.Chen.Capstone.Entity.Medication;
import com.example.Cindy.Chen.Capstone.Repository.MedicationRepository;

@SpringBootTest
public class QueryThree {
	@Autowired
	private MedicationRepository medicationRepository2;

	private Medication medication;

	@BeforeAll
	public static void setupTwo() {
		System.out.println("This is the before all of the test.");
	}

	@BeforeEach
	public void setup() {
		medication = Medication.builder().genericName("Pravastatin").brandName("Pravachol").medicationClass("statins")
				.build();
		System.out.println("This is the before each of the test.");

	}

	@Test
	public void testDelete() {
		Medication medication = Medication.builder().genericName("Pravastatin").brandName("Pravachol")
				.medicationClass("statins").mainPurpose("testmainpurpose").upperBody("testupperbody")
				.lowerBody("testlowerbody").yearOfApproval(2022).prescriptionQuantity(1242)
				.introduction("testintroduction").URL("www.test").build();

		medicationRepository2.save(medication);
		medicationRepository2.deleteById(medication.getMedicationID());
		Optional<Medication> medicationOptional = medicationRepository2.findById(medication.getMedicationID());
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("This is the after all of the test.");
	}
}

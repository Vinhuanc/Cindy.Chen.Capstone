package com.example.Cindy.Chen.Capstone.Queries;
//This class is a Junit testing for 1/3 of the custom query testing requirements
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Cindy.Chen.Capstone.Entity.Medication;
import com.example.Cindy.Chen.Capstone.Repository.MedicationRepository;


//@ExtendWith(QueryOne.class)
//@DataJpaTest
@SpringBootTest
public class QueryOne {

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
	public void testSave() {
		Medication medication = Medication.builder().genericName("Pravastatin").brandName("Pravachol")
				.medicationClass("statins").mainPurpose("testmainpurpose").upperBody("testupperbody")
				.lowerBody("testlowerbody").yearOfApproval(2022).prescriptionQuantity(1242)
				.introduction("testintroduction").URL("www.test").build();

		Medication savedMedication = medicationRepository2.save(medication);
		assertThat(savedMedication).isNotNull();
		System.out.print("This is the test case.");
	}

	@AfterAll
	public static void afterAll() {
		System.out.println("This is the after all of the test.");
	}

}

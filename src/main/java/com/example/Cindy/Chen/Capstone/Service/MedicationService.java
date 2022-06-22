package com.example.Cindy.Chen.Capstone.Service;
//This class is created to handle methods from the medicationRepository.
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Cindy.Chen.Capstone.Entity.Medication;
import com.example.Cindy.Chen.Capstone.Repository.MedicationRepository;



@Service
@Transactional
public class MedicationService {
	@Autowired
	private MedicationRepository medicationRepository;
//This method used to list all of the medications. By returning the data from the medicationRepository
	public Iterable<Medication> listAll() {
		return medicationRepository.findAll();
	}
//This method saves the new medication to the medicationRepository
	public void save(Medication medication) {
		medicationRepository.save(medication);
	}
//This method selects certain medication to display
	public Medication get(int medicationID) {
		return medicationRepository.findById(medicationID).get();
	}
//This method deletes a certain medication by the user's inputted medicationID
	public void delete(int medicationID) {
		medicationRepository.deleteById(medicationID);
	}
}
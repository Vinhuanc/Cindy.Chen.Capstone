package com.example.Cindy.Chen.Capstone.Repository;
//This is an interface for the MedicationRepository, extends the pre-made CrudRepository
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.Cindy.Chen.Capstone.Entity.Medication;


public interface MedicationRepository extends CrudRepository<Medication, Integer>{

}



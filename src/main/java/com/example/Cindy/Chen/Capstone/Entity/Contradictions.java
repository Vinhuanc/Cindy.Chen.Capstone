package com.example.Cindy.Chen.Capstone.Entity;
//This class creates an table in SQL named Contradictions, inside the table, it has two
//columns, one for medication ID, and one for medication contradictions. The medication
//Contradictions are the medications that cannot be taken with other medications. Line 25-38
// are the getters and setters.
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contradictions implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer medicationID;
	
	public String contradictions;
	public Contradictions(Integer medicationID, String contradictions) {
		this.medicationID = medicationID;
		this.contradictions = contradictions;
	}
	public Contradictions() {
	}
	public Integer getMedicationID() {
		return medicationID;
	}
	public void setMedicationID(Integer medicationID) {
		this.medicationID = medicationID;
	}
	public String getContradictions() {
		return contradictions;
	}
	public void setContradictions(String contradictions) {
		this.contradictions = contradictions;
	}
	
	
}

package com.example.Cindy.Chen.Capstone.Entity;
//This class creates a table in SQL named "Website", it has two colomns, one for medication ID,
// and one for the official website URL. Line 27-41 are for getters and setters.
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Website")
public class Website implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer medicationID;
	public String websiteURL;

	public Website(Integer medicationID, String websiteURL) {
		this.medicationID = medicationID;
		this.websiteURL = websiteURL;
	}

	public Website() {
	}

	public Integer getMedicationID() {
		return medicationID;
	}

	public void setMedicationID(Integer medicationID) {
		this.medicationID = medicationID;
	}

	public String getWebsiteURL() {
		return websiteURL;
	}

	public void setWebsiteURL(String websiteURL) {
		this.websiteURL = websiteURL;
	}

}

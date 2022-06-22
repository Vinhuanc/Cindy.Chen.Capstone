package com.example.Cindy.Chen.Capstone.Entity;
//This class creates an table in SQL, with columns of medication ID, generic name, brand
//name, medication class, main purpose, year of approval, prescription quantity, introduction,
//image URL, upper body side effects, and lower body side effects. Line 58-144 are getters
// and setters.
import javax.validation.constraints.Size;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
@Builder

@Entity
public class Medication implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int medicationID;
	@Size(min=1, max=500)
	public String genericName;
	
	public String brandName;
	
	public String medicationClass;
	
	public String mainPurpose;
	public int yearOfApproval;
	public long prescriptionQuantity;
	
	public String introduction;
	public String URL;
	
	public String upperBody;
	
	public String lowerBody;

	public Medication(int medicationID, String genericName, String brandName, String medicationClass, String mainPurpose,
			int yearOfApproval, long prescriptionQuantity, String introduction, String URL,String upperBody, String lowerBody 	) {
		this.medicationID = medicationID;
		this.genericName = genericName;
		this.brandName = brandName;
		this.medicationClass = medicationClass;
		this.mainPurpose = mainPurpose;
		this.yearOfApproval = yearOfApproval;
		this.prescriptionQuantity = prescriptionQuantity;
		this.introduction = introduction;
		this.URL = URL;
		this.upperBody = upperBody;
		this.lowerBody = lowerBody;
	}

	public Medication() {
	}

	public int getMedicationID() {
		return medicationID;
	}

	public void setMedicationID(int medicationID) {
		this.medicationID = medicationID;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getMedicationClass() {
		return medicationClass;
	}

	public void setMedicationClass(String medicationClass) {
		this.medicationClass = medicationClass;
	}

	public String getMainPurpose() {
		return mainPurpose;
	}

	public void setMainPurpose(String mainPurpose) {
		this.mainPurpose = mainPurpose;
	}

	public int getYearOfApproval() {
		return yearOfApproval;
	}

	public void setYearOfApproval(int yearOfApproval) {
		this.yearOfApproval = yearOfApproval;
	}

	public long getPrescriptionQuantity() {
		return prescriptionQuantity;
	}

	public void setPrescriptionQuantity(long prescriptionQuantity) {
		this.prescriptionQuantity = prescriptionQuantity;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getUpperBody() {
		return upperBody;
	}

	public void setUpperBody(String upperBody) {
		this.upperBody = upperBody;
	}

	public String getLowerBody() {
		return lowerBody;
	}

	public void setLowerBody(String lowerBody) {
		this.lowerBody = lowerBody;
	}
	
}

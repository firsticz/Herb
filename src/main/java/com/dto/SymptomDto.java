package com.dto;

import org.bson.types.ObjectId;

public class SymptomDto {
	
	String id;
	String idSymtomGroup;
	String symptomName;
	String[] idDrugFormula;
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdSymtomGroup() {
		return idSymtomGroup;
	}
	public void setIdSymtomGroup(String idSymtomGroup) {
		this.idSymtomGroup = idSymtomGroup;
	}
	public String getSymptomName() {
		return symptomName;
	}
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}
	public String[] getIdDrugFormula() {
		return idDrugFormula;
	}
	public void setIdDrugFormula(String[] idDrugFormula) {
		this.idDrugFormula = idDrugFormula;
	}
	
}

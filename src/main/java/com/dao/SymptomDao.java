package com.dao;

public class SymptomDao {
	
	String idSymtomGroup;
	String symptomName;
	String[] idDrugFormula;
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

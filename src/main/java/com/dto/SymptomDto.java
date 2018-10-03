package com.dto;

public class SymptomDto {

	String name;
	String symptomGroupID;
	String[] formulaID;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymptomGroupID() {
		return symptomGroupID;
	}
	public void setSymptomGroupID(String symptomGroupID) {
		this.symptomGroupID = symptomGroupID;
	}
	public String[] getFormulaID() {
		return formulaID;
	}
	public void setFormulaID(String[] formulaID) {
		this.formulaID = formulaID;
	}
	
}

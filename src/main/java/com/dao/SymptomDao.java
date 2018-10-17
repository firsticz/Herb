package com.dao;

public class SymptomDao {
	
	String idSymtomGroup;
	String SymtomName;
	String[] idDrugFormula;
	
	public String getSymtomName() {
		return SymtomName;
	}
	public void setSymtomName(String symtomName) {
		SymtomName = symtomName;
	}
	public String[] getIdDrugFormula() {
		return idDrugFormula;
	}
	public void setIdDrugFormula(String[] idDrugFormula) {
		this.idDrugFormula = idDrugFormula;
	}
	public String getIdSymtomGroup() {
		return idSymtomGroup;
	}
	public void setIdSymtomGroup(String idSymtomGroup) {
		this.idSymtomGroup = idSymtomGroup;
	}
	
	

	
	
	
	
}

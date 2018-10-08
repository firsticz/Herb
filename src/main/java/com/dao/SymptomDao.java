package com.dao;

public class SymptomDao {
	
	SymptomGroupDao idSymtomGroup;
	String SymtomName;
	String[] idDrugFormula;
	
	public SymptomGroupDao getIdSymtomGroup() {
		return idSymtomGroup;
	}
	public void setIdSymtomGroup(SymptomGroupDao idSymtomGroup) {
		this.idSymtomGroup = idSymtomGroup;
	}
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
	

	
	
	
	
}

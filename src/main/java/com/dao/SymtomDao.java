package com.dao;

public class SymtomDao {
	
	SymtomGroupDao idSymtomGroup;
	String SymtomName;
	String[] idDrugFormula;
	
	public SymtomGroupDao getIdSymtomGroup() {
		return idSymtomGroup;
	}
	public void setIdSymtomGroup(SymtomGroupDao idSymtomGroup) {
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

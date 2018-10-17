package com.dto;

import org.bson.types.ObjectId;

public class SymptomDto {
	
	String id;
	String idSymtomGroup;
	String SymtomName;
	String[]  idDrugFormula;
	
	public ObjectId getId() {
		return new ObjectId(id);
	}
	public void setId(String id) {
		this.id = id;
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
	public String getIdSymtomGroup() {
		return idSymtomGroup;
	}
	public void setIdSymtomGroup(String idSymtomGroup) {
		this.idSymtomGroup = idSymtomGroup;
	}
	
	
}

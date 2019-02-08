package com.controller;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;
import org.modelmapper.ModelMapper;

import com.connect.Connect;
import com.dto.DrugFormulaDto;
import com.dto.SymptomDto;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

@Path("/symptoms")
public class SymptomSearch {
	
	@POST
	@Path("/symptomsearch")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response symptomsearch(SymptomDto symptomDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("drugformula");
		MongoCollection<Document> collection2 = mongo.db.getCollection("symptom");
		ModelMapper Mapper = new ModelMapper();

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("symtomName", symptomDto.getSymtomName());
		
		
		SymptomDto[] value = null;
		SymptomDto values = new SymptomDto();
		DrugFormulaDto[] value2 = null;
		DrugFormulaDto[] value3 = null;
		try {
			FindIterable<Document> data = collection2.find();
			int size = Iterables.size(data);
			value = new SymptomDto[size];
			int k=0;
			for(Document document : data) {
				value[k++]=Mapper.map(document, SymptomDto.class);
			}
			
			
			FindIterable<Document> data2 = collection.find();
			int size2 = Iterables.size(data2);
			value2 = new DrugFormulaDto[size2];
			value3 = new DrugFormulaDto[size];
			int key = 0;
			for (Document document : data2) {
				value2[key++] = Mapper.map(document, DrugFormulaDto.class);
			}
			
//			for(int i=0;i< size;i++) {
//				for(int j=0;j< size2; j++) {
//					if(values.getIdDrugFormula()[i].equals(value2[j].getIdDrugFormula()) ) {
//						value3[i]=Mapper.map(value2[j], DrugFormulaDto.class);
//					}
//				}
//			}
			message.addProperty("message", true);

		}catch (Exception e) {
			message.addProperty("message", false);
		}finally {
			message.add("data", gson.toJsonTree(value3));
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
}

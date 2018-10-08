package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;
import org.modelmapper.ModelMapper;

import com.connect.Connect;
import com.dao.DrugFormulaDao;
import com.dto.DrugFormulaDto;
import com.dto.ScoreDto;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

@Path("/drugformula")
public class DrugFormula {
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(DrugFormulaDto drugformulaDto) {
		
		Connect mongo = new Connect();
		MongoCollection<Document> collection = mongo.db.getCollection("drugformula");
		
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		
		ModelMapper Mapper = new ModelMapper();
		DrugFormulaDao drugformulaDao = Mapper.map(drugformulaDto, DrugFormulaDao.class);
		
		String json = gson.toJson(drugformulaDao);
		Document document = Document.parse(json);
		
		try {
			collection.insertOne(document);
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(DrugFormulaDto drugformulaDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("drugformula");
		ModelMapper Mapper = new ModelMapper();
		DrugFormulaDao drugformulaDao = Mapper.map(drugformulaDto, DrugFormulaDao.class);
		
		String json = gson.toJson(drugformulaDao);
		Document document = Document.parse(json);
		
		BasicDBObject setQuery = new BasicDBObject();
        setQuery.put("$set", document);
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", drugformulaDto.getId());
		
		try {
			collection.updateOne(searchQuery, setQuery);
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(DrugFormulaDto drugformulaDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("drugformula");
		
		try {
			collection.deleteOne(Filters.eq("_id", drugformulaDto.getId())); 
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/search")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response search(DrugFormulaDto drugformulaDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("drugformula");
		ModelMapper Mapper = new ModelMapper();
		
		// find when water = 'value' and seed = 'value'
		BasicDBObject query = new BasicDBObject();
			
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("message", drugformulaDto.getDrugName()));
		obj.add(new BasicDBObject("message", drugformulaDto.getHerb()));
		query.put("$and", obj);
				
		DrugFormulaDto[] value = null;
		
		try {
			FindIterable<Document> data = collection.find(query);
			int size = Iterables.size(data);
			value = new DrugFormulaDto[size];
			int key = 0;
			for (Document document : data) {
				value[key++] = Mapper.map(document, DrugFormulaDto.class);
			}
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}finally {
			message.add("data", gson.toJsonTree(value));
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/findAll")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findAll() {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("drugformula");
		ModelMapper Mapper = new ModelMapper();
		
		DrugFormulaDto[] value = null;
		
		try {
			FindIterable<Document> data = collection.find();
			int size = Iterables.size(data);
			value = new DrugFormulaDto[size];
			int key = 0;
			for (Document document : data) {
				value[key++] = Mapper.map(document, DrugFormulaDto.class);
			}
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}finally {
			message.add("data", gson.toJsonTree(value));
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/findOne")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response findOne(DrugFormulaDto drugformulaDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("drugformula");
		ModelMapper Mapper = new ModelMapper();
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", drugformulaDto.getId());
		
		DrugFormulaDto value = new DrugFormulaDto();
		
		try {
			FindIterable<Document> data = collection.find(searchQuery);
			value = Mapper.map(data.first(), DrugFormulaDto.class);
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}finally {
			message.add("data", gson.toJsonTree(value));
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
}

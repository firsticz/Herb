package com.controller;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import org.modelmapper.ModelMapper;
import com.connect.Connect;
import com.dao.SymptomDao;
import com.dto.DrugFormulaDto;
import com.dto.SymptomDto;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import javax.ws.rs.core.Response;
@Path("/systoms")
public class Symptom {
		@POST
		@Path("/insert")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response insert(SymptomDto symptomDto) {
			
			Connect mongo = new Connect();
			MongoCollection<org.bson.Document> collection = mongo.db.getCollection("symptom");
			
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			
			ModelMapper Mapper = new ModelMapper();
			SymptomDao groupDao = Mapper.map(symptomDto, SymptomDao.class);
			
			String json = gson.toJson(groupDao);
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
		public Response update(SymptomDto symptomDto) {
			Connect mongo = new Connect();
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			MongoCollection<Document> collection = mongo.db.getCollection("symptom");
			ModelMapper Mapper = new ModelMapper();
			SymptomDao updateDao = Mapper.map(symptomDto, SymptomDao.class);
			
			String json = gson.toJson(updateDao);
			Document document = Document.parse(json);
			
			BasicDBObject setQuery = new BasicDBObject();
	        setQuery.put("$set", document);
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", symptomDto.getId());
			
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
		public Response delete(SymptomDto deleteDto) {
			Connect mongo = new Connect();
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			MongoCollection<Document> collection = mongo.db.getCollection("symptom");
			
			try {
				collection.deleteOne(Filters.eq("_id", deleteDto.getId())); 
				message.addProperty("message", true);
			}catch (Exception e) {
				message.addProperty("message", false);
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
			MongoCollection<Document> collection = mongo.db.getCollection("symptom");
			ModelMapper Mapper = new ModelMapper();
			
			SymptomDto[] value = null;
			
			try {
				FindIterable<Document> data = collection.find();
				int size = Iterables.size(data);
				value = new SymptomDto[size];
				int key = 0;
				
				for (Document document : data) {
					value[key++] = Mapper.map(document, SymptomDto.class);
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
		public Response findOne(SymptomDto symptomDto) {
			Connect mongo = new Connect();
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			MongoCollection<Document> collection = mongo.db.getCollection("symptom");
			ModelMapper Mapper = new ModelMapper();
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", symptomDto.getId());
			
			SymptomDto value = new SymptomDto();
			
			try {
				FindIterable<Document> data = collection.find(searchQuery);
				value = Mapper.map(data.first(), SymptomDto.class);
				message.addProperty("message", true);
			}catch (Exception e) {
				message.addProperty("message", false);
			}finally {
				message.add("data", gson.toJsonTree(value));
			}
			
			return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
		}
		
		
		@POST
		@Path("/search")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response search(SymptomDto symptomDto) {
			Connect mongo = new Connect();
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			MongoCollection<Document> collection = mongo.db.getCollection("symptom");
			ModelMapper Mapper = new ModelMapper();
			
			// find when water = 'value' and seed = 'value'
			BasicDBObject query = new BasicDBObject();
//			query.put("SymtomName", symptomDto.getSymtomName());
				
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			obj.add(new BasicDBObject("SymtomName", symptomDto.getSymtomName()));
			obj.add(new BasicDBObject("SymtomName", symptomDto.getSymtomName()));
			
			query.put("$and", obj);
					
			SymptomDto[] value = null;
			
			try {
				FindIterable<Document> data = collection.find(query);
				int size = Iterables.size(data);
				value = new SymptomDto[size];
				int key = 0;
				for (Document document : data) {
					value[key++] = Mapper.map(document, SymptomDto.class);
				}
				message.addProperty("message", true);
			}catch (Exception e) {
				message.addProperty("message", false);
			}finally {
				message.add("data", gson.toJsonTree(value));
			}
			
			return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
		}
	}


package com.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import org.modelmapper.ModelMapper;
import com.connect.Connect;
import com.dao.SymtomDao;
import com.dao.UpdateDao;
import com.dto.RegisterDto;
import com.dto.SymtomDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import javax.ws.rs.core.Response;
@Path("/systoms")
public class Symtoms {
		@POST
		@Path("/insert")
		@Consumes(MediaType.APPLICATION_JSON)
		public Response insert(SymtomDto Symtomdto) {
			
			Connect mongo = new Connect();
			MongoCollection<org.bson.Document> collection = mongo.db.getCollection("systoms");
			
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			
			ModelMapper Mapper = new ModelMapper();
			SymtomDao groupDao = Mapper.map(Symtomdto, SymtomDao.class);
			
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
		public Response update(SymtomDto updateDto) {
			Connect mongo = new Connect();
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			MongoCollection<Document> collection = mongo.db.getCollection("systoms");
			ModelMapper Mapper = new ModelMapper();
			SymtomDao updateDao = Mapper.map(updateDto, SymtomDao.class);
			
			String json = gson.toJson(updateDao);
			Document document = Document.parse(json);
			
			BasicDBObject setQuery = new BasicDBObject();
	        setQuery.put("$set", document);
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", updateDto.getId());
			
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
		public Response delete(SymtomDto deleteDto) {
			Connect mongo = new Connect();
			JsonObject message = new JsonObject();
			Gson gson = new Gson();
			MongoCollection<Document> collection = mongo.db.getCollection("systoms");
			
			try {
				collection.deleteOne(Filters.eq("_id", deleteDto.getId())); 
				message.addProperty("message", true);
			}catch (Exception e) {
				message.addProperty("message", false);
			}
			
			return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
		}
	}


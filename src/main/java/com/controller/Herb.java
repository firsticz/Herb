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
import com.dao.HerbDao;
import com.dto.HerbDto;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

 @Path("/herb")
public class Herb {
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(HerbDto herbdto) {
		
		Connect mongo = new Connect();
		MongoCollection<Document> collection = mongo.db.getCollection("herb");
		
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		
		ModelMapper Mapper = new ModelMapper();
		HerbDao groupDao = Mapper.map(herbdto, HerbDao.class);
		
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
	public Response update(HerbDto updateDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("herb");
		ModelMapper Mapper = new ModelMapper();
		HerbDao updateDao = Mapper.map(updateDto, HerbDao.class);
		
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
	public Response delete(HerbDto deleteDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("herb");
		
		try {
			collection.deleteOne(Filters.eq("_id", deleteDto.getId())); 
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Path("/search")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response search(HerbDto searchDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("solution");
		ModelMapper Mapper = new ModelMapper();
		
		// find when water = 'value' and seed = 'value'
		BasicDBObject query = new BasicDBObject();
			
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		obj.add(new BasicDBObject("water", searchDto.getWarning()));
		obj.add(new BasicDBObject("seed", searchDto.getId()));
		query.put("$and", obj);
				
		HerbDto[] value = null;
		
		try {
			FindIterable<Document> data = collection.find(query);
			int size = Iterables.size(data);
			value = new HerbDto[size];
			int key = 0;
			for (Document document : data) {
				value[key++] = Mapper.map(document, HerbDto.class);
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
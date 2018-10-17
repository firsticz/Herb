package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.modelmapper.ModelMapper;

import com.connect.Connect;
import com.dto.ScoreDto;
import com.google.common.collect.Iterables;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

@Path("/usersocre")
public class UserScore {
	
	@POST
	@Path("/inputscore")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response search(ScoreDto scoreDto) {
		Connect mongo = new Connect();
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		MongoCollection<Document> collection = mongo.db.getCollection("score");
		ModelMapper Mapper = new ModelMapper();
		
		BasicDBObject query = new BasicDBObject();
		List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
		//get value for search
		obj.add(new BasicDBObject("drugformulaId", scoreDto.getDrugformulaId()));
		obj.add(new BasicDBObject("userscore.id", scoreDto.getUserscore()[0].getId()));
		query.put("$and", obj);
				
//		ScoreDto[] value = null;
		
		try {
			FindIterable<Document> data = collection.find(query);
			int size = Iterables.size(data);
			if(size == 0) {
				
				BasicDBObject searchQuery = new BasicDBObject();
				searchQuery.put("drugformulaId", scoreDto.getDrugformulaId());
				
				DBObject listItem = new BasicDBObject("userscore", new BasicDBObject("id",scoreDto.getUserscore()[0].getId()).append("score",scoreDto.getUserscore()[0].getScore()));
				DBObject updateQuery = new BasicDBObject("$push", listItem);

				collection.updateOne(searchQuery, (Bson) updateQuery);
				message.addProperty("res", "vote complete");
			}else {
//				value = new ScoreDto[size];
//				int key = 0;
//				for (Document document : data) {
//					value[key++] = Mapper.map(document, ScoreDto.class);
//				}
				message.addProperty("res", "vote already");
			}
			
			message.addProperty("message", true);
		}catch (Exception e) {
			message.addProperty("message", false);
		}
//		finally {
//			message.add("data", gson.toJsonTree(value));
//		}
		
		return Response.ok(gson.toJson(message), MediaType.APPLICATION_JSON).build();
	}
	
}

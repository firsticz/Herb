package com.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.bson.Document;
import org.modelmapper.ModelMapper;
import com.connect.Connect;
import com.dao.SymtomGroupDao;
import com.dto.SymtomGroupDto;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mongodb.client.MongoCollection;
import javax.ws.rs.core.Response;
@Path("/symtomGroup")
public class SymtomGroup {
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insert(SymtomGroupDto SymtomGroupdto) {
		
		Connect mongo = new Connect();
		MongoCollection<org.bson.Document> collection = mongo.db.getCollection("systomGroup");
		
		JsonObject message = new JsonObject();
		Gson gson = new Gson();
		
		ModelMapper Mapper = new ModelMapper();
		SymtomGroupDao groupDao = Mapper.map(SymtomGroupdto, SymtomGroupDao.class);
		
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
}




package com.connect;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class Connect {
	
	public MongoDatabase db;
	MongoClient mongo;

	public Connect() {
		this.mongo = new MongoClient("localhost", 27017);
		this.db = this.mongo.getDatabase("Mhunprai");
	}
	
	public void close() {
		this.mongo.close();
	}
}


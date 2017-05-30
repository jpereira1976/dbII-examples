package uy.edu.um.mongo_tutorial;


import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class ConnectionMainTest {

	public static void main(String[] args) {
		MongoClient client = new MongoClient(Arrays.asList(
                new ServerAddress("javiplaptop", 27017),
                new ServerAddress("javiplaptop", 27018),
                new ServerAddress("javiplaptop", 27019)));
		DB db = client.getDB("reptest");
		DBCollection collection = db.getCollection("test");
		
		BasicDBObject newTest = new BasicDBObject();
		newTest.put("name", "from java complex");
		BasicDBObject complex = new BasicDBObject();
		complex.put("otherLevel", "yes");
		newTest.put("complex", complex);
		System.out.println(newTest.toJson());
		collection.insert(newTest);
		
		client.close();
		
	}
}

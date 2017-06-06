package uy.edu.um.mongo_tutorial;

import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class ConnectionMainTest {

	public static void main(String[] args) {
		MongoClient client = new MongoClient(Arrays.asList(new ServerAddress("javiplaptop", 27017),
				new ServerAddress("javiplaptop", 27018), new ServerAddress("javiplaptop", 27019)));
		DB db = client.getDB("reptest");
		DBCollection collection = db.getCollection("test");
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 30000; i++) {
			BasicDBObject newTest = new BasicDBObject();
			newTest.append("name", "name " + i).append("complex", new BasicDBObject().append("otherLevel", "yes"));
			// System.out.println(newTest.toJson());
			collection.insert(newTest, WriteConcern.MAJORITY);
			//collection.insert(newTest);
		}
		long endTime = System.currentTimeMillis() - startTime;
		System.out.printf("Excecution time %d millis \n", endTime);

		client.close();

	}
}

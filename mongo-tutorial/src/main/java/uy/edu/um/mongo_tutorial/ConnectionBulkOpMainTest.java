package uy.edu.um.mongo_tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.InsertOneOptions;
import com.mongodb.client.model.WriteModel;

public class ConnectionBulkOpMainTest {

	public static void main(String[] args) {
		MongoClient client = new MongoClient(Arrays.asList(new ServerAddress("javiplaptop", 27017),
				new ServerAddress("javiplaptop", 27018), new ServerAddress("javiplaptop", 27019)));
		MongoDatabase db = client.getDatabase("reptest");
		MongoCollection<Document> collection = db.getCollection("test").withWriteConcern(WriteConcern.MAJORITY);
//		MongoCollection<Document> collection = db.getCollection("test");
		
		long startTime = System.currentTimeMillis();
		List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();

		for (int i = 0; i < 30000; i++) {
			Document document = new Document().append("name", "name " + i)
					.append("complex", new BasicDBObject().append("otherLevel", "yes"));
			collection.insertOne(document);
			writes.add(new InsertOneModel<Document>(
					document));
		}
		
		BulkWriteOptions options = new BulkWriteOptions();
		options.ordered(false);
//		BulkWriteResult bulk = collection.bulkWrite(writes);
		long endTime = System.currentTimeMillis() - startTime;
		System.out.printf("Excecution time %d millis \n", endTime);
		
		client.close();

	}
}

package uy.edu.um.mongo_tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.mongodb.bulk.BulkWriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.BulkWriteOptions;
import com.mongodb.client.model.InsertOneModel;
import com.mongodb.client.model.WriteModel;

public class ShardingBulkOperationTest {
	public static void main(String[] args) {
		MongoClient client = new MongoClient(Arrays.asList(new ServerAddress("javiplaptop", 27017)));
		MongoDatabase db = client.getDatabase("Comercio");
		MongoCollection<Document> collection = db.getCollection("clientes").withWriteConcern(WriteConcern.MAJORITY);
//		MongoCollection<Document> collection = db.getCollection("test");
		
		long startTime = System.currentTimeMillis();
		List<WriteModel<Document>> writes = new ArrayList<WriteModel<Document>>();

		for (int i = 0; i < 2000000; i++) {
			Document document = new Document()
					.append("document",i)
					.append("name", "name " + i)
					.append("surname", "surname "+ i)
					.append("address","address"+i)
					.append("birthdate","birthdate"+i)
					.append("phone","phone"+i);
			writes.add(new InsertOneModel<Document>(
					document));
		}
		
		BulkWriteOptions options = new BulkWriteOptions();
		options.ordered(false);
		BulkWriteResult bulk = collection.bulkWrite(writes);
		long endTime = System.currentTimeMillis() - startTime;
		System.out.printf("Excecution time %d millis \n", endTime);
		
		client.close();

	}
}

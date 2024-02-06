package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;



public class MongoDBConnector {
    private MongoClient mongoClient;
    private MongoDatabase database;

    public MongoDBConnector() {
        // Conectar a la instancia local de MongoDB (por defecto en el puerto 27017)
        this.mongoClient = MongoClients.create();
        this.database = mongoClient.getDatabase("reservesDB");
    }

    public MongoDatabase getDatabase() {
        return database;
    }

}

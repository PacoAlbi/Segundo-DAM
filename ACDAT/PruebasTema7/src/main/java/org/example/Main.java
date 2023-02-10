package org.example;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.print.Doc;
import java.util.logging.Level;
import java.util.logging.Logger;
//Este es el comparador o equals, no lo pilla solo, hay que ponerlo a mano.
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.in;

public class Main {

    static MongoDatabase database;

    public static void main(String[] args) {
        Logger.getLogger("org.mongodb").setLevel(Level.OFF);
        //conexion();
        //miConecct();
        conectar();
        insertar();
    }

    public static void conectar (){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://falbinana:Pacorro1@cluster0.4h7mpgn.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        database = mongoClient.getDatabase("Prueba");
    }

    private static void conexion (){
        String uri = "mongodb://localhost:27017/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Alumnos");
            Document doc = collection.find(eq("nombre", "David")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

    private static void miConecct (){
        ConnectionString connectionString = new ConnectionString("mongodb+srv://falbinana:Pacorro1@cluster0.4h7mpgn.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        //MongoClient mongoClient = MongoClients.create(settings);
        //MongoDatabase database = mongoClient.getDatabase("test");
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Alumnos");
            Document doc = collection.find(eq("nombre", "David")).first();
            if (doc != null) {
                System.out.println(doc.toJson());
            } else {
                System.out.println("No matching documents found.");
            }
        }
    }

    private static void insertar (){

        database.getCollection("Alumnos").insertOne(new Document().append("nombre", "Manu").append("apellidos", "Torpedo"));
    }

    private static void modificar(String antes, String despues){
        Document query = new Document().append("nombre", antes);
        Bson updates = Updates.combine(
                Updates.set("nombre", despues),
                Updates.currentTimestamp("lastUpdated"));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {

        }
        )

    }
}
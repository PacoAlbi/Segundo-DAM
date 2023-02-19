package Conecction;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Date;

import static com.mongodb.client.model.Filters.eq;

public class Conexion {
    //Variable de comunicación con la BBDD
    private static MongoDatabase database;

    /**
     * Precondiciones: No tiene.
     * Conecta con la BBDD de Mongo en LocalHost.
     * Postcondiciones: No tiene.
     */
    private static void conectarLocalHost (){
        String uri = "mongodb://localhost:27017/";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            database = mongoClient.getDatabase("Prueba");
        }
    }
    /**
     * Precondiciones: No tiene.
     * Conecta con la BBDD de Mongo Atlas.
     * Postcondiciones: No tiene.
     */
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
    /**
     * Precondiciones: No tiene.
     * Recorre una de las tablas (Colecciones en Mongo) y devuelve todas sus filas (Documentos en Mongo).
     * Postcondiciones: No tiene.
     */
    public static void getList (){
        MongoCollection<Document> collection = database.getCollection("Alumnos");
        try (MongoCursor<Document> result = collection.find().iterator()) {
            while (result.hasNext()) {
                System.out.println(result.next());
            }
        }
    }
    /**
     * Precondiciones: No tiene.
     * Devuelve e imprime un valor (WHERE) de la colección.
     * Postcondiciones: No tiene.
     */
    public static void getOne (){
        MongoCollection<Document> collection = database.getCollection("Alumnos");
        Document doc = collection.find(eq("nombre", "David")).first();
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No existen documentos que coincidan.");
        }
    }
    /**
     * Precondiciones: No tiene.
     * Inserta un documento en la colección.
     * Postcondiciones: No tiene.
     */
    public static void insertar (){
        //Modo compacto de insertar
        database.getCollection("Alumnos").insertOne(new Document().append("nombre", "Manu").append("apellidos", "Torpedo").append("fecha", new Date(2024, 10, 10)));
    }
    /**
     * Precondiciones: Debe recibir el dato a cambiar y por el que lo queremos cambiar.
     * Recorre la colección y busca los nombres que se correspondan con el dado y los sustituye por el nuevo.
     * Postcondiciones: No tiene.
     * @param antes String dato anterior.
     * @param despues String dato nuevo.
     */
    public static void modificarVarios (String antes, String despues){
        Document query = new Document().append("nombre", antes);
        Bson updates = Updates.combine(
                Updates.set("nombre", despues),
                Updates.currentTimestamp("lastUpdated"));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = database.getCollection("Alumnos").updateMany(query, updates, options);
            System.out.println("Cantidad de documentos modificados: " + result.getModifiedCount());
            System.out.println("Documentos insertados nuevos por no estar con esa id antes: " + result.getUpsertedId());
        } catch (MongoException e) {
            System.out.println("Imposible actualizar. Error: " + e);
        }
    }
    /**
     * Precondiciones: Debe recibir el dato a cambiar y por el que lo queremos cambiar.
     * Recorre la colección y busca los nombres que se correspondan con el dado y sustituye el primero que encuentra por el nuevo.
     * Postcondiciones: No tiene.
     * @param antes String dato anterior.
     * @param despues String dato nuevo.
     */
    public static void modificarUno (String antes, String despues){
        Document query = new Document().append("nombre", antes);
        Bson updates = Updates.combine(
                Updates.set("nombre", despues),
                Updates.currentTimestamp("lastUpdated"));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = database.getCollection("Alumnos").updateOne(query, updates, options);
            System.out.println("Cantidad de documentos modificados: " + result.getModifiedCount());
            System.out.println("Documentos insertados nuevos por no estar con esa id antes: " + result.getUpsertedId());
        } catch (MongoException e) {
            System.out.println("Imposible actualizar. Error: " + e);
        }
    }
    /**
     * Precondiciones: No tiene.
     * Borra un documento de la colección.
     * Postcondiciones: No tiene.
     */
    public static void borrar (){
        try {
            Document doc = new Document("nombre", "Paco");
            MongoCollection<Document> collection = database.getCollection("Alumnos");
            collection.deleteOne(doc);
        } catch (MongoException e) {
            System.out.println("Imposible eliminar. Error: " + e);
        }
    }
    /**
     * Funcion que devuelve el ultimo id de la coleccion que le introduzcamos como parametro.
     * La utilidad de esto es generar un autoincremental para los ids de las tablas.
     * @return
     */
    public static int obtenerUltimoId(String nombreColeccion) {

        MongoCollection<Document> collection = database.getCollection(nombreColeccion);
        String ultimoId = "";
        // Crear un objeto MongoCursor para obtener el último documento ordenado por _id descendente
        MongoCursor<Document> cursor = collection.find().sort(Sorts.descending("_id")).limit(1).iterator();

        // Si hay un documento, obtener el valor del campo _id y almacenarlo en una variable
        if (cursor.hasNext()) {
            Document ultimoDocumento = cursor.next();
            ultimoId = ultimoDocumento.get("_id").toString();
        }

        if(ultimoId.equals("")){
            ultimoId = "0";
        }

        // Cerrar el cursor y la conexión a MongoDB
        cursor.close();

        int ultimoIdInt = Integer.parseInt(ultimoId);

        return ultimoIdInt + 1;
    }
}
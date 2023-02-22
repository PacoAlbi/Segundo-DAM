package Conecction;

import Entidades.*;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.Sorts;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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
        database = mongoClient.getDatabase("Granja_Lechera");
    }
    /**
     * Precondiciones: Debe recibir la colección en String.
     * Recorre una de las tablas (Colecciones en Mongo) y devuelve todas sus filas (Documentos en Mongo).
     * Postcondiciones: No tiene.
     */
    public static void getList (String coleccion){
        conectar();
        MongoCollection<Document> collection = database.getCollection(coleccion);
        try (MongoCursor<Document> result = collection.find().iterator()) {
            while (result.hasNext()) {
                System.out.println(result.next());
            }
        } catch (MongoException e) {
            System.err.println("Colección no encontrada. Error: " + e);
            e.printStackTrace();
        }
    }
    public static List<Ganado> getListGanado (){
        conectar();
        List<Ganado> ganadoList = new ArrayList<>();
        Ganado vaca;
        Document documento;
        MongoCollection<Document> collection = database.getCollection("Ganado");
        try (MongoCursor<Document> result = collection.find().iterator()) {
            while (result.hasNext()) {
                vaca = new Ganado();
                documento = result.next();
                vaca.set_id(documento.getInteger("_id"));
                vaca.setNombre(documento.getString("nombre"));
                vaca.setFechaEntrada(documento.getDate("fechaEntrada"));
                vaca.setFechaSacrificio(documento.getDate("fechaSacrificio"));
                vaca.setIdNave(documento.getInteger("idNave"));
                vaca.setIdMadre(documento.getInteger("idMadre"));
                vaca.setFechaCreacionRegistro(Timestamp.valueOf(documento.getString("creaciónRegistro")));
                ganadoList.add(vaca);
            }
        } catch (MongoException e) {
            System.err.println("Colección no encontrada. Error: " + e);
            e.printStackTrace();
        }
        return ganadoList;
    }
    public static List<Nave> getListNaves (){
        conectar();
        List<Nave> naveList = new ArrayList<>();
        Nave nave;
        Document documento;
        MongoCollection<Document> collection = database.getCollection("Naves");
        try (MongoCursor<Document> result = collection.find().iterator()) {
            while (result.hasNext()) {
                nave = new Nave();
                documento = result.next();
                nave.set_id(documento.getInteger("_id"));
                nave.setGanadero(documento.getString("ganadero"));
                nave.setUbicacion(documento.getString("ubicación"));
                nave.setFechaCreacionRegistro(Timestamp.valueOf(documento.getString("creaciónRegistro")));
                naveList.add(nave);
            }
        } catch (MongoException e) {
            System.err.println("Colección no encontrada. Error: " + e);
            e.printStackTrace();
        }
        return naveList;
    }
    public static List<Produccion> getListProduccion (){
        conectar();
        List<Produccion> produccionList = new ArrayList<>();
        Produccion produccion;
        Document documento;
        MongoCollection<Document> collection = database.getCollection("Produccion");
        try (MongoCursor<Document> result = collection.find().iterator()) {
            while (result.hasNext()) {
                produccion = new Produccion();
                documento = result.next();
                produccion.setIdVaca(documento.getInteger("idVaca"));
                produccion.setMesProduccion(documento.getInteger("mes_producción"));
                produccion.setAnoProduccion(documento.getInteger("year_producción"));
                produccion.setLitros(documento.getInteger("litros"));
                produccion.setFechaCreacionRegistro(Timestamp.valueOf(documento.getString("creaciónRegistro")));
                produccionList.add(produccion);
            }
        } catch (MongoException e) {
            System.err.println("Colección no encontrada. Error: " + e);
            e.printStackTrace();
        }
        return produccionList;
    }
    /**
     * Precondiciones: Debe recibir la colección, el campo y el valor a buscar en String.
     * Devuelve e imprime un valor (WHERE) de la colección.
     * Postcondiciones: No tiene.
     */
    public static void getOne (String coleccion, String campo, String valor){
        conectar();
        MongoCollection<Document> collection = database.getCollection(coleccion);
        Document doc = collection.find(eq(campo, valor)).first();
        if (doc != null) {
            System.out.println(doc.toJson());
        } else {
            System.out.println("No existen documentos que coincidan.");
        }
    }
    /**
     * Precondiciones: Debe recibir un Ganado.
     * Inserta un nuevo documento en la colección.
     * Postcondiciones: Inserta un Ganado en la colección.
     */
    public static void insertarGanado (Ganado vaca) {
        conectar();
        try {
        database.getCollection("Ganado").insertOne(new Document()
                .append("_id", obtenerUltimoId("Ganado"))
                .append("nombre", vaca.getNombre())
                .append("fechaEntrada", vaca.getFechaEntrada())
                .append("fechaSacrificio", vaca.getFechaSacrificio())
                .append("idNave", vaca.getIdNave())
                .append("idMadre", vaca.getIdMadre())
                .append("creaciónRegistro", vaca.getFechaCreacionRegistro().toString()));
        } catch (MongoException e) {
            System.err.println("Imposible insertar la vaca. Error: " + e);
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir una Nave.
     * Inserta un nuevo documento en la colección.
     * Postcondiciones: Inserta una Nave en la colección.
     */
    public static void insertarNave (Nave nave){
        conectar();
        try {
            database.getCollection("Naves").insertOne(new Document()
                    .append("_id", obtenerUltimoId("Naves"))
                    .append("ganadero", nave.getGanadero())
                    .append("ubicación", nave.getUbicacion())
                    .append("creaciónRegistro", nave.getFechaCreacionRegistro().toString()));
        } catch (MongoException e) {
            System.err.println("Imposible insertar la nave. Error: " + e);
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir una Producción.
     * Inserta un nuevo documento en la colección.
     * Postcondiciones: Inserta una Producción en la colección.
     */
    public static void insertarProduccion (Produccion produccion){
        conectar();
        try {
            database.getCollection("Produccion").insertOne(new Document()
                    .append("idVaca", produccion.getIdVaca())
                    .append("mes_producción", produccion.getMesProduccion())
                    .append("litros", produccion.getLitros())
                    .append("year_producción", produccion.getAnoProduccion())
                    .append("creaciónRegistro", produccion.getFechaCreacionRegistro().toString()));
        } catch (MongoException e) {
            System.err.println("Imposible insertar la producción. Error: " + e);
            e.printStackTrace();
        }
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
            System.err.println("Imposible actualizar. Error: " + e);
            e.printStackTrace();
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
            System.err.println("Imposible actualizar el documento. Error: " + e);
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir la colección, el campo y el valor a buscar en String.
     * Borra un documento de la colección.
     * Postcondiciones: No tiene.
     */
    public static void borrarDocumento (String coleccion, String campo, int valor){
        conectar();
        try {
            Document documento = new Document(campo,valor);
            MongoCollection<Document> collection = database.getCollection(coleccion);
            DeleteResult resultado = collection.deleteOne(documento);
            if (resultado.getDeletedCount() > 0)
                System.out.println("Documento eliminado correctamente. Total eliminados: " + resultado.getDeletedCount());
            else
                System.out.println("No se ha encontrado el documento.");
        } catch (MongoException e) {
            System.err.println("Imposible eliminar el documento. Error: " + e);
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir la colección en String.
     * Función que devuelve el último id de la colección que le introduzcamos como parámetro.
     * La utilidad de esto es generar un autoincremental para los ids de las tablas.
     * Postcondiciones: Devuelve un int con el último id de la colección.
     * @return int con el último id de la colección.
     */
    public static int obtenerUltimoId(String coleccion) {
        MongoCollection<Document> collection = database.getCollection(coleccion);
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

    public static void asignarNave(int idVaca,int idNave){
        conectar();
        MongoCollection<Document> vacas = database.getCollection("Ganado");
        MongoCollection<Document> naves = database.getCollection("Naves");
        Document vacaDoc = new Document("_id",idVaca);
        Document naveDoc = new Document("_id",idNave);
        Document asignado = new Document("idNave", naves.find(naveDoc).first().getInteger("_id"));
        Document update = new Document("$set",asignado );
        vacas.findOneAndUpdate(vacaDoc, update);
        System.out.println("Nave asignada correctamente.");
    }
}
package Conecction;

import Entidades.*;
import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.client.model.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class Conexion {
    //Variable de comunicación con la BBDD
    private static MongoDatabase database;
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
     * Precondiciones: Debe recibir la colección, el campo y el valor a buscar en String.
     * Devuelve e imprime un valor (WHERE) de la colección.
     * Postcondiciones: No tiene.
     */
    public static void getOne (String coleccion, String campo, int valor){
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
     * Precondiciones: No tiene.
     * Recorre la colección de Ganado y devuelve una lista de objetos Ganado.
     * Postcondiciones: Una lista de objetos Ganado.
     * @return Devuelve un List con el resultado de la búsqueda.
     */
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
                vaca.setFechaCreacionRegistro(Timestamp.valueOf(documento.getString("actualizaciónRegistro")));
                ganadoList.add(vaca);
            }
        } catch (MongoException e) {
            System.err.println("Colección no encontrada. Error: " + e);
            e.printStackTrace();
        }
        return ganadoList;
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
                    .append("actualizaciónRegistro", vaca.getFechaCreacionRegistro().toString()));
        } catch (MongoException e) {
            System.err.println("Imposible insertar la vaca. Error: " + e);
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir el id de la vaca y el nuevo nombre.
     * Recorre la colección de Ganado y modifica el nombre de la vaca.
     * Postcondiciones: No tiene.
     * @param idVaca int id de la vaca
     * @param valor String valor a modificar
     */
    public static void modificarNombreVaca (int idVaca, String valor){
        conectar();
        Document query = new Document().append("_id", idVaca);
        Bson updates = Updates.combine(
                Updates.set("nombre", valor),
                Updates.set("actualizaciónRegistro",Timestamp.from(Instant.now()).toString()));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = database.getCollection("Ganado").updateOne(query, updates, options);
            System.out.println("Nombre modificado con éxito: " + result.getModifiedCount());
            System.out.println("Documentos insertados nuevos por no estar con esa id antes: " + result.getUpsertedId());
        } catch (MongoException e) {
            System.err.println("Imposible actualizar el documento. Error: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe recibir el id de la vaca y el id de la nueva nave.
     * Recorre la colección de Ganado y modifica la nave de la vaca.
     * Postcondiciones: No tiene.
     * @param idVaca int id de la vaca
     * @param valor int id de la nave
     */
    public static void modificarNaveVaca (int idVaca, int valor){
        conectar();
        Document query = new Document().append("_id", idVaca);
        Bson updates = Updates.combine(
                Updates.set("idNave", valor),
                Updates.set("actualizaciónRegistro",Timestamp.from(Instant.now()).toString()));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = database.getCollection("Ganado").updateOne(query, updates, options);
            System.out.println("Nave modificada con éxito: " + result.getModifiedCount());
            System.out.println("Documentos insertados nuevos por no estar con esa id antes: " + result.getUpsertedId());
        } catch (MongoException e) {
            System.err.println("Imposible actualizar el documento. Error: " + e);
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe recibir el id de la vaca y la fecha de sacrificio.
     * Recorre la colección de Ganado e inserta la fecha de sacrificio.
     * Postcondiciones: No tiene.
     * @param idVaca int id de la vaca
     * @param valor String fecha de sacrificio
     */
    public static void modificarSacrificioVaca (int idVaca, String valor){
        conectar();
        Document query = new Document().append("_id", idVaca);
        Bson updates = Updates.combine(
                Updates.set("fechaSacrificio", Date.valueOf(valor)),
                Updates.set("actualizaciónRegistro",Timestamp.from(Instant.now()).toString()));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = database.getCollection("Ganado").updateOne(query, updates, options);
            System.out.println("Fecha introducida con éxito: " + result.getModifiedCount());
            System.out.println("Documentos insertados nuevos por no estar con esa id antes: " + result.getUpsertedId());
        } catch (MongoException e) {
            System.err.println("Imposible actualizar el documento. Error: " + e);
            e.printStackTrace();
        }
    }

    //------------------------------------NAVES------------------------------------

    /**
     * Precondiciones: No tiene.
     * Recorre la colección de Naves y devuelve una lista con todas las naves.
     * Postcondiciones: Devuelve una lista con todas las naves.
     * @return List<Nave> lista de naves
     */
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
                nave.setFechaCreacionRegistro(Timestamp.valueOf(documento.getString("actualizaciónRegistro")));
                naveList.add(nave);
            }
        } catch (MongoException e) {
            System.err.println("Colección no encontrada. Error: " + e);
            e.printStackTrace();
        }
        return naveList;
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
                    .append("actualizaciónRegistro", nave.getFechaCreacionRegistro().toString()));
        } catch (MongoException e) {
            System.err.println("Imposible insertar la nave. Error: " + e);
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir el id de la nave y el nuevo propietario.
     * Recorre la colección, busca la nave y le cambia el propietario.
     * Postcondiciones: No tiene.
     * @param idNave int id de la nave.
     * @param nombre String nuevo propietario.
     */
    public static void modificarPropietario (int idNave, String nombre){
        conectar();
        Document query = new Document().append("_id", idNave);
        Bson updates = Updates.combine(
                Updates.set("ganadero", nombre),
                Updates.set("actualizaciónRegistro",Timestamp.from(Instant.now()).toString()));
        UpdateOptions options = new UpdateOptions().upsert(true);
        try {
            UpdateResult result = database.getCollection("Naves").updateOne(query, updates, options);
            System.out.println("Nuevo propietario añadido con éxito: " + result.getModifiedCount());
            System.out.println("Documentos insertados nuevos por no estar con esa id antes: " + result.getUpsertedId());
        } catch (MongoException e) {
            System.err.println("Imposible actualizar el documento. Error: " + e);
            e.printStackTrace();
        }
    }

    //------------------------------------PRODUCCION------------------------------------

    /**
     * Precondiciones: No tiene.
     * Recorre la colección de Produccion y devuelve una lista con todas las producciones.
     * Postcondiciones: Devuelve una lista de todas las producciones.
     * @return List<Produccion> lista de producciones
     */
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
                produccion.setFechaCreacionRegistro(Timestamp.valueOf(documento.getString("actualizaciónRegistro")));
                produccionList.add(produccion);
            }
        } catch (MongoException e) {
            System.err.println("Colección no encontrada. Error: " + e);
            e.printStackTrace();
        }
        return produccionList;
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
                    .append("actualizaciónRegistro", produccion.getFechaCreacionRegistro().toString()));
        } catch (MongoException e) {
            System.err.println("Imposible insertar la producción. Error: " + e);
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir el id de la vaca.
     * Recorre la colección, busca la vaca y devuelve la producción de esa vaca.
     * Postcondiciones: No tiene.
     * @param idVaca int id de la vaca.
     */
    public static void getProduccionPorVaca(int idVaca) {
        conectar();
        MongoCollection<Document> produccion = database.getCollection("Produccion");
        produccion.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("idVaca", idVaca)),
                Aggregates.group("$idVaca", Accumulators.sum("Litros totales producidos", "$litros"))
        )).forEach( document -> System.out.println(document.toJson()));
    }
    /**
     * Precondiciones: Debe recibir el mes.
     * Recorre la colección, busca el mes y devuelve la producción de ese mes.
     * Postcondiciones: No tiene.
     * @param mes int mes.
     */
    public static void getProduccionPorMes(int mes) {
        conectar();
        MongoCollection<Document> produccion = database.getCollection("Produccion");
        produccion.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("mes_producción", mes)),
                Aggregates.group("$mes_producción", Accumulators.sum("Litros totales producidos en ese mes", "$litros"))
        )).forEach( document -> System.out.println(document.toJson()));
    }
    /**
     * Precondiciones: Debe recibir el año.
     * Recorre la colección, busca el año y devuelve la producción de ese año.
     * Postcondiciones: No tiene.
     * @param anio int año.
     */
    public static void getProduccionPorAno(int anio) {
        conectar();
        MongoCollection<Document> produccion = database.getCollection("Produccion");
        produccion.aggregate(Arrays.asList(
                Aggregates.match(Filters.eq("year_producción", anio)),
                Aggregates.group("$year_producción", Accumulators.sum("Litros totales producidos en ese año", "$litros"))
        )).forEach( document -> System.out.println(document.toJson()));
    }

    //---------------------------FUNCIONES AUXILIARES---------------------------

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
     * Precondiciones: Debe recibir la colección.
     * Función que devuelve el último id de la colección para poder insertar un nuevo documento con un id autoincremental.
     * Postcondiciones: Devuelve el último id de la colección.
     * @return int con el último id de la colección.
     */
    public static int obtenerUltimoId(String coleccion) {
        MongoCollection<Document> collection = database.getCollection(coleccion);
        String ultimoId = "";
        MongoCursor<Document> cursor = collection.find().sort(Sorts.descending("_id")).limit(1).iterator();
        if (cursor.hasNext()) {
            Document ultimoDocumento = cursor.next();
            ultimoId = ultimoDocumento.get("_id").toString();
        }
        if(ultimoId.equals("")){
            ultimoId = "0";
        }
        cursor.close();
        int ultimoIdInt = Integer.parseInt(ultimoId);
        return ultimoIdInt + 1;
    }
}
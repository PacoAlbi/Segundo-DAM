package Ejercicio1;

import java.io.*;
import java.sql.*;

public class Main {

    private static final String USER = "falbinana";
    private static final String PASS = "87654321";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection con;
    private static Statement st = null;
    private static PreparedStatement prst = null;

    public static void main(String[] args) {
        conectarBBDD();
        insertarMisTablas();


        desconectarBBDD();
    }

    /**
     * Precondiciones: Debemos tener conexión a internet(o intranet).
     * Método para conectar a la BBDD, y en caso de error, lanza un mensaje.
     * Postcondiciones: El programa está conectado a la BBDD.
     */
    public static void conectarBBDD() {
        try {
            con = DriverManager.getConnection(CONEXIONURL, USER, PASS);
            if (con != null) {
                System.out.println("Conexión a base de datos correcta.");
                System.out.println(con.toString());
            }
        } catch (SQLException e) {
            System.out.println("Error conectando a SQL: " + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: No tiene.
     * Método para desconectar de la BBDD, y en caso de error, lanza un mensaje.
     * Postcondiciones: El programa está desconectado de la BBDD.
     */
    public static void desconectarBBDD() {
        try {
            if (con != null) {
                con.close();
            }
            if (st != null) {
                st.close();
            }
            if (prst != null) {
                prst.close();
            }
            System.out.println("Desconexión de base de datos correcta.");
            System.out.println(con.toString());
        } catch (SQLException e) {
            System.out.println("Error desconectando de SQL: " + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para crear todas las tablas de nuestra BBDD del ejercicio.
     * Postcondiciones: Las tablas se genera en la base de datos.
     */
    public static void crearTablas() {
        String tablaUsuarios = "Usuarios";
        String[] camposUsuarios = {"id int PRIMARY KEY AUTO_INCREMENT,", "nombre varchar(45),", "apellidos varchar(45),", "username varchar(12),", "email varchar(50),", "password varchar(128)"};
        crearTabla(tablaUsuarios,camposUsuarios);
        System.out.println("Campos para la tabla Usuarios creados correctamente.");
        String tablaPosts = "Posts";
        String[] camposPosts = {"idPosts int PRIMARY KEY AUTO_INCREMENT,", "idUsuarios int,", "created_at_date date,", "updated_at_date date,", "FOREIGN KEY (idUsuarios) REFERENCES Usuarios (id)"};
        crearTabla(tablaPosts,camposPosts);
        System.out.println("Campos para la tabla Posts creados correctamente.");
        String tablaLikes = "Likes";
        String[] camposLikes = {"idLikes int PRIMARY KEY AUTO_INCREMENT,", "idUsuarios int,", "idPosts int,", "FOREIGN KEY (idUsuarios) REFERENCES Usuarios (id),", "FOREIGN KEY (idPosts) REFERENCES Posts (idPosts)"};
        crearTabla(tablaLikes,camposLikes);
        System.out.println("Campos para la tabla Likes creados correctamente.");
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para crear una tabla en una base de datos SQL.
     * @param tabla String de entrada con el nombre de la tabla.
     * @param nombresCampos String de entrada con los nombres de los campos.
     * Postcondiciones: La tabla se genera en la base de datos.
     */
    public static void crearTabla(String tabla, String[] nombresCampos) {
        String create = "CREATE TABLE ad2223_falbinana." + tabla + " (";
        for (int i = 0; i < nombresCampos.length; i++) {
            create += nombresCampos[i];
        }
        create += ")";
        System.out.println(create);
        try {
            st = con.createStatement();
            st.executeUpdate(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarMisTablas (){
        File fichero = new File("src/ResourceSQL/Usuarios.sql");
        insertarDatos(fichero);
        System.out.println("Datos introducidos en Usuarios correctamente.");
        fichero = new File("src/ResourceSQL/Posts.sql");
        insertarDatos(fichero);
        System.out.println("Datos introducidos en Posts correctamente.");
        fichero = new File("src/ResourceSQL/Likes.sql");
        insertarDatos(fichero);
        System.out.println("Datos introducidos en Likes correctamente.");
    }
    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para insertar datos en la BBDD con un solo INSERT
     * Postcondiciones: La tabla se llena con todos los datos aportados.
     */
    public static void insertarDatos (File archivo){
        String linea;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            st = con.createStatement();
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            linea = br.readLine();
            while (linea!=null){
                st.executeUpdate(linea);
                linea = br.readLine();
            }
            fr.close();
            br.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try{
                if (fr!=null){
                    fr.close();
                }
                if (br!=null){
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para hacer una query a una BBDD SQL que solo necesita recibirla en un String y lo imprime por pantalla.
     * @param sqlSentence Un String de entrada con la query de búsqueda escrita en sql.
     * Postcondiciones: Devuelve los datos de la Query, y los muestra por pantalla normal.
     */
    public static void querySQL(String sqlSentence) {
        ResultSet lista;

        try {
            lista = st.executeQuery(sqlSentence);
            ResultSetMetaData rsmd = lista.getMetaData();
            while (lista.next()) {
                System.out.println(rsmd.getColumnName(1) + ": " + lista.getString(1) + ", " + rsmd.getColumnName(2) + ": " + lista.getString(2));
                //System.out.println(rsmd.getColumnName(1) + ": " + lista.getString(1));
            }
            lista.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
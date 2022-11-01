package Ejercicio1;

import java.io.*;
import java.sql.*;

public class Metodos {

    private static final String USER = "falbinana";
    private static final String PASS = "87654321";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection con;
    private static Statement st = null;
    private static PreparedStatement prst = null;

    public static void main(String[] args) {
        conectarBBDD();
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
            System.out.println("Error conectando a SQL." + System.lineSeparator() + e.getMessage());
            e.printStackTrace(); //Lo pongo aquí porque quiero ver si hay diferencia entre este y el de arriba.
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
            System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para crear todas las tablas de nuestra BBDD del ejercicio.
     * Postcondiciones: Las tablas se genera en la base de datos.
     */
    public static void crearTablas() {
        String tablaUsuarios = "Usuarios";
        String[] camposUsuarios = {"id int PRIMARY KEY AUTO_INCREMENT,", "nombre varchar(45),", "apellidos varchar(45),", "username varchar(20),", "email varchar(50),", "password varchar(128)"};
        crearTabla(tablaUsuarios,camposUsuarios);
        String tablaPosts = "Posts";
        String[] camposPosts = {"idPosts int PRIMARY KEY AUTO_INCREMENT,", "idUsuarios int,", "created_at date,", "updated_at date,", "FOREIGN KEY (idUsuarios) REFERENCES Usuarios (id)"};
        crearTabla(tablaPosts,camposPosts);
        String tablaLikes = "Likes";
        String[] camposLikes = {"idLikes int PRIMARY KEY AUTO_INCREMENT,", "idUsuarios int,", "idPosts int,", "FOREIGN KEY (idUsuarios) REFERENCES Usuarios (id),", "FOREIGN KEY (idPosts) REFERENCES Posts (idPosts)"};
        crearTabla(tablaLikes,camposLikes);
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
        System.out.println("Campos para la tabla " + tabla + " creados correctamente.");
        try {
            st = con.createStatement();
            st.executeUpdate(create);
        } catch (SQLException e) {
            System.out.println("Error creando la tabla." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione y estar creadas las tablas.
     * Método para insertar mis datos en las tablas ya generadas.
     * Postcondiciones: La tabla se llena con todos los datos aportados para mis tablas.
     */
    public static void insertarMisTablas (){
        File fichero = new File("src/ResourceSQL/Usuarios.sql");
        insertarDatos(fichero);
        fichero = new File("src/ResourceSQL/Posts.sql");
        insertarDatos(fichero);
        fichero = new File("src/ResourceSQL/Likes.sql");
        insertarDatos(fichero);
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione y estar creadas las tablas.
     * Método para insertar datos en la BBDD.
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
            System.out.println("Datos introducidos en la tabla " + archivo.getName().replace(".sql", "") + " correctamente.");
        } catch (SQLException e) {
            System.out.println("Error insertando los datos." + System.lineSeparator() + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo." + System.lineSeparator() + e.getMessage());
        } finally {
            try{
                if (fr!=null){
                    fr.close();
                }
                if (br!=null){
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error cerrando los canales." + System.lineSeparator() + e.getMessage());
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
        ResultSet lista = null;
        try {
            prst = con.prepareStatement(sqlSentence);
            lista = prst.executeQuery();
            ResultSetMetaData rsmd = lista.getMetaData();
            while (lista.next()) {
                System.out.println(rsmd.getColumnName(1) + ": " + lista.getString(1) + ", " + rsmd.getColumnName(2) + ": " + lista.getString(2));
                //System.out.println(rsmd.getColumnName(1) + ": " + lista.getString(1));
            }
            lista.close();
        } catch (SQLException e) {
            System.out.println("Error haciendo la consulta." + System.lineSeparator() + e.getMessage());
        } finally {
            try {
                assert lista != null;
                lista.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando el ResultSet" + System.lineSeparator() + e.getMessage());
            }
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Recibe la sentencia SQL de modificación ya preparada por parametro y la ejecuta.
     * @param sqlSentence String con la sentencia SQL para hacer la modificación en la BBDD.
     * Postcondiciones: Modifica la BBDD.
     */
    public static void modificarGenerico (String sqlSentence){
        try {
            st = con.createStatement();
            st.executeUpdate(sqlSentence);
        } catch (SQLException e) {
            System.out.println("Error modificando la BBDD." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Borro todas las tablas de mi BBDD en el orden en el que no dan problemas.
     * Postcondiciones: "Borra" la BBDD.
     */
    public static void borrarMiBBDD (){
        borrarTabla("Likes");
        borrarTabla("Posts");
        borrarTabla("Usuarios");
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Borra una tabla de la BBDD pasándole el nombre como parámetro.
     * @param nombre String con el nombre de la tabla a borrar.
     * Postcondiciones: La columna de la BBDD queda borrada.
     */
    public static void borrarTabla (String nombre){
        String sql = "DROP TABLE ad2223_falbinana." + nombre;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Tabla " + nombre + " borrada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error borrando la tabla " + nombre + "." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Vacía una tabla de la BBDD pasándole el nombre como parámetro.
     * @param nombre String con el nombre de la tabla a vaciar.
     * Postcondiciones: La columna de la BBDD queda limpia.
     */
    public static void vaciarTabla (String nombre){
        String sql = "TRUNCATE TABLE ad2223_falbinana." + nombre;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Tabla " + nombre + " vaciada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error vaciando la tabla " + nombre + "." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Modifica el nombre de una tabla de la BBDD recibiendo el nombre actual y el nuevo por parámetro.
     * @param antiguo String con el nombre actual de la tabla.
     * @param nuevo String con el nuevo nombre de la tabla.
     * Postcondiciones: La tabla queda renombrada.
     */
    public static void renombrarTabla (String antiguo, String nuevo){
        String sql = "RENAME TABLE ad2223_falbinana." + antiguo + " TO ad2223_falbinana." + nuevo;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Tabla " + antiguo + " renombrada correctamente a " + nuevo + ".");
        } catch (SQLException e) {
            System.out.println("Error renombrando la tabla " + antiguo + "." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Inserta una nueva columna al final de la tabla pasándole la tabla, el nombre y el tipo de datos por parámetro.
     * @param nombreTabla String con el nombre de la tabla.
     * @param nombreColumna String con el nombre de la columna.
     * @param tipoDato String con el tipo de dato.
     * Postcondiciones: La columna queda añadida.
     */
    public static void anadirColumna (String nombreTabla, String nombreColumna, String tipoDato){
        String sql = "ALTER TABLE ad2223_falbinana." + nombreTabla + " ADD COLUMN " + nombreColumna + " " + tipoDato;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Columna añadida correctamente.");
        } catch (SQLException e) {
            System.out.println("Error añadiendo la columna." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Inserta una nueva columna al final de la tabla pasándole la tabla, el nombre, el tipo de datos y la columna para posicionar por parámetro.
     * @param nombreTabla String con el nombre de la tabla.
     * @param nombreColumna String con el nombre de la columna.
     * @param tipoDato String con el tipo de dato.
     * @param posicion String con el nombre de la columna que va detrás.
     * Postcondiciones: La columna queda añadida en su posición.
     */
    public static void anadirColumnaPosicionada (String nombreTabla, String nombreColumna, String tipoDato, String posicion){
        String sql = "ALTER TABLE ad2223_falbinana." + nombreTabla + " ADD COLUMN " + nombreColumna + " " + tipoDato + " AFTER " + posicion;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Columna añadida correctamente.");
        } catch (SQLException e) {
            System.out.println("Error añadiendo la columna." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Modifica el tipo de dato de la tabla y la columna pasadas por parámetro.
     * @param nombreTabla String con el nombre de la tabla.
     * @param nombreColumna String con el nombre de la columna.
     * @param tipoDato String con el tipo de dato.
     * Postcondiciones: El nombre y el tipo de dato quedan modificados.
     */
    public static void modificarColumna (String nombreTabla, String nombreColumna, String tipoDato){
        String sql = "ALTER TABLE ad2223_falbinana." + nombreTabla + " MODIFY COLUMN " + nombreColumna + " " + tipoDato;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Columna modificada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error modificando la columna." + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Borra la columna de la tabla pasadas por parámetro.
     * @param nombreTabla String con el nombre de la tabla.
     * @param nombreColumna String con el nombre de la columna.
     * Postcondiciones: La columna queda borrada.
     */
    public static void borrarColumna (String nombreTabla, String nombreColumna){
        String sql = "ALTER TABLE ad2223_falbinana." + nombreTabla + " DROP COLUMN " + nombreColumna;
        try {
            st = con.createStatement();
            st.executeUpdate(sql);
            System.out.println("Columna borrada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error borrando la columna." + System.lineSeparator() + e.getMessage());
        }
    }
}
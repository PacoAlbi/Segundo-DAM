package Ejercicio1;

import java.sql.*;

public class Main {

    private static final String USER = "falbinana";
    private static final String PASS = "Paquete6";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection con;
    private static Statement st = null;
    private static PreparedStatement prst = null;

    public static void main(String[] args) {
        conectarBBDD();


    }

    public static void conectarBBDD() {
        try {
            con = DriverManager.getConnection(CONEXIONURL, USER, PASS);
            if (con != null) {
            }
        } catch (SQLException e) {
            System.out.println("Error conectando a SQL: " + System.lineSeparator() + e.getMessage());
        }
    }

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
        } catch (SQLException e) {
            System.out.println("Error desconectando de SQL: " + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para crear una tabla en una base de datos SQL.
     * Postcondiciones: La tabla se genera en la base de datos.
     */

    public static void crearTablas() {
        String tabla = "usuarios";
        String[] campos = {"id int PRIMARY KEY AUTO_INCREMENT,", "nombre varchar(255),", "apellidos varchar(255),", "email varchar(255),", "username varchar(255),", "password varchar(255)"};
        String create = "CREATE TABLE ad2223_falbinana." + tabla + " (";


        for (int i = 0; i < campos.length; i++) {
            create += campos[i];
        }
        create += ")";

        System.out.println(create);
        try {
            st = con.prepareStatement(create);
            st.executeUpdate(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para crear una tabla en una base de datos SQL.
     *
     * @param tabla         String de entrada con el nombre de la tabla.
     * @param nombresCampos String de entrada con los nombres de los campos.
     *                      Postcondiciones: La tabla se genera en la base de datos.
     */
    public static void crearTabla(String tabla, String[] nombresCampos) {

        String create = "CREATE TABLE ad2223_falbinana." + tabla + " (";


        for (int i = 0; i < nombresCampos.length; i++) {
            create += nombresCampos[i];
        }
        create += ")";

        System.out.println(create);
        try {
            st = con.prepareStatement(create);
            st.executeUpdate(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para insertar datos en la BBDD con un solo INSERT
     * Postcondiciones: La tabla se llena con todos los datos aportados.
     */
    /*public static void insertarDatos (){
        //String datos = "insert into ad2223.falbinana (nombre, apellidos, edad) values ;

        try {
            st = con.prepareStatement(datos);
            st.executeUpdate(datos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Precondiciones: Debe haber conexión con el gestor de BBDD para que funcione.
     * Método para hacer una query a una BBDD SQL que solo necesita recibirla en un String y lo imprime por pantalla.
     *
     * @param sqlSentence Un String de entrada con la query de búsqueda escrita en sql.
     *                    Postcondiciones: Devuelve los datos de la Query, y los muestra por pantalla normal.
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
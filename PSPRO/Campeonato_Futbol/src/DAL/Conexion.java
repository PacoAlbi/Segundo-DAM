package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String USER = "ad2223_falbinana";
    private static final String PASS = "87654321";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es/ad2223_falbinana";
    private static Connection con;

    /**
     * Precondiciones: Debemos tener conexión a internet(o intranet).
     * Método para conectar a la BBDD, y en caso de error, lanza un mensaje.
     * Postcondiciones: El programa está conectado a la BBDD.
     */
    public static Connection conectar(){
        try {
            con = DriverManager.getConnection(CONEXIONURL, USER, PASS);
            if (con != null) {
                System.out.println("\033[31;1mConexión a base de datos correcta.\033[0m");
                System.out.println(con);
            }
        } catch (SQLException e) {
            System.out.println("\033[31;1;4mError conectando a la BBDD." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
        return con;
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
            System.out.println("\033[92;1mDesconexión de base de datos correcta.\033[0m");
            System.out.println(con.toString());
        } catch (SQLException e) {
            System.out.println("\033[31;1;4mError desconectando de la BBDD." + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }
}
import java.sql.*;

public class Conexion {

    private static final String USER = "dberal";
    private static final String PASS = "nervion";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es/ad2223_neptuno";

    private static Connection con;
    /**
     * Precondiciones: Debemos tener conexión a internet(o intranet).
     * Método para conectar a la BBDD, y en caso de error, lanza un mensaje.
     * Postcondiciones: El programa está conectado a la BBDD.
     */
    public static Connection conectarBBDD() {
        try {
            con = DriverManager.getConnection(CONEXIONURL, USER, PASS);
            if (con != null) {
                System.out.println("Conexión a base de datos correcta.");
                //System.out.println(con.toString());
            }
        } catch (SQLException e) {
            System.out.println("Error conectando a SQL." + System.lineSeparator() + e.getMessage());
            e.printStackTrace();
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
            System.out.println("Desconexión de base de datos correcta.");
            System.out.println(con.toString());
        } catch (SQLException e) {
            System.out.println("Error desconectando de SQL." + System.lineSeparator() + e.getMessage());
        }
    }
}

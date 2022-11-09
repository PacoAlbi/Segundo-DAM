package Ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String USER = "falbinana";
    private static final String PASS = "87654321";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es";

    public static Connection conectar(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(CONEXIONURL, USER, PASS);
            if (con != null) {
                System.out.println("Conexión a base de datos correcta.");
                System.out.println(con);
            }
        } catch (SQLException e) {
            System.out.println("Error conectando a SQL." + System.lineSeparator() + e.getMessage());
            e.printStackTrace(); //Lo pongo aquí porque quiero ver si hay diferencia entre este mensaje y el de arriba.
        }
        return con;
    }
}

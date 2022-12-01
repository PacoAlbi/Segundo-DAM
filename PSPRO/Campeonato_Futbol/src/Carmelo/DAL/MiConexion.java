package Carmelo.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {
    public static String BBDD = "jdbc:mysql://dns11036.phdns11.es/ad2223_caguilar";
    public static String USER = "ad2223_caguilar";
    public static String PASS = "Patatitasexy69";
    private String name;
    private String password;
    private String user;


    public MiConexion(String name, String password, String user) {
        this.name = name;
        this.password = password;
        this.user = user;
    }

    public MiConexion(){
        this.name = BBDD;
        this.user = USER;
        this.password = PASS;
    }

    /**
     * Método que funciona como opener de conexiones de bases de datos
     * <p>
     * Se encarga de recoger la cadena de conexion y convertirla en un
     * objeto Connection
     *
     * @return una conexion abierta a la base de datos
     */
    public Connection abrirConexion(){
        Connection conexion = null;

        try{
            //Referencia al driver jdbc de mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Instanciamos la cadena de conexión
            conexion = DriverManager.getConnection(name, user, password);
        }
       catch (SQLException e) {
            System.out.printf("No se pudo acceder a la base de datos %n %s", e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.printf("El Nombre o la contraseña no son correctas para esta base de datos %n %s", ex.getMessage());
        }



        return conexion;
    }


    /**
     * Método que se encarga de cerrar la conexion de la clase
     */
    public void cerrarConexion(Connection cnn) {
        try {

            if (!cnn.isClosed()) {
                cnn.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}

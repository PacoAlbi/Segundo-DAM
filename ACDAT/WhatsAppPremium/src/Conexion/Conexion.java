package Conexion;

import java.sql.*;

public class Conexion {

    private static final String USER = "ad2223_falbinana";
    private static final String PASS = "87654321";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es/";
    private static Connection con;

    /**
     * <b>METODO PARA CONECTARSE A LA BASE DE DATOS PROPIA PARA HACER LAS GESTIONES DE TU CHAT</b> <br> <br>
     * Precondiciones: debes tener creada tu BBDD <br>
     * Postcondiciones: nos conectamos a nuestra BBDD
     * @return
     */
    public static Connection conectarse (){
        try {
            con = DriverManager.getConnection(CONEXIONURL, USER, PASS);
            if (con != null) {
                //System.out.println("\033[31;1mConexión a base de datos correcta.\033[0m" + System.lineSeparator());
            }
        } catch (SQLException e) {
            System.out.println("\033[31;1;4mError conectando a la BBDD de " + "falbinana" + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
        return con;
    }

    /**
     *<b>METODO PARA CONECTARSE A LA BASE DE DATOS DE UN USUARIO INTRODUCIENDO SU NOMBRE Y CONTRASEÑA POR PARAMETROS</b> <br> <br>
     * Precondiciones: el usuario debe existir y tener una base de datos <br>
     * Postcondiciones: nos conectamos a la BBDD del usuario
     * @param usuario
     * @param password
     */
    public static Connection conectarseUsuario (String usuario, String password){
        try {
            con = DriverManager.getConnection(CONEXIONURL, usuario, password);
            if (con != null) {
                System.out.println("\033[31;1mConexión a base de datos correcta.\033[0m" + System.lineSeparator());
            }
        } catch (SQLException e) {
            System.out.println("\033[31;1;4mError conectando a la BBDD de " + usuario + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
        return con;
    }

    /**
     * <b>METODO PARA DESCONECTARSE DE UNA BASE DE DATOS</b> <br><br>
     * Precondciones: debes estar conectado a una base de datos <br>
     * Postcondiciones: te desconectas de la base de datos
     */
    public static void desconectar(){
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            System.out.println("\033[31;1;4mError conectando de la BBDD "+ System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }
}
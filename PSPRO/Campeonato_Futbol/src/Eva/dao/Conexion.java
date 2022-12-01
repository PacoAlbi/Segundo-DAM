package Eva.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    /**
     * Declaramos los Atributos privados para que no haya acceso a ellos desde
     * fuera de la clase.
     */
    private static final String USUARIO = "ad2223_eramos";
    private static final String PASSWORD = "1122";
    private static final String CONEXIONURL = "jdbc:mysql://dns11036.phdns11.es/ad2223_eramos";

   // Lo declaramos fuera para poder usarlo en los dos metodos creados en la clase
    private static Connection con;


    /**
     * Nombre: conectar()
     * Metodo para conectarse a una base de datos
     * @return devuelve una conexion
     */
    public static Connection conectar(){

        try {

            con = DriverManager.getConnection(CONEXIONURL,USUARIO,PASSWORD);

        } catch (SQLException e) {
            System.out.println("\033[31;1;4mError de conexion  a la BBDD de eramos" + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }


        return  con;
    }

    /**
     * Metodo para desconectarse de la base de datos
     */
    public static void desconectar(){

        try {
            if (con !=null)
                con.close();
        }catch (SQLException e) {
            System.out.println("\033[31;1;4mError AUN CONTINUA conectado a la Base de Datos " + System.lineSeparator() + e.getMessage() + " DEBIDO A " + e.getCause() + "\033[0m");
        }
    }


}

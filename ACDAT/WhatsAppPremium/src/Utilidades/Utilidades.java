package Utilidades;

import Conexion.Conexion;
import Entidades.Contacto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Utilidades {

    // Pagina: https://codigofacilito.com/articulos/asignar-permisos-mysql

    public static final String DARPERMISO = "GRANT INSERT ON ad2223_falbinana.Mensajes TO 'ad2223_eramos'@'%';";
    public static final String QUITARPERMISO = "REVOKE ALL PRIVILEGES ON *.* FROM 'usuario'@'localhost'";
    public static List<Contacto> contactos = new ArrayList<>();

    /**
     * <b>METODO PARA INSERTAR UN NUEVO CONTACTO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones : la tabla Contacto debe de existir
     */
    public static void insertarContacto(String usuario, Contacto contacto) {

        Statement statement;

        String sql = "INSERT INTO ad2223_" + usuario + ".Contactos VALUES(' " + contacto.getIdContacto() + "','" + contacto.getNombre() + "','0'";
        try {
            statement = Conexion.conectarseUsuario(usuario, "1234").createStatement();
            statement.executeUpdate(sql);
            System.out.println("Contacto CREADO");

        } catch (SQLException e) {
            System.out.println("Error"+e.getMessage());
        }
        Conexion.desconectar();
    }

    /**
     * <b>METODO PARA ELIMINAR UN CONTACTO</b>
     */
    public static void eliminarContacto() {

    }

    /**
     * <b></b>
     */
    public static void darPermisoInsert() {


        String permiso = "";

    }

    /**
     * <b>METODO QUE ACCEDE A LA BASE DE DATOS Y NOS DEVUELVE UN LISTADO DE CONTACTOS</b> <br> <br>
     * Precondiciones : la tabla Contactos debe existir en la base de datos <br>
     * Postcondiciones : obtenemos una lista de contactos
     * @param usuario
     * @return lista
     */
    public static List<Contacto> obtenerContactosFromBBDD(String usuario) {

        List<Contacto> lista = new ArrayList<>();


        Statement statement;
        ResultSet rs;
        Contacto contacto;
        String instruccionSQL = "SELECT * FROM ad2223_" + usuario + ".Contactos ORDER BY idUsuario";


        try {

            statement = Conexion.conectarseUsuario(usuario, "1234").createStatement();;
            rs = statement.executeQuery(instruccionSQL);

            while (rs.next()) {

                contacto = new Contacto();
                contacto.setIdContacto(rs.getString(1));
                contacto.setNombre(rs.getString(2));
                contacto.setBloqueado(rs.getBoolean(3));


                lista.add(contacto);
            }
            statement.close();
            rs.close();
            Conexion.desconectar();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;

    }

    public static String transformarBloqueo(boolean bloqueado){

        String devolucion = "0";

        if(bloqueado){
            devolucion = "1";
        }

        return devolucion;
    }

    public static void bloquearContacto(String idContacto,String usuario){


        Statement statement = null;



        String instruccionSQL = "UPDATE ad2223_mlopez +".Contacto SET nombre='"+usuarioAActualizar.getNombre()+"',apellidos='"+usuarioAActualizar.getApellido()+"',usuario='" + usuarioAActualizar.getUsername()+"',password='" + usuarioAActualizar.getPassword()+"',email='"+usuarioAActualizar.getEmail()+"'" + " WHERE idUsuario=" + usuarioAActualizar.getIdUsuario();

        try {

            statement = Conexion.conectarseUsuario(usuario,"1234").createStatement();
            statement.execute(instruccionSQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

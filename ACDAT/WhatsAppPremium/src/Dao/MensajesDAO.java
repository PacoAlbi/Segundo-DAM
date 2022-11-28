package Dao;

import Conexion.Conexion;
import Utilidades.Utilidades;
import modelo.Contacto;
import modelo.Mensaje;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MensajesDAO {

    /**
     * <b>METODO PARA INSERTAR UN NUEVO MENSAJE INTRODUCIDO POR PARAMETRO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones : la tabla Mensajes debe existir <br>
     * Postcondiciones : se introduce el mensaje en la base de datos
     * @param mensaje Recibe el mensaje que se va a mandar.
     * @param usuario Un string con el IdUsuario al que le mandamos el mensaje.
     */
    public void registrarMensajeDAO(Mensaje mensaje, String usuario) {

        Statement statement;

        String instruccionSQL = "INSERT INTO ad2223_"+ usuario +".Mensajes VALUES (NULL,'"+mensaje.getTexto()+"','"+mensaje.getFechaHora()+"',"+ mensaje.getLeido() +",'"+mensaje.getIdContacto()+"')";
        String instruccionSQLPropio = "INSERT INTO ad2223_mlopez.Mensajes VALUES (NULL,'"+mensaje.getTexto()+"','"+mensaje.getFechaHora()+"',"+ mensaje.getLeido() +",'"+mensaje.getIdContacto()+"')";

        try{
            statement = Conexion.conectarse().createStatement();
            statement.execute(instruccionSQLPropio);
            statement.execute(instruccionSQL);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Conexion.desconectar();
    }

    /**
     * <b>METODO QUE RECORRE LA TABLA Mensajes Y VA AÑADIENDOLOS A UNA LISTA PARA DEVOLVERLA</b <br> <br>
     * Precondiciones : la tabla Mensajes debe existir <br>
     * Postcondiciones : se crea una lista de mensajes y se devuelve
     * @return listaMensajes
     */
    public List<Mensaje> obtenerMensajesDAO() {


        Statement statement;
        ResultSet rs;

        String instruccionSQL = "SELECT * FROM ad2223_mlopez.Mensajes ORDER BY FechaHora DESC";

        List<Mensaje> listaMensajes = new ArrayList<>();

        try{

            statement = Conexion.conectarseUsuario("mlopez","1234").createStatement();
            rs = statement.executeQuery(instruccionSQL);

            while(rs.next()){
                Mensaje mensaje = new Mensaje();

                mensaje.setIdMensaje(rs.getInt(1));
                mensaje.setTexto(rs.getString(2));
                mensaje.setFechaHora(rs.getTimestamp(3));
                mensaje.setLeido(rs.getInt(4));
                mensaje.setIdContacto(rs.getString(5));

                listaMensajes.add(mensaje);
            }
            statement.close();
            rs.close();
            Conexion.desconectar();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaMensajes;
    }

    /**
     ** <b>METODO QUE RECORRE LA TABLA Mensajes Y VA AÑADIENDOLOS A UNA LISTA PARA DEVOLVERLA SEGUN EL CONTACTO</b <br> <br>
     * Precondiciones : la tabla Mensajes debe existir <br>
     * Postcondiciones : se crea una lista de mensajes y se devuelve
     * @param IdContacto
     * @return listaMensajes
     */
    public List<Mensaje> obtenerMensajesPorUsuarioDAO(String IdContacto) {


        Statement statement;
        ResultSet rs;

        String instruccionSQL = "SELECT * FROM ad2223_mlopez.Mensajes ORDER BY FechaHora DESC WHERE idContacto =" + IdContacto;

        List<Mensaje> listaMensajes = new ArrayList<>();

        try{

            statement = Conexion.conectarseUsuario("mlopez","1234").createStatement();
            rs = statement.executeQuery(instruccionSQL);

            while(rs.next()){
                Mensaje mensaje = new Mensaje();

                mensaje.setIdMensaje(rs.getInt(1));
                mensaje.setTexto(rs.getString(2));
                mensaje.setFechaHora(rs.getTimestamp(3));
                mensaje.setLeido(rs.getInt(4));
                mensaje.setIdContacto(rs.getString(5));

                listaMensajes.add(mensaje);
            }
            statement.close();
            rs.close();
            Conexion.desconectar();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaMensajes;
    }


    /**
     * <b>METODO PARA ELIMINAR UN MENSAJE DE LA BASE DE DATOS, RECIBE COMO PARAMETROS EL USUARIO A ELIMINAR</b> <br> <br>
     * Precondiciones : la tabla Mensajes y el mensaje deben existir en la base de datos <br>
     * Postcondiciones : se borra el Mensaje de la base de datos <br>
     * @param mensaje Recibe un mensaje para eliminar de la BBDD
     */
    public void eliminarMensajeDAO(Mensaje mensaje) {


        Statement statement;

        String instruccionSQL = "DELETE FROM ad2223_mlopez.Mensajes WHERE idMensaje =" + mensaje.getIdMensaje();

        try {

            statement = Conexion.conectarseUsuario("mlopez","1234").createStatement();
            statement.execute(instruccionSQL);

            Conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}

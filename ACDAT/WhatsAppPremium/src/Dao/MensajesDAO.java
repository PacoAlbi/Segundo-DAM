package Dao;

import Conexion.Conexion;
import Entidades.Mensaje;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MensajesDAO {

    /**
     * <b>METODO PARA INSERTAR UN NUEVO MENSAJE INTRODUCIDO POR PARAMETRO EN LA BASE DE DATOS</b> <br> <br>
     * Precondiciones: la tabla Mensajes debe existir <br>
     * Postcondiciones: se introduce el mensaje en la base de datos
     * @param mensaje Recibe el mensaje que se va a mandar.
     * @param usuario Un string con el IdUsuario al que le mandamos el mensaje.
     */
    public void registrarMensajeDAO(Mensaje mensaje, String usuario) {
        Statement statement;
        String instruccionSQL = "INSERT INTO ad2223_"+ usuario +".Mensajes VALUES (NULL,'"+mensaje.getTexto()+"','"+mensaje.getFechaHora()+"',"+ mensaje.getLeido() +",'"+mensaje.getIdContacto()+"')";
        try{
            statement = Conexion.conectarse().createStatement();
            statement.execute(instruccionSQL);
            statement.close();
            JOptionPane.showMessageDialog(null,"El mensaje ha sido enviado.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"\033[93;1;4mEl mensaje no se ha podido enviar.\033[0m");
        }
        Conexion.desconectar();
    }

    /**
     ** <b>METODO QUE RECORRE LA TABLA Mensajes ENVIADOS Y RECIBIDOS Y VA AÑADIENDOLOS A UNA LISTA PARA DEVOLVERLA SEGUN EL CONTACTO</b <br> <br>
     * Precondiciones: la tabla Mensajes debe existir <br>
     * Postcondiciones: se crea una lista de mensajes y se devuelve
     * @param IdContacto String con el id del contacto
     * @return listaMensajes List de todos los mensajes por contacto
     */
    public List<Mensaje> obtenerMensajesPorUsuarioDAO(String IdContacto) {
        Statement stRecibidos;
        Statement stEnviados;
        ResultSet rsRecibidos;
        ResultSet rsEnviados;
        String SQLContacto = "SELECT * FROM ad2223_"+ IdContacto +".Mensajes WHERE idContacto = 'falbinana' ORDER BY FechaHora DESC";
        String instruccionSQL = "SELECT * FROM ad2223_falbinana.Mensajes WHERE idContacto ='" + IdContacto + "' ORDER BY FechaHora DESC";
        List<Mensaje> listaMensajes = new ArrayList<>();
        try{
            stRecibidos = Conexion.conectarse().createStatement();
            stEnviados = Conexion.conectarse().createStatement();
            rsRecibidos = stRecibidos.executeQuery(instruccionSQL);
            rsEnviados = stEnviados.executeQuery(SQLContacto);
            while(rsRecibidos.next()){
                Mensaje mensajeRecibido = new Mensaje();
                mensajeRecibido.setIdMensaje(rsRecibidos.getInt(1));
                mensajeRecibido.setTexto(rsRecibidos.getString(2));
                mensajeRecibido.setFechaHora(rsRecibidos.getTimestamp(3));
                mensajeRecibido.setLeido(rsRecibidos.getInt(4));
                mensajeRecibido.setIdContacto(rsRecibidos.getString(5));
                listaMensajes.add(mensajeRecibido);
            }
            while(rsEnviados.next()){
                Mensaje mensajeEnviado = new Mensaje();
                mensajeEnviado.setIdMensaje(rsEnviados.getInt(1));
                mensajeEnviado.setTexto(rsEnviados.getString(2));
                mensajeEnviado.setFechaHora(rsEnviados.getTimestamp(3));
                mensajeEnviado.setLeido(rsEnviados.getInt(4));
                mensajeEnviado.setIdContacto(rsEnviados.getString(5));
                listaMensajes.add(mensajeEnviado);
            }
            stRecibidos.close();
            rsRecibidos.close();
            stEnviados.close();
            rsEnviados.close();
            Conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        listaMensajes.sort(new Comparator<Mensaje>() {
            @Override
            public int compare(Mensaje o1, Mensaje o2) {
                return o1.getFechaHora().compareTo(o2.getFechaHora());
            }
        });
        return listaMensajes;
    }

    /**
     * <b>METODO PARA ELIMINAR UN MENSAJE DE LA BASE DE DATOS, RECIBE COMO PARAMETROS EL USUARIO A ELIMINAR</b> <br> <br>
     * Precondiciones: la tabla Mensajes y el mensaje deben existir en la base de datos <br>
     * Postcondiciones: se borra el Mensaje de la base de datos <br>
     * @param idMensaje Recibe un mensaje para eliminar de la BBDD
     */
    public void eliminarMensajeDAO(int idMensaje) {
        Statement statement;
        String instruccionSQL = "DELETE FROM ad2223_falbinana.Mensajes WHERE idMensaje =" + idMensaje;
        try {
            statement = Conexion.conectarse().createStatement();
            statement.execute(instruccionSQL);
            Conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <b>METODO PARA ACTUALIZAR EL ESTADO DEL MENSAJE UNA VEZ LEIDO</b> <br> <br>
     * Precondiciones: la tabla Mensajes y el mensaje deben existir en la base de datos <br>
     * Postcondiciones: se actualiza el estado del mensaje <br>
     */
    public void actualizarLeido () {
        Statement statement;
        String instruccionSQL = "UPDATE ad2223_falbinana.Mensajes SET Leido = 1";
        try {
            statement = Conexion.conectarse().createStatement();
            statement.execute(instruccionSQL);
            Conexion.desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

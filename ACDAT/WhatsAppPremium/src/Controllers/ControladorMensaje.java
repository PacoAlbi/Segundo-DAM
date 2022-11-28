package Controllers;

import dao.MensajesDAO;
import modelo.Mensaje;

import java.util.List;

public class ControladorMensaje {

    /**
     * <b> METODO QUE LLAMA A registrarMensajeDAO() DEL DAO PARA INTRODUCIR UN MENSAJE EN LA BASE DE DATOS</b>
     * @param mensaje
     * @param usuario
     */
    public void registrarMensaje(Mensaje mensaje, String usuario){

        MensajesDAO mensajesDAO = new MensajesDAO();

        if(comprobarContacto(usuario)){

            mensajesDAO.registrarMensajeDAO(mensaje, usuario);

        }
    }


    /**
     * <b> METODO QUE LLAMA A eliminarMensajeDAO() DEL DAO PARA BORRAR UN MENSAJE EN LA BASE DE DATOS</b>
     * @param mensaje
     */
    public void eliminarMensaje(Mensaje mensaje){

        MensajesDAO mensajesDAO = new MensajesDAO();

        mensajesDAO.eliminarMensajeDAO(mensaje);
    }

    public List<Mensaje> obtenerMensajesController(){

        MensajesDAO mensajesDAO = new MensajesDAO();
        List<Mensaje> mensajes = mensajesDAO.obtenerMensajesDAO();

        return mensajes;
    }

    public List<Mensaje> obtenerMensajesPorUsuarioController (String IdContacto){
        MensajesDAO mensajesDAO = new MensajesDAO();
        List<Mensaje> mensajes = mensajesDAO.obtenerMensajesPorUsuarioDAO(IdContacto);
        return mensajes;
    }


    /**
     * <b>METODO PARA VERIFICAR QUE EL USUARIO INSERTADO ESTA DENTRO DE LOS CONTACTOS</b>
     * @param contacto
     * @return devolucion
     */
    public static boolean comprobarContacto(String contacto){

        boolean devolucion=false;

        switch (contacto){

            case "mlopez", "eramos", "falbinana"-> devolucion=true;
        }

        return devolucion;
    }




}

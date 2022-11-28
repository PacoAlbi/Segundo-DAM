package Controllers;


import Dao.MensajesDAO;
import Entidades.Mensaje;
import Utilidades.Utilidades;

import java.util.ArrayList;
import java.util.List;

public class ControladorMensaje {

    /**
     * <b> METODO QUE LLAMA A registrarMensajeDAO() DEL DAO PARA INTRODUCIR UN MENSAJE EN LA BASE DE DATOS</b>
     * @param mensaje mensaje para mandar
     * @param usuario usuario al que mandar el mensaje
     */
    public void registrarMensaje(Mensaje mensaje, String usuario){
        MensajesDAO mensajesDAO = new MensajesDAO();
        if(comprobarContacto(usuario)){
            mensajesDAO.registrarMensajeDAO(mensaje, usuario);
        }
    }

    /**
     * <b> METODO QUE LLAMA A eliminarMensajeDAO() DEL DAO PARA BORRAR UN MENSAJE EN LA BASE DE DATOS</b>
     * @param idMensaje Int con el id del mensaje a borrar.
     */
    public void eliminarMensaje(int idMensaje){

        MensajesDAO mensajesDAO = new MensajesDAO();

        mensajesDAO.eliminarMensajeDAO(idMensaje);
    }

    /**
     * <b> METODO QUE COMPRUEBA SI EL USUARIO ESTA BLOQUEADO, Y SI LO ESTA MANDA UN MENSAJE DE BLOQUEO, Y SI NO DEVUELVE LOS MENSAJES</b>
     * @param IdContacto String con el id del contacto
     * @return List de mensajes del contacto
     */
    public List<Mensaje> obtenerMensajesPorUsuarioController (String IdContacto){
        List<Mensaje> mensajes = new ArrayList<>();
        if (Utilidades.obtenerContactoPorId(IdContacto).isBloqueado() == 1){
            System.out.println("Este contacto está bloqueado.");
        } else {
            MensajesDAO mensajesDAO = new MensajesDAO();
            mensajes = mensajesDAO.obtenerMensajesPorUsuarioDAO(IdContacto);
        }

        return mensajes;
    }


    /**
     * <b>METODO PARA VERIFICAR QUE EL USUARIO INSERTADO ESTA DENTRO DE LOS CONTACTOS (SOLO LOS DEL GRUPO)</b>
     * @param contacto String con el id del contacto
     * @return devolucion Booleano de si se puede insertar o no
     */
    public static boolean comprobarContacto(String contacto){
        boolean devolucion=false;
        switch (contacto){
            case "mlopez", "eramos", "falbinana"-> devolucion=true;
        }
        return devolucion;
    }
}
package Vistas;

import Dao.MensajesDAO;
import Entidades.Contacto;
import Entidades.Mensaje;

import java.util.List;

public class Vista {
    /**
     * <b>METODO QUE RECORRE LA LISTA DE MENSAJES COMPROBANDO SI ESTA LEÍDO O NO. SI NO ESTÁ LEÍDO LO ACTUALIZA EN LA BBDD</b>
     * @param listaMensajes Lista de los mensajes del contacto
     */
    public static void verMensajes(List<Mensaje> listaMensajes){
        MensajesDAO mensaje = new MensajesDAO();
        for (int i = 0; i < listaMensajes.size(); i++) {
            System.out.println(listaMensajes.get(i) + System.lineSeparator());
            if (listaMensajes.get(i).getLeido() == 0){
                mensaje.actualizarLeido();
            }
        }
    }

    /**
     * <b>METODO QUE RECORRE LA LISTA DE CONTACTOS Y LOS MUESTRA</b>
     * @param listaContactos lista de todos los contactos
     */
    public static void verContactos (List<Contacto> listaContactos){
        for (int i = 0; i < listaContactos.size(); i++) {
            System.out.println(listaContactos.get(i) + System.lineSeparator());
        }
    }
}

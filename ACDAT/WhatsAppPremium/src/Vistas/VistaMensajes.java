package Vistas;

import modelo.Mensaje;

import java.util.List;

public class VistaMensajes {

    public static void verMensajes(List<Mensaje> listaMensajesUsuario){

        for (int i = 0; i < listaMensajesUsuario.size(); i++) {
            System.out.println(listaMensajesUsuario.get(i));
        }
    }

    public static void verUnMensaje(Mensaje mensaje){

        System.out.println(mensaje);
    }
}

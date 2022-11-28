package Utilidades;

import Controllers.ControladorContacto;
import Controllers.ControladorMensaje;
import Vistas.Vista;

public class Menu {

    public static ControladorMensaje controladorMensaje=new ControladorMensaje();
    public static ControladorContacto controladorContacto=new ControladorContacto();

    public static void pintarMenuInicial(){
        System.out.println("""
                ----------     Que desea hacer     ----------
                1.- Enviar mensaje
                2.- Ver todos los mensajes 
                3.- Borrar mensaje
                4.- Insertar un nuevo contacto
                5.- Borrar un contacto
                6.- Bloquear un contacto
                7.- Desbloquear un contacto
                0.- Salir
                """);
    }

    public static void pintarMenuUsuarios(){
        System.out.println("""
                ----------     Elija usuario     ----------
                1.- Manuel Lopez
                2.- Paco Albiñana
                3.- Eva Ramos
                0.- Salir""");
    }

    public static void mostrarMenu(){
        boolean salir=false;
        do {
            pintarMenuInicial();
            switch (Utilidades.leerDato()){
                case "1"-> elegirOpcionMenuEnviarMensaje();
                case "2"-> elegirOpcionMenuLeerMensaje();
                case "3"-> controladorMensaje.eliminarMensaje(Utilidades.elegirBorrarMensaje());
                case "4"-> controladorContacto.insertarContacto(Utilidades.crearContacto());
                case "5"-> {
                    Vista.verContactos(controladorContacto.obtenerContactos());
                    controladorContacto.eliminarContacto(Utilidades.borrarContacto());
                }
                case "6"-> {
                    Vista.verContactos(controladorContacto.obtenerContactos());
                    controladorContacto.bloquearContacto(Utilidades.bloquearContacto());
                }
                case "7"-> {
                    Vista.verContactos(controladorContacto.obtenerContactos());
                    controladorContacto.desbloquearContacto(Utilidades.desbloquearContacto());
                }
                case "0"-> salir=true;
                default -> System.out.println("Opcion incorrecta");
            }
        }while (!salir);
    }

    public static void elegirOpcionMenuEnviarMensaje(){
        boolean salir=false;
        do {
            pintarMenuUsuarios();
            switch (Utilidades.leerDato()){
                case "1" -> controladorMensaje.registrarMensaje(Utilidades.crearMensaje(),"mlopez");
                case "2" -> controladorMensaje.registrarMensaje(Utilidades.crearMensaje(),"falbinana");
                case "3" -> controladorMensaje.registrarMensaje(Utilidades.crearMensaje(),"eramos");
                case "0" -> salir=true;
                default -> System.out.println("Opcion incorrecta");
            }
        }while (!salir);

    }

    public static void elegirOpcionMenuLeerMensaje(){
        boolean salir=false;
        do {
            pintarMenuUsuarios();
            switch (Utilidades.leerDato()){
                case "1" -> Vista.verMensajes(controladorMensaje.obtenerMensajesPorUsuarioController("mlopez"));
                case "2" -> Vista.verMensajes(controladorMensaje.obtenerMensajesPorUsuarioController("falbinana"));
                case "3" -> Vista.verMensajes(controladorMensaje.obtenerMensajesPorUsuarioController("eramos"));
                case "0" -> salir=true;
                default -> System.out.println("Opcion incorrecta");
            }
        }while (!salir);

    }
}
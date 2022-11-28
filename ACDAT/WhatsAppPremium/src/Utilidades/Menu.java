package Utilidades;

import controllers.ControladorContacto;
import controllers.ControladorMensaje;
import dao.MensajesDAO;
import vistas.VistaMensajes;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        mostrarMenu();
    }

    public static ControladorMensaje controladorMensaje=new ControladorMensaje();
    public static ControladorContacto controladorContacto=new ControladorContacto();

    /**
     * Metodo para pintar el menu Principal
     */


    /**
     * Metodo para
     */

    public static void pintarLeerMensaje(){
        System.out.println("""
                1.- Leer mensajes
                0.- Salir""");
    }


    public static String leerDato(){

        Scanner sc=new Scanner(System.in);
        return sc.next();
    }
    public static void pintarMenuInicial(){



        System.out.println("""
                ----------     Que desea hacer     ----------
                1.- Enviar mensaje
                2.- Ver todos los mensajes 
                3.- Borrar mensaje
                4.- Insertar un nuevo contacto
                5.- Borrar un contacto
                6.- Bloquear un contacto
                0.- Salir
                """);
    }
    public static void mostrarMenu(){

        boolean salir=false;

        do {
            pintarMenuInicial();
            switch (leerDato()){

                case "1"-> elegirOpcionMenuEnviarMensaje();
                case "2"-> {
                    VistaMensajes.verMensajes(controladorMensaje.obtenerMensajesController());
                    mostrarMensaje();
                }
                case "3" -> System.out.println("En construccion");
                case "4"-> System.out.println("En construccion");
                case "5"-> System.out.println("En construccion");
                case "6"-> System.out.println("En construccion");
                case "0"-> salir=true;
                default -> System.out.println("Opcion incorrecta");
            }
        }while (!salir);

    }

    public static void mostrarMensaje(){

        boolean salir=false;

        do {
            pintarLeerMensaje();
            switch (leerDato()){
                case "1"-> controladorMensaje.obtenerMensajesPorUsuarioController("mlopez");
                case "0" -> salir=true;
                default -> System.out.println("Opcion incorrecata");
            }
        }while (!salir);
    }

    public static void pintarMenuUsuarios(){

        System.out.println("""
                ----------     Elija usuario     ----------
                1.- Manuel Lopez
                2.- Paco Albiñana
                3.- Eva Ramos
                0.- Salir""");
    }

    public static void elegirOpcionMenuEnviarMensaje(){

        boolean salir=false;

        do {
            pintarMenuUsuarios();
            switch (leerDato()){
                case "1" -> controladorMensaje.registrarMensaje(Utilidades.crearMensaje("mlopez"),"mlopez");
                case "2" -> controladorMensaje.registrarMensaje(Utilidades.crearMensaje("falbinana"),"falbinana");
                case "3" -> controladorMensaje.registrarMensaje(Utilidades.crearMensaje("eramos"),"eramos");
                case "0" -> salir=true;
                default -> System.out.println("Opcion incorrecta");
            }
        }while (!salir);

    }
    public static void elegirOpcionMenuBorraContacto(){

        boolean salir=false;

        do {
            pintarMenuUsuarios();
            switch (leerDato()){
                case "1" -> controladorContacto.eliminarContacto("mlopez");
                case "2" -> controladorContacto.eliminarContacto("falbinana");
                case "3" -> controladorContacto.eliminarContacto("eramos");
                case "0" -> salir=true;
                default -> System.out.println("Opcion incorrecta");
            }
        }while (!salir);

    }

    public static void elegirOpcionMenuBloquearContacto(){

        boolean salir=false;

        do {
            pintarMenuUsuarios();
            switch (leerDato()){
                case "1" -> controladorContacto.eliminarContacto("mlopez");
                case "2" -> controladorContacto.eliminarContacto("falbinana");
                case "3" -> controladorContacto.eliminarContacto("eramos");
                case "0" -> salir=true;
                default -> System.out.println("Opcion incorrecta");
            }
        }while (!salir);

    }




}

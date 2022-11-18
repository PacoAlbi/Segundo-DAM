package Utilidades;

import java.util.Scanner;

public class Menu {


    public static void pintarMenu(){

        System.out.println("----------     Que desea hacer     ----------" +
                "1.- Enviar mensaje" +
                "2.- Leer un mensaje" +
                "3.- Borrar mensaje" +
                "4.- Insertar un nuevo contacto" +
                "5.- Borrar un contacto" +
                "6.- Bloquear un contacto" +
                "0.- Salir");
    }

    public static String leerDato(){

        Scanner sc=new Scanner(System.in);
        System.out.println("Elija la opcion deseada");
        return sc.next();
    }

    public static void mostrarMenu(){

        boolean salir=false;

        do {
            pintarMenu();
            switch (leerDato()){

                case "1","2","3","4","5","6" -> System.out.println("En construccion");
                case"0"-> salir=true;
            }
        }while (!salir);

    }



}

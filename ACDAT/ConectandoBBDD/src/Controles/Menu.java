package Controles;

import java.util.Scanner;

public class Menu {

//    System.out.println("\033[31;1;4mEn Construcción\033[0m"); //Para poner el texto en rojo; negrita; subrayado por ese orden dentro de los ;
//    System.out.println("\033[93;1;4mEn Construcción\033[0m"); //Amarillo
//    System.out.println("\033[92;1;4mEn Construcción\033[0m"); //Verde

    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""
                
                ------Bienvenido a mi menú de hoy, ¿Que desea hacer?------
                [1] Mostrar Tablas.
                [2] Mostrar Datos de una tabla.
                [3] Buscar.
                [4] Insertar.
                [5] Borrar.
                [0] Salir.
                ----------------------------------------------------------""");
    }

    /**
     * Precondiciones: No tiene.
     * Método que imprime por pantalla el menú y comprueba si la entrada es válida.
     * Postcondiciones: Lanza un proceso u otro según la opción elegida.
     */
    public static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        String menu;
        boolean salir = false;
        do {
            pintarMenu();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("En Construcción");
                case "2" -> mostrarTabla();
                case "3" -> System.out.println("\033[31;1;4mEn Construcción\033[0m"); //Para poner el texto en rojo; negrita; subrayado por ese orden dentro de los ;
                case "4" -> System.out.println("\033[93;1;4mEn Construcción\033[0m"); //Amarillo
                case "5" -> System.out.println("\033[92;1;4mEn Construcción\033[0m"); //Verde
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }


    public static void pintarMostrarTabla() {
        System.out.println("""
                
                -------Elija una tabla-------
                [1] Usuarios.
                [2] Posts.
                [3] Likes.
                [0] Salir.
                -----------------------------""");
    }

    public static void mostrarTabla() {
        Scanner sc = new Scanner(System.in);
        String menu;
        boolean salir = false;
        do {
            pintarMostrarTabla();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("En Construcción");
                case "2" -> System.out.println("En Construcción");
                case "3" -> System.out.println("En Construcción");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }

    public static void mostrarBuscar() {
        Scanner sc = new Scanner(System.in);
        String menu;
        boolean salir = false;
        do {
            pintarMostrarTabla();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("En Construcción");
                case "2" -> System.out.println("En Construcción");
                case "3" -> System.out.println("En Construcción");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }

    public static void mostrarInsertar() {
        Scanner sc = new Scanner(System.in);
        String menu;
        boolean salir = false;
        do {
            pintarMostrarTabla();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("En Construcción");
                case "2" -> System.out.println("En Construcción");
                case "3" -> System.out.println("En Construcción");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }

    public static void mostrarBorrar() {
        Scanner sc = new Scanner(System.in);
        String menu;
        boolean salir = false;
        do {
            pintarMostrarTabla();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("En Construcción");
                case "2" -> System.out.println("En Construcción");
                case "3" -> System.out.println("En Construcción");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }
}

package Utils;

import java.util.Scanner;

public class Menu {

//    System.out.println("\033[31;1;4mEn Construcción\033[0m"); //Para poner el texto en rojo; negrita; subrayado por ese orden dentro de los ;
//    System.out.println("\033[93;1;4mEn Construcción\033[0m"); //Amarillo
//    System.out.println("\033[92;1;4mEn Construcción\033[0m"); //Verde

    private static Scanner sc = new Scanner(System.in);
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""

                ---Bienvenido a mi menú de hoy, ¿Que desea hacer?---
                [1] Mostrar Datos.
                [2] Actualizar.
                [3] Insertar.
                [4] Borrar.
                [0] Salir.
                ----------------------------------------------------""");
    }

    /**
     * Precondiciones: No tiene.
     * Método que imprime por pantalla el menú y comprueba si la entrada es válida.
     * Postcondiciones: Lanza un proceso u otro según la opción elegida.
     */
    public static void menuPrincipal() {
        String menu;
        boolean salir = false;
        do {
            pintarMenu();
            menu = sc.next();
            switch (menu) {
                case "1" -> mostrarTablas();
                case "2" -> mostrarActualizar();
                case "3" -> mostrarInsertar();
                case "4" -> mostrarBorrar();
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }


    public static void pinntar3Tablas() {
        System.out.println("""

                ---Elija una tabla---
                [1] Usuarios.
                [2] Posts.
                [3] Likes.
                [0] Salir.
                ---------------------""");
    }

    public static void pinntar2Tablas() {
        System.out.println("""

                ---Elija una tabla---
                [1] Usuarios.
                [2] Posts.
                [0] Salir.
                ---------------------""");
    }

    public static void mostrarTablas() {
        String menu;
        boolean salir = false;
        do {
            pinntar3Tablas();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "2" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "3" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    public static void mostrarActualizar() {
        String menu;
        boolean salir = false;
        do {
            pinntar2Tablas();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "2" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    public static void mostrarInsertar() {
        String menu;
        boolean salir = false;
        do {
            pinntar2Tablas();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "2" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    public static void mostrarBorrar() {
        String menu;
        boolean salir = false;
        do {
            pinntar3Tablas();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "2" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "3" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }
}

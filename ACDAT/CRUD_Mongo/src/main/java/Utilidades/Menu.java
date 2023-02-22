package Utilidades;

import Conecction.Conexion;

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
                ---Granja la vaca que mira con desdén---
                [1] Gestionar Ganado.
                [2] Gestionar Naves.
                [3] Gestionar Producción.
                [0] Salir.
                ----------------------------------------""");
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
                case "1" -> mostrarOpcionesGanado();
                case "2" -> mostrarOpcionesNaves();
                case "3" -> mostrarOpcionesProduccion();
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }

    //--------------------------------------------------GANADO----------------------------------------------------------

    public static void pintarOpcionesGanado() {
        System.out.println("""
                ------Elija una tabla------
                [1] Ver lista del ganado.
                [2] Buscar Vaca.
                [3] Insertar vaquita.
                [4] Editar Vaca.
                [5] Eliminar Vaca.
                [0] Volver menu anterior.
                ---------------------------""");
    }

    public static void mostrarOpcionesGanado() {
        String menu;
        boolean salir = false;
        do {
            pintarOpcionesGanado();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93m" + Conexion.getListGanado() + "\033[0m");
                case "2" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "3" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "4" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "5" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    //-------------------------------------------------NAVES------------------------------------------------------------

    public static void pintarOpcionesNaves() {
        System.out.println("""
                -----Elija una colección-----
                [1] Ver lista naves.
                [2] Buscar Nave.
                [3] Insertar Nave.
                [4] Actualizar propietario.
                [5] Eliminar Nave.
                [0] Volver menu anterior.
                -----------------------------""");
    }

    public static void mostrarOpcionesNaves() {
        String menu;
        boolean salir = false;
        do {
            pintarOpcionesNaves();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93m" + Conexion.getListNaves() + "\033[0m");
                case "2" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "3" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "4" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "5" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    //---------------------------------------------PRODUCCIONES---------------------------------------------------------

    public static void pintarOpcionesProduccion() {
        System.out.println("""
                ------Elija una tabla------
                [1] Lista producción.
                [2] Producción por vaca/l.
                [3] Producción por mes/l.
                [4] Producción por año/l.
                [0] Volver menu anterior.
                ---------------------------""");
    }

    public static void mostrarOpcionesProduccion() {
        String menu;
        boolean salir = false;
        do {
            pintarOpcionesProduccion();
            menu = sc.next();
            switch (menu) {
                case "1" -> System.out.println("\033[93m" + Conexion.getListProduccion() + "\033[0m");
                case "2" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "3" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "4" -> System.out.println("\033[93;1;4mEn Construcción\033[0m");
                case "0" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
    }

    //-------------------------------------------------OTROS------------------------------------------------------------

    public static void mostrarInsertar() {
        String menu;
        boolean salir = false;
        do {
            pintarOpcionesProduccion();
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
            pintarOpcionesNaves();
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
package Controles;

import java.util.Scanner;

public class Menu {

    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""
                
                ------Bienvenido a mi menú de hoy, ¿Que desea hacer?------
                [1] Mostrar Tabla.
                [2] Buscar.
                [3] Mostrar contenido del directorio.
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
                case "2" -> System.out.println("En Construcción");
                case "3" -> System.out.println("En Construcción");
                case "0" -> salir = true;
                default -> System.out.println("No es una opción válida.");
            }
        } while (!salir);
        sc.close();
    }
}

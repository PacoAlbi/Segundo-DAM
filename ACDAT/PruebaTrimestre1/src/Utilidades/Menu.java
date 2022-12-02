package Utilidades;

import java.util.Scanner;

public class Menu {

    private static Scanner sc = new Scanner(System.in);
    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""
                
                ---GRAN SORTEO DE LA LOTERÍA DEL IES NERVIÓN---
                [1] Iniciar sorteo.
                [2] Ver persona más afortunada (saldo mayor).
                [3] Ver persona más suertuda (mayor número aciertos).
                [4] Número más repetido.
                [5] Reiniciar.
                [6] Salir.
                -----------------------------------------------""");
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
                case "1" -> Sorteos.realizarSorteo();
                case "2" -> System.out.println("Nada");
                case "3" -> System.out.println("Nada");
                case "4" -> System.out.println("Nada");
                case "5" -> System.out.println("Nada");
                case "6" -> salir = true;
                default ->  System.out.println("\033[93;1;4mNo es una opción válida.\033[0m");
            }
        } while (!salir);
        sc.close();
    }
}
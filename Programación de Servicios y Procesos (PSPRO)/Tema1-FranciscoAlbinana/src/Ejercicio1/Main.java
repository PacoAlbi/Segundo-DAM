//Crea un programa que muestre un menú al usuario como el siguiente:
//Elija qué comando desea ejecutar:
//1. Crear carpeta
//2. Crear fichero
//3. Mostrar contenido del directorio
//Atendiendo a la opción seleccionada por el usuario, el programa debe lanzar un proceso u otro. Toma de base el archivo Ejercicio1.java que se adjunta a la tarea.

package Ejercicio1;

import java.util.Scanner;

public class Main {

    //Abro mi lectura estandar.
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""
                
                ------Bienvenido a mi menú de hoy, ¿Que desea hacer?------
                [1] Crear carpeta.
                [2] Crear fichero.
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
        String menu;
        boolean salir = false;
        do {
            pintarMenu();
            menu = sc.next();
            switch (menu) {
                case "1" -> Procesos.crearCarpeta();
                case "2" -> Procesos.crearFichero();
                case "3" -> Procesos.mostrarContenido();
                case "0" -> salir = true;
                default -> System.out.println("No es una opción válida.");
            }
        } while (!salir);
        sc.close();
    }
}
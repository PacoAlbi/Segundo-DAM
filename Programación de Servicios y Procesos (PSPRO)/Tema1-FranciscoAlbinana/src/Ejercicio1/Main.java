package Ejercicio1;

import java.util.Scanner;

public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
    }

    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu(){
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
    public static void menuPrincipal (){
        int menu;
        boolean salir=false;
        do{
            pintarMenu();
            menu = leerEntero();
            switch (menu) {
                case 1 -> Procesos.crearCarpeta();
                case 2 -> Procesos.crearFichero();
                case 3 -> Procesos.mostrarContenido();
                case 0 -> salir = true;
                default -> System.out.println("No es una opción válida.");
            }
        }while (!salir);
        sc.close();
    }

    /**
     * Precondiciones: No tiene.
     * Compruebo con un try catch que el entero introducido sea válido.
     * @return Devuelve el entero si es válido o un mensaje de error si no lo es.
     * Postcondiciones: No tiene.
     */
    public static int leerEntero (){
        int numero=0;
        boolean salir=false;
        do {
            try {
                numero = sc.nextInt();
                salir=true;
            } catch (Exception e) {
                sc.nextLine();
                //Aquí no te muestro el código de la excepción porque si no saldría demasiado y no es necesario.
                System.out.println("Esto no es un número entero.");
            }
        }while (!salir);
        return numero;
    }
}
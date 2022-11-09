package Ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        String[] comando = creaComando();
        ProcessBuilder pb = new ProcessBuilder(comando);
        pb.inheritIO();
        try {
            Process p = pb.start();
            int retorno = p.waitFor();
            if (retorno == 0){
                System.out.println("Proceso finalizado con éxito.");
            } else {
                System.out.println("El comando " + comando.toString() + " ha terminado con el código de error " + retorno);
            }
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            // Indicamos que la ejecución termina con error 1
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            // Indicamos que la ejecución termina con error 3
            System.exit(3);
        }
    }

    public static String[] creaComando (){
        Scanner sc = new Scanner(System.in);
        int opcion;
        int numero1;
        int numero2;
        pintarMenu();
        System.out.println("¿Que desea hacer?");
        opcion = sc.nextInt();
        System.out.println("Introduza el primer número.");
        numero1 = sc.nextInt();
        System.out.println("Introduzca el segundo número.");
        numero2 = sc.nextInt();
        String[] comando = {"java", "src/Ejercicio1/Calculadora.java", String.valueOf(opcion), String.valueOf(numero1), String.valueOf(numero2)};
        sc.close();
        return comando;
    }

    /**
     * Precondiciones: No tiene.
     * Método que crea la estructura del menú para imprimirla.
     * Postcondiciones: No tiene.
     */
    public static void pintarMenu() {
        System.out.println("""
                
                ------Bienvenido a mi menú de hoy, ¿Que desea hacer?------
                [1] SUMA.
                [2] RESTA.
                [3] MULTIPLICACIÓN.
                [4] DIVISIÓN.
                [0] SALIR.
                ----------------------------------------------------------""");
    }
}
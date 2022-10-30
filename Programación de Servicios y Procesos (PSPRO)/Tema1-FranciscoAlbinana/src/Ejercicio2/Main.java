package Ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    /**
     * Precondiciones: El fichero debe estar ya creado, o en su caso, la primera vez nos pedirá crearlo el notepad.
     * Método Main que lanza el notepad para que guardes unas líneas y contarlar llamando a la clase CuentaLineas mediante un proceso.
     * Postcondiciones: No tiene.
     */
    public static void main(String[] args) {
        //Preparo el comando para el proceso 1.
        String[] comando1 = {"notepad","C:\\Users\\Paco\\Documents\\GitHub\\Segundo-DAM\\Programación de Servicios y Procesos (PSPRO)\\Tema1-FranciscoAlbinana\\src\\Ejercicio2\\numLineas.txt"};
        //Creo el proceso 1.
        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        //Redirecciono a la entrada y salida estandar.
        pb1.inheritIO();
        //Preparo el comando para el proceso 2.
        String[] comando2 = {"java","src/ejercicio2/CuentaLineas.java"};
        //Creo el proceso 2.
        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        //Redirecciono la entrada al fichero creado del proceso 1.
        pb2.redirectInput(new File("src/Ejercicio2/numLineas.txt"));
        //Redirecciono la salida y el error a las del proceso padre.
        pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb2.redirectError(ProcessBuilder.Redirect.INHERIT);
        try {
            //Lanzo el proceso 1.
            Process p1 = pb1.start();
            //Espero 30 segundos a que termine el proceso 1.
            if(p1.waitFor(30, TimeUnit.SECONDS)){
                //Si ha tardado menos, lanzo el proceso 2.
                Process p2 = pb2.start();
                //Espero al proceso 2.
                p2.waitFor();
            }else{
                //Si ha tardado más, lanzo un mensaje y termino la ejecución del proceso.
                System.out.println("Has tardado mas de 30 segundos");
                p1.destroy();
            }
            //Controlo las posibles excepciones lanzadas.
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(3);
        } catch (InterruptedException e) {
            System.out.println("El proceso se ha interrumpido");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(3);
        }
    }
}

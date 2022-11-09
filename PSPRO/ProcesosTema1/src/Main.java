//Crea una clase que lance los siguientes procesos y que sincronice la ejecución entre ellos:
//Proceso 1: Creación por línea de comandos de una carpeta de nombre “carpeta1” en la ruta C:\pruebas. Si esta carpeta no existe créala.
//Proceso 2: Creación por línea de comandos un fichero en blanco en la carpeta creada en el Proceso 1. Llama al fichero “fichero1.txt”.  Deberá esperar a que termine correctamente el Proceso 1 antes de crear el fichero.
//Proceso 3: Abre el fichero creado en el Proceso 2 con el bloc de notas (el comando es notepad). Antes de abrir el fichero tiene que esperar a que termine el Proceso 2.

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Comprobamos que se ha introducido al menos un comando
        if (args.length <= 0) {
            System.out.println("Debe indicarse comando a ejecutar.");
            // Terminamos la ejecución del programa con valor 1
            System.exit(1);
        }

        // Le pasamos los argumentos al ProcessBuilder
        ProcessBuilder pb = new ProcessBuilder(args);
        File directorio = new File("C:\\Users\\falbinana\\IdeaProjects\\ProcesosTema1\\src\\Ejercicios");
        pb.directory(directorio);
    /* Con esta llamada hacemos que el proceso herede la entrada
    y salida estándares del proceso padre */
        pb.inheritIO();

        try {
            // Arrancamos el proceso
            Process p = pb.start();
            while (p.isAlive()){
                System.out.println("El proceso sigue vivo.");
                Thread.sleep(3000);
            }
            System.out.println("El proceso ha muerto, recemos por él.");
            /* Se espera a que termine la ejecución del proceso hijo y se obtiene el código de retorno.
             * Si durante la espera se interrumple la ejecución del programa, se lanzaría una excepción
             * de tipo InterruptedException. Este programa la capturaría y la informaría.
             */
            int codRet = p.waitFor();
            System.out.println("La ejecución de " + Arrays.toString(args)
                    + " devuelve " + codRet
                    + " " + (codRet == 0 ? "(ejecución correcta)" : "(ERROR)")
            );
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            // Indicamos que la ejecución termina con error 2
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            // Indicamos que la ejecución termina con error 2
            System.exit(3);
        }
    }
}
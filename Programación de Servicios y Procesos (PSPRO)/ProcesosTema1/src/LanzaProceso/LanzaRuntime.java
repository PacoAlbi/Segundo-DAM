package LanzaProceso;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class LanzaRuntime {

    public static void main(String[] args) throws IOException {

        // Comprobamos que se ha introducido al menos un comando
        if (args.length <= 0) {
            System.out.println("Debe indicarse comando a ejecutar.");
            // Terminamos la ejecución del programa con valor 1
            System.exit(1);
        }

        // Le pasamos los argumentos al Runtime
        Runtime run = Runtime.getRuntime();



        try {
            // Arrancamos el proceso
            Process process = run.exec(args);

            /* Se espera a que termine la ejecución del proceso hijo y se obtiene el código de retorno.
             * Si durante la espera se interrumple la ejecución del programa, se lanzaría una excepción
             * de tipo InterruptedException. Este programa la capturaría y la informaría.
             */
            int codRet = process.waitFor();
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

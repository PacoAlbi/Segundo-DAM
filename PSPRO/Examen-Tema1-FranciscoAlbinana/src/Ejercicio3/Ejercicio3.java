package Ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio3 {

    public static void main(String[] args) {
        //Temporizador para ver el tiempo.
        long inicio = System.currentTimeMillis();
        //Contador de procesos.
        int num = 1;
        String [] comando1 = {"java", "src/Ejercicio3/NumerosAleatorios.java"};
        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        List<Process> listaProcesos = new ArrayList<>();
        //Lanzo los 10 primeros que crean los archivos.
        try {
            for (int i = 0; i < 10; i++) {
                pb1.redirectOutput(new File("src/Ejercicio3/numeros" + num + ".txt"));
                Process p = pb1.start();
                listaProcesos.add(p);
                num++;
            }
            //Compruebo que todos los archivos estén creados.
            while (num > 0) {
                num = 10;
                // Recorro la lista de procesos para ver si siguen vivos.
                for (Process proceso : listaProcesos) {
                    // Si alguno de los procesos ya ha terminado, entonces resto 1.
                    if(!proceso.isAlive()) {
                        num--;
                    }
                }
            }
            //Espero a que finalicen los procesos.
            for(Process proceso : listaProcesos) {
                int retorno = proceso.exitValue();
                // Compruebo cómo ha terminado el proceso y escribo un mensaje.
                if (retorno == 0) {
                    System.out.println("El proceso ha finalizado correctamente");
                } else {
                    System.out.println("El proceso ha terminado con el siguiente código de error: " + retorno);
                }
            }
            //Reseteo el contador.
            num = 1;
            //Inicio los otros 20 procesos a la vez.
            for (int i = 0; i < 10; i++) {
                String [] comando2 = {"java", "src/Ejercicio3/SumaNumeros.java", String.valueOf(num)};
                ProcessBuilder pb2 = new ProcessBuilder(comando2);
                String [] comando3 = {"java", "src/Ejercicio3/MediaNumeros.java", String.valueOf(num)};
                ProcessBuilder pb3 = new ProcessBuilder(comando3);
                pb2.redirectInput(new File("src/Ejercicio3/numeros" + num + ".txt"));
                //Redirecciono y sumo añados los resultados sin borrar.
                pb2.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src/Ejercicio3/sumas.txt")));
                pb2.start();
                pb3.redirectInput(new File("src/Ejercicio3/numeros" + num + ".txt"));
                //Redirecciono y sumo añados los resultados sin borrar.
                pb3.redirectOutput(ProcessBuilder.Redirect.appendTo(new File("src/Ejercicio3/medias.txt")));
                pb3.start();
                num++;
            }
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(1);
        }
        long fin = System.currentTimeMillis();
        System.out.println("Ha tardado en ejecutarse: " + (fin-inicio) + " milisegundos.");
    }
}

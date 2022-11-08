package Ejercicio2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {
        String[] comando1 = {"java","src/Ejercicio2/MayoresEdad.java"};
        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        pb1.redirectInput(new File("src/Ejercicio2/alumnos.txt"));
        String[] comando2 = {"java","src/Ejercicio2/OrdenaNombres.java"};
        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        pb2.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        List<ProcessBuilder> lpb = new ArrayList<>();
        lpb.add(pb1);
        lpb.add(pb2);
        try{

            List<Process> procesos = ProcessBuilder.startPipeline(lpb);

//            for(Process proceso : procesos) {
//                int retorno = proceso.exitValue();
//                // Compruebo cómo ha terminado el proceso y escribo un mensaje.
//                if (retorno == 0) {
//                    System.out.println("El proceso ha finalizado correctamente");
//                } else {
//                    System.out.println("El proceso ha terminado con el siguiente código de error: " + retorno);
//                }
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

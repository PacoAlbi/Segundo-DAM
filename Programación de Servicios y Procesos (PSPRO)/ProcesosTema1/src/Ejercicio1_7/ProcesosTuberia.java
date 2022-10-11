package Ejercicio1_7;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcesosTuberia {

    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder("java", "Clase1Aleatoria.java");
        pb1.directory(new File("src/Ejercicio1_7"));
        ProcessBuilder pb2 = new ProcessBuilder("java", "Clase2ABC.java");
        pb2.directory(new File("src/Ejercicio1_7"));
        ProcessBuilder pb3 = new ProcessBuilder("java", "Clase3Imprime.java");
        pb3.directory(new File("src/Ejercicio1_7"));
        pb1.redirectInput(ProcessBuilder.Redirect.INHERIT); //Esta línea no es necesaria, ya que no estamos escribiendo nada por teclado.
        pb3.redirectOutput(new File("src/Ejercicio1_7/ips.txt"));

        pb1.redirectErrorStream(true);
        pb2.redirectErrorStream(true);
        pb3.redirectErrorStream(true);

        List<ProcessBuilder> lpb = new ArrayList<>();
        lpb.add(pb1);
        lpb.add(pb2);
        lpb.add(pb3);

        try {

            List<Process> lProcess = ProcessBuilder.startPipeline(lpb);

        } catch (IOException e) {
            System.out.println("Error de entrada salida.");
            e.printStackTrace();
        }
    }
}

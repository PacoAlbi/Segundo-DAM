package Ejercicio1_5;

import java.io.File;
import java.io.IOException;

public class LanzaPregunta {

    public static void main(String[] args) {
        String comando [] = {"java", "PreguntaNombre.java"};

        ProcessBuilder pb = new ProcessBuilder(comando);

        pb.directory(new File("src/Ejercicio1_5"));
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.redirectInput(new File("src/Ejercicio1_5/nombres.txt"));

        try {
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

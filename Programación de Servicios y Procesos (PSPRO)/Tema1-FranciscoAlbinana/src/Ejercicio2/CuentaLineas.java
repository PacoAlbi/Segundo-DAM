package Ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CuentaLineas {

    public static long countLineJava8(String fileName) {

        Path path = Paths.get(fileName);

        long lines = 0;
        try {
            Files.lines(path).parallel().count();

            lines = Files.lines(path).count();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;

    }
}

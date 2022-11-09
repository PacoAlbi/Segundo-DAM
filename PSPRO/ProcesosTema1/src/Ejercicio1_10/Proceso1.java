package Ejercicio1_10;

import java.io.IOException;

public class Proceso1 {
    public static void main(String[] args) {
        String[] comando1 = {"cmd", "/C", "md", "C:\\pruebas\\carpeta1"};
        String[] comando2={"cmd", "/C", "type nul > fichero1.txt"};
        String[] comando3={"notepad", "fichero1.txt"};
        ProcessBuilder pb1 = new ProcessBuilder(comando1);
        ProcessBuilder pb2 = new ProcessBuilder(comando2);
        ProcessBuilder pb3 = new ProcessBuilder(comando3);

        pb1.inheritIO();
        pb2.inheritIO();
        pb3.inheritIO();

        try {
            Process p1 = pb1.start();
            p1.waitFor();
            Process p2 = pb2.start();
            p2.waitFor();
            Process p3 = pb3.start();
            p3.waitFor();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

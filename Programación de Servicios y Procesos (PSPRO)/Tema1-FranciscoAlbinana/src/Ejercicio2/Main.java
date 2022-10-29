package Ejercicio2;

import Ejercicio1.Procesos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] comando1 = {"cmd","/C","type","nul",">","C:\Users\manul\Desktop\2--DAM\Procesos\EjercicioPracticoUD1\src\ejercicio2\numLineas.txt"};
        ProcessBuilder pb1 = new ProcessBuilder(comando1);

        pb1.redirectError(ProcessBuilder.Redirect.INHERIT);

        pb1.inheritIO();

        String[] comando2 = {"notepad","C:\Users\manul\Desktop\2--DAM\Procesos\EjercicioPracticoUD1\src\ejercicio2\numLineas.txt"};
        ProcessBuilder pb2 = new ProcessBuilder(comando2);

        pb2.redirectInput(new File("src\ejercicio2\numLineas.txt"));

        pb2.inheritIO();

        String[] comando3 = {"java","src/ejercicio2/CuentaLineas.java"};
        ProcessBuilder pb3 = new ProcessBuilder(comando3);

        pb3.inheritIO();

        try {
            Process p1 = pb1.start();
            p1.waitFor();
            Process p2 = pb2.start();
            if(p2.waitFor(10,TimeUnit.SECONDS)){
                Process p3 = pb3.start();
                p3.waitFor();
            }else{
                System.out.println("Has tardado mas de 30 segundos");
                p1.destroy();
                p2.destroy();
            }



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

        Enviar mensaje a Manuulc~, EvaSomi

    }

}

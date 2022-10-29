package Ejercicio3;

import Ejercicio1.Procesos;

import java.io.IOException;

public class SinEsperas {

    public static void main(String[] args) {
        //Tiempo en que empieza
        long tmpInicio = System.currentTimeMillis();
        char[] vocales = new char[]{'a','e','i','o','u'};
        //Array de procesos
        Process[] procesos = new Process[5];
/*
        try{
            //Lanzamos el proceso 5 veces, una por vocal y sin esperar.
            for (int i = 0; i < 5; i++) {
                ProcessBuilder pb = construirBuilderCuentaCaracteres(vocales[i]);
                //Pillamos la entrada y salida estandar.
                pb.inheritIO();
                //Iniciamos los procesos.
                procesos[i] = pb.start();
            }
            //Esperamos a que terminen uno a uno.
            for (Process p:procesos) {
                p.waitFor();
            }
        } catch (IOException e) {
            System.out.println("Error durante la ejecución");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e) {
            System.out.println("Proceso interrumpido");
            System.out.println("--------------------");
            e.printStackTrace();
            System.exit(3);
        }*/
        //Escribimos el tiempo que ha tardado.
        System.out.println("El tiempo de ejecución ha sido de " + (System.currentTimeMillis()-tmpInicio));
    }

}

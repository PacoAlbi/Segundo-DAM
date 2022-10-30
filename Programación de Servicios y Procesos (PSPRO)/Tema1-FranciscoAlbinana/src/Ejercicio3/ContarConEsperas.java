package Ejercicio3;

import java.io.IOException;

public class ContarConEsperas {

    public static void main(String[] args) {
        //Tiempo en que empieza
        long tmpInicio = System.currentTimeMillis();
        char[] vocales = new char[]{'a','e','i','o','u'};
        //Array de procesos
        Process[] procesos = new Process[5];

        try{
            //Lanzamos el proceso 5 veces, una por vocal y sin esperar.
            for (int i = 0; i < 5; i++) {
                ProcessBuilder pb = abrirProcess(vocales[i]);
                //Pillamos la entrada y salida estandar.
                pb.inheritIO();
                //Iniciamos los procesos.
                procesos[i] = pb.start();
                //Esperamos a que termine uno antes de empezar el siguiente.
                procesos[i].waitFor();
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
        }
        //Escribimos el tiempo que ha tardado.
        System.out.println("El tiempo de ejecución ha sido de " + (System.currentTimeMillis()-tmpInicio));
    }

    public static ProcessBuilder abrirProcess (char vocal) {
        return new ProcessBuilder("java", "src/Resources/CuentaCaracteres.java", String.valueOf(vocal));
    }
}

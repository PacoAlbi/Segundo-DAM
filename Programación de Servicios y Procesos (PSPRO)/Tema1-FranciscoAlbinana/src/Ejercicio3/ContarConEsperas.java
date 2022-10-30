package Ejercicio3;

import java.io.IOException;

public class ContarConEsperas {

    /**
     * Precondiciones: No tiene.
     * Método Main de la clase ContarConEsperas que retrasa el comienzo de cada proceso a que termine el anterior.
     * Postcondiciones: No tiene.
     */
    public static void main(String[] args) {
        //Guardo el tiempo en que inicia el Programa.
        long tmpInicio = System.currentTimeMillis();
        //Creo un array de vocales para mandar a la clase CuentaCaracteres.
        char[] vocales = new char[]{'a', 'e', 'i', 'o', 'u'};
        //Creo un array de procesos para lanzarlos a la vez.
        Process[] procesos = new Process[5];
        try {
            //Con el for lanzamos los 5 procesos.
            for (int i = 0; i < 5; i++) {
                ProcessBuilder pb = abrirProcess(vocales[i]);
                //Redireccionamos la entrada y salida estandar.
                pb.inheritIO();
                //Iniciamos los procesos por cada vocal.
                procesos[i] = pb.start();
                //Esperamos a que termine uno antes de empezar el siguiente.
                procesos[i].waitFor();
            }
            //Controlo las posibles excepciones lanzadas.
        } catch (IOException e) {
            System.out.println("Error de entrada/salida");
            System.out.println("-----------------------");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e) {
            System.out.println("Proceso interrumpido");
            System.out.println("--------------------");
            e.printStackTrace();
            System.exit(3);
        }
        //Escribimos el tiempo que ha tardado.
        System.out.println("El tiempo de ejecución ha sido de " + (System.currentTimeMillis() - tmpInicio));
    }

    /**
     * Precondiciones: No tiene.
     * Método que crea un ProcessBuilder por cada vocal que le mando. Hace el código más legible.
     * @param vocal Recive un char con la vocal a buscar.
     * @return Devuelve un ProcessBuilder de la clase CuentaCaracteres.
     * Postcondiciones: No tiene.
     */
    public static ProcessBuilder abrirProcess(char vocal) {
        return new ProcessBuilder("java", "src/Resources/CuentaCaracteres.java", String.valueOf(vocal));
    }
}

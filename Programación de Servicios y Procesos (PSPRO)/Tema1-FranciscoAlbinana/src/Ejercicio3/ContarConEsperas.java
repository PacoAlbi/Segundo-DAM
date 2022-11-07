//Crea un programa que cuente las vocales de un fichero de texto que se adjunta a la tarea (fichero_texto.txt). Para ello crea una clase que lance la clase
// CuentaCaracteres.java (se adjunta a la tarea) 5 veces en paralelo, una por cada vocal. La clase CuentaCaracteres.java lee el carácter a contar por la línea de argumentos,
// por lo que habrá indicarle el carácter a buscar en el momento de construir el proceso. La salida de todos los procesos debe ser la salida estándar, la heredada por el padre.
//Realiza dos ejecuciones, una en la que cada proceso espere al anterior y otra en la que los procesos no se esperen entre sí. Cuenta la cantidad de milisegundos que
// transcurren entre los dos casos. ¿Hay alguna diferencia? Pon cada solución en dos clases distintas.

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

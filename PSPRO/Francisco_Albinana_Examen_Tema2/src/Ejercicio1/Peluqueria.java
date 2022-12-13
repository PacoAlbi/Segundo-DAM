package Ejercicio1;

import java.util.concurrent.Semaphore;

public class Peluqueria implements Runnable {

    //Atributos
    Semaphore barberos = new Semaphore(2);
    Semaphore sillas = new Semaphore(4);

    /**
     * Main del programa donde inicio la ejecución de los hilos.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Creo los clientes para la peliqueria.
        Peluqueria cliente = new Peluqueria();
        for (int i = 0; i < 10; i++) {
            //Le pongo nombre a los clientes.
            Thread hilo = new Thread(cliente, "Cliente " + (i + 1));
            System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
            try {
                //Tiempo que tarda el cliente en llegar a la peliquería.
                Thread.sleep((int) ((Math.random() * 4) + 1));
                //Miro el estado aquí a ver su esta esperando.
                System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
            } catch (InterruptedException e) {
                System.out.println("\033[31;1;4mError ya que el hilo " + Thread.currentThread().getName() + " ha sido interrumpido inesperadamente " + e.getMessage() + " causado por " + e.getCause() + "\033[0m" + System.lineSeparator());
            }
            //Inicio la ejecución de los hilos.
            hilo.start();
        }
    }

    /**
     * Método para coger las sillas
     */
    public void cogerSilla() {
        try {
            //Pillo una silla.
            sillas.acquire();
            System.out.printf("El hilo %s ha cogido silla y se ha sentado a esperar." + System.lineSeparator(), Thread.currentThread().getName());
            //Espero sentado.
            Thread.sleep((int) ((Math.random() * 4) + 1));
            System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
            //Cuando me vaya al barbero, libero la silla.
            sillas.release();
        } catch (InterruptedException e) {
            System.out.println("\033[31;1;4mError ya que el hilo " + Thread.currentThread().getName() + " ha sido interrumpido inesperadamente " + e.getMessage() + " causado por " + e.getCause() + "\033[0m" + System.lineSeparator());
        }
    }

    /**
     * Método que simula pillar al barbero.
     */
    public void cogerBarbero() {
        try {
            //Me siento en el barbero Comprobaré los estados antes y despues de adquirir sitio
            barberos.acquire();
            System.out.printf("El hilo %s está siendo atendido por el barbero." + System.lineSeparator(), Thread.currentThread().getName());
            System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
            //Tiempo de trabajo
            Thread.sleep((int) ((Math.random() * 4) + 1));
            System.out.printf("El hilo %s ha terminado y se va de la peluquería." + System.lineSeparator(), Thread.currentThread().getName());
            System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
            //Libero al barbero cuando termine.
            barberos.release();
        } catch (InterruptedException e) {
            System.out.println("\033[31;1;4mError ya que el hilo " + Thread.currentThread().getName() + " ha sido interrumpido inesperadamente " + e.getMessage() + " causado por " + e.getCause() + "\033[0m" + System.lineSeparator());
        }
    }

    /**
     * Método que implementa la ejecución de lo que hay que hacer para cada hilo.
     */
    public void run() {
        while (true) {
            if (sillas.availablePermits() > 0) {
                //Compruebo el estado antes y despues de coger silla.
                System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
                cogerSilla();
                System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
                if (barberos.availablePermits() > 0) {
                    cogerBarbero();
                    System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
                }
            } else {
                System.out.printf("El hilo %s no tenía silla y se ha marchado." + System.lineSeparator(), Thread.currentThread().getName());
                Thread.currentThread().interrupt();
                System.out.printf("El estado del hilo %s es %s." + System.lineSeparator(), Thread.currentThread().getName(), Thread.currentThread().getState());
            }
        }
    }
}

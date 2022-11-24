package Semaforos;

import java.util.concurrent.Semaphore;

public class CarniceriaCharcuteria implements Runnable {

    //Declaro los semáforos con los hilos permitidos para cada método.
    Semaphore semaforoCarne = new Semaphore(4);
    Semaphore semaforoEmbutido = new Semaphore(2);

    //Creo los hilos de un mismo objeto, los renombro e inicio.
    public static void main(String[] args) {
        CarniceriaCharcuteria cliente = new CarniceriaCharcuteria();
        for (int i = 0; i < 10; i++) {
            Thread hilo = new Thread(cliente, "Cliente " + (i+1));
            hilo.start();
        }
    }

    /**
     * Método que lo saco del run para que sea más legible, que luego hago independiente para cada hilo.
     */
    public void pedirVezCarniceria (){
        try {
            //Adquiero un permiso (un hilo).
            semaforoCarne.acquire();
            //Aviso que está en carnicería.
            System.out.println("El " + Thread.currentThread().getName() + " está siendo atendido en carnicería.");
            //Tiempo variable que es lo que tarda en comprar.
            Thread.sleep((int) (Math.random() * 10000));
            //Aviso que ha terminado.
            System.out.println("El " + Thread.currentThread().getName() + " ha terminado en carnicería.");
            //Devuelvo al semáforo el permiso.
            semaforoCarne.release();
            //Controlo las excepciones.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void perdirVezCharcuteria (){
        try {
            //Adquiero un permiso (un hilo).
            semaforoEmbutido.acquire();
            //Aviso que está en carnicería.
            System.out.println("El " + Thread.currentThread().getName() + " está siendo atendido en charcutería.");
            //Tiempo variable que es lo que tarda en comprar.
            Thread.sleep((int) (Math.random() * 10000));
            //Aviso que ha terminado.
            System.out.println("El " + Thread.currentThread().getName() + " ha terminado en charcutería.");
            //Devuelvo al semáforo el permiso.
            semaforoEmbutido.release();
            //Controlo las excepciones.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        //Para cada hilo, creo un booleano que controle si ha sido atendido.
        boolean carneOut = false;
        boolean embutidoOut = false;
        //Mientras que no seas atendido en ambos, no salgo del while.
        while (!carneOut || !embutidoOut) {
            //Pido permiso si hay y si no he sido atendido.
            if (semaforoCarne.availablePermits() > 0 && !carneOut) {
                //Voy a carnicería.
                pedirVezCarniceria();
                //Cambio el booleano porque ya he sido atendido.
                carneOut = true;
            }
            //Pido el siguiente permiso si hay y si no he sido atendido.
            if (semaforoEmbutido.availablePermits() > 0 && !embutidoOut){
                //Voy ahora a charcutería.
                perdirVezCharcuteria();
                //Cambio el booleano porque ya he sido atendido.
                embutidoOut = true;
            }
        }
    }
}

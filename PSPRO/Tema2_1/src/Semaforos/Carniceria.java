package Semaforos;

import java.util.concurrent.Semaphore;

public class Carniceria implements Runnable {

    Semaphore semaforo = new Semaphore(4);

    public static void main(String[] args) {
        Carniceria cliente = new Carniceria();
        for (int i = 0; i < 10; i++) {
            Thread Hilo = new Thread(cliente, "Cliente " + (i+1));
            Hilo.start();
        }
    }


    @Override
    public void run() {
        try {
            semaforo.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " está siendo atendido.");
            Thread.sleep((int) (Math.random() * 10000));
            System.out.println("El " + Thread.currentThread().getName() + " ha terminado.");
            semaforo.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

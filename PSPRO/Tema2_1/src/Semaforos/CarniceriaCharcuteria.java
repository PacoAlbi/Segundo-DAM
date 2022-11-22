package Semaforos;

import java.util.concurrent.Semaphore;

public class CarniceriaCharcuteria implements Runnable {

    Semaphore semaforoCarne = new Semaphore(4);
    Semaphore semaforoEmbutido = new Semaphore(2);

    public static void main(String[] args) {
        CarniceriaCharcuteria cliente = new CarniceriaCharcuteria();
        for (int i = 0; i < 10; i++) {
            Thread Hilo = new Thread(cliente, "Cliente " + (i+1));
            Hilo.start();
        }
    }

    public void pedirVezCarniceria (){
        try {
            semaforoCarne.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " está siendo atendido en carnicería.");
            Thread.sleep((int) (Math.random() * 10000));
            semaforoCarne.release();
            System.out.println("El " + Thread.currentThread().getName() + " ha terminado en carnicería.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void perdirVezCharcuteria (){
        try {
            semaforoEmbutido.acquire();
            System.out.println("El " + Thread.currentThread().getName() + " está siendo atendido en charcutería.");
            Thread.sleep((int) (Math.random() * 10000));
            semaforoEmbutido.release();
            System.out.println("El " + Thread.currentThread().getName() + " ha terminado en charcutería.");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            if (semaforoCarne.availablePermits() > 0)
                pedirVezCarniceria();
            else {
                perdirVezCharcuteria();
            }
            break;
        }

    }
}

package Filosofos;

public class Filosofos implements Runnable {

    boolean[] palillos = new boolean[5];

    public static void main(String[] args) {
        Filosofos filosofo = new Filosofos();
        for (int i = 0; i < 5; i++) {
            Thread hilo = new Thread (filosofo, "Filósofo " + (i));
            hilo.setPriority((int) (Math.random()*10)+1);
            hilo.start();
            System.out.println("Prioridad del " + hilo.getName() + " es " + hilo.getPriority());
        }
    }

    public synchronized void comer (){

    }

    @Override
    public void run() {
        boolean comido = false;
        while (!comido){
            comer();
            comido = true;
            Thread.currentThread().notifyAll();
        }
    }
}

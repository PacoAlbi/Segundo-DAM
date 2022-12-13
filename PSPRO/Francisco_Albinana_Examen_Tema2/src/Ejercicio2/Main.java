package Ejercicio2;

public class Main {

    //Atributos (Para cambiar el número de productores y consumidores de forma fácil.)
    private static final int TOTALPRODUCTORES = 4;
    private static final int TOTALCONSUMIDORES = 4;

    //Creo los hilos productores y consumidores con unos for por elegancia y corrección.
    public static void main(String[] args) {
        //Creo la hucha común que todos van a utilizar.
        Hucha hucha = new Hucha();
        Thread[] productores = new Thread[TOTALPRODUCTORES];
        Thread[] consumidores = new Thread[TOTALCONSUMIDORES];
        for (int i = 0; i < productores.length; i++) {
            productores[i] = new Thread(new Productor(hucha),"Productor " + (i+1));
            productores[i].start();
        }
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i] = new Thread(new Consumidor(hucha),"Consumidor " + (i+1));
            consumidores[i].start();
            consumidores[i].setPriority((int)((Math.random()*9)+1));
        }
    }
}
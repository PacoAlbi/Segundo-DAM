package Filosofos;

public class Palillos {

    int numPalillo;
    boolean ocupado;

    //Constructor.
    public Palillos(int x){
        numPalillo = x;
    }

    /**
     * Método para saber si un palillo está ocupado, y avisar para pillarlo.
     */
    public synchronized void usar(){
        if(ocupado){
            System.out.println("El palillo " + (numPalillo+1) + " está ocupado.");
        }else{
            ocupado = true;
            System.out.println("El palillo " + (numPalillo+1) + " acaba de ser cogido.");
        }
    }

    /**
     * Método para soltar un palillo.
     */
    public synchronized void dejar(){
        ocupado = false;
        System.out.println("El palillo " + (numPalillo+1) + " está libre.");
    }
}
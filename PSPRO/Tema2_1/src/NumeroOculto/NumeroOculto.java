package NumeroOculto ;

import java.util.ArrayList;
import java.util.List;

public class NumeroOculto extends Thread {
    private static int numeroOculto;
    private static boolean acertado = false;

    synchronized public static int propuestaNumero(int num){
         int resultado = 0;
         if (num == numeroOculto && !acertado){
             resultado = 1;
             acertado = true;
             System.out.println("Ha gando el hilo " + Thread.currentThread().getName());
             //Thread.currentThread().interrupt();
             //Interrumpir. O interrumpo aqui en este metodo, y uso while true, o interrumpo en el run, y uso while (res == 0) o mi booleano.
         }
         else if (acertado) {
             resultado = -1;
         }
        return resultado;
    }

    //Controlar la sincronización de los hilos, para que no acierten todos a la vez, que se ejecute uno cada vez
    @Override
    public void run (){
        int numero;
        int res;
        //Paramos para que el primero no tenga ventaja.
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage() + " causado por " + e.getCause());
        }
        //Comprobamos para ver qué hilo acierta. Mientras no cambie acertado, sigo probando.
        while (!acertado){
            numero = (int) (Math.random() * 101);
            System.out.println("El hilo " + currentThread().getName() + " ha sacado " + numero);
            res = propuestaNumero(numero);
            //Compruebo siempre a ver si acierta otro.
            if (res == -1){
                //Si ya acierta otro, paro.
                Thread.currentThread().interrupt();
                System.out.println("Este hilo a terminado fallando " + Thread.currentThread().getName());
            }
        }
        //Si ponemos una pausa, no siempre gana el 1. Probar.
    }

    public static void main(String[] args) {
        numeroOculto = (int) (Math.random() * 101);
        System.out.println("El número oculto es " + numeroOculto);
        List<NumeroOculto> listaHilos = new ArrayList<>();
        for (int i = 1; i <=10; i++) {
            listaHilos.add(new NumeroOculto());
            listaHilos.get(i-1).setName("Hilo " + (i));
        }
        for (NumeroOculto hilo: listaHilos) {
            hilo.start();
        }
    }
}

package NumeroOculto ;

public class NumeroOculto extends Thread {
    private static int numeroOculto;
    private static boolean acertado = false;

    public synchronized static int propuestaNumero(int num){
         int resultado = 0;
         if (num == numeroOculto){
             resultado = 1;
             acertado = true;
             interrupted();
             //Interrumpir. O interrumpo aqui en este metodo, y uso while true, o interrumpo en el run, y uso while (res == 0)
         }
         if (acertado) {
             resultado = -1;
             interrupted();
             //Interrumpir
         }
        return resultado;
    }

    //Controlar la sincronización de los hilos, para que no acierten todos a la vez, que se ejecute uno cada vez
    @Override
    public void run (){
        System.out.println("El hilo " + Thread.currentThread().getName() + " ha empezado.");
        int numero = (int) (Math.random() * 101);
        System.out.println("La propuesta del hilo " + this.getName() + " es " + numero);
        int res = propuestaNumero(numero);
        System.out.println("El resultado del hilo " + this.getName() + " es " + res);
        while (true){ // o while (true), pero hay que interrumpir
            numero = (int) (Math.random() * 101);
            res = propuestaNumero(numero);
            System.out.println("Ha gando el hilo " + Thread.currentThread().getName());
            //interrupted();
        }
        //Interrumpo en cualquier caso
        //Si ponemos una pausa, no siempre gana el 1. Probar.
    }

    public static void main(String[] args) {
        numeroOculto = (int) (Math.random() * 101);
        System.out.println("El número oculto es " + numeroOculto);
        for (int i = 1; i <= 10; i++) {
            new NumeroOculto().start();
        }
    }
}

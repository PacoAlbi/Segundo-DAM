package NumeroOculto ;

public class NumeroOculto extends Thread {
    private static int numeroOculto;
    private static boolean acertado = false;

    public synchronized static int propuestaNumero(int num){
         int resultado = 0;
         if (num == numeroOculto){
             resultado = 1;
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
        int numero = (int) (Math.random() * 101);
        int res = propuestaNumero(numero);
        while (res == 0){ // o while (true), pero hay que interrumpir
            numero = (int) (Math.random() * 101);
            res = propuestaNumero(numero);
        }
        //Interrumpo en cualquier caso
        //Si ponemos una pausa, no siempre gana el 1. Probar.
    }

    public static void main(String[] args) {
        numeroOculto = (int) (Math.random() * 101);

        for (int i = 1; i <= 10; i++) {
            new NumeroOculto().start();
        }


//
//        NumeroOculto hilo1 = new NumeroOculto();
//        NumeroOculto hilo2 = new NumeroOculto();
//        NumeroOculto hilo3 = new NumeroOculto();
//        NumeroOculto hilo4 = new NumeroOculto();
//        NumeroOculto hilo5 = new NumeroOculto();
//        NumeroOculto hilo6 = new NumeroOculto();
//        NumeroOculto hilo7 = new NumeroOculto();
//        NumeroOculto hilo8 = new NumeroOculto();
//        NumeroOculto hilo9 = new NumeroOculto();
//        NumeroOculto hilo10 = new NumeroOculto();
//
//        hiloPrincipal.start();
//        hilo1.start();
//        hilo2.start();
//        hilo3.start();
//        hilo4.start();
//        hilo5.start();
//        hilo6.start();
//        hilo7.start();
//        hilo8.start();
//        hilo9.start();
//        hilo10.start();

    }
}

package NumeroOculto ;

public class NumeroOculto extends Thread {
    private static int numeroOculto;
    private static int acertado = 0;
    public void generarNumeroOculto (){
        numeroOculto = (int) (Math.random() * 101);
    }

    public static int propuestaNumero(int num){
         int resultado = 0;
         if (num == numeroOculto){
             resultado = 1;
         } else {
             resultado = -1;
         }
        return resultado;
    }

    @Override
    public void run (){
        acertado = propuestaNumero((int) (Math.random() * 101));


    }

    public static void main(String[] args) {
        NumeroOculto hiloPrincipal = new NumeroOculto();
        hiloPrincipal.generarNumeroOculto();
        NumeroOculto hilo1 = new NumeroOculto();
        NumeroOculto hilo2 = new NumeroOculto();
        NumeroOculto hilo3 = new NumeroOculto();
        NumeroOculto hilo4 = new NumeroOculto();
        NumeroOculto hilo5 = new NumeroOculto();
        NumeroOculto hilo6 = new NumeroOculto();
        NumeroOculto hilo7 = new NumeroOculto();
        NumeroOculto hilo8 = new NumeroOculto();
        NumeroOculto hilo9 = new NumeroOculto();
        NumeroOculto hilo10 = new NumeroOculto();

        hiloPrincipal.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();
        hilo9.start();
        hilo10.start();

    }
}

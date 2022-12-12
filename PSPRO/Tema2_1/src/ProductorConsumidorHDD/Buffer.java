package ProductorConsumidorHDD;

/**
 * Clase intermedia entre unos y otros, también llamada monitor.
 */
public class Buffer {

    private char[] buffer;
    private int siguiente;
    private boolean estaVacia;
    private boolean estaLlena;

    public Buffer (){}
    public Buffer (int tamano){
        this.buffer = new char[tamano];
        this.siguiente = 0;
        this.estaVacia = true;
        this.estaLlena = false;
    }

    public synchronized char consumir (){
        //No podemos consumir mientras que no haya produccion
        while (this.estaVacia){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //le temos que quitar a siguiente un valor, porque si quiero consumir, me tengo que ir uno atras
        siguiente--;

        //En el caso de que siguiente se quede en 0, es que está vacia
        if (siguiente==0){
            this.estaVacia = true;
        }
        //si estamos consumiendo, es que no esta llena.
        this.estaLlena = false;
        //Y tenemos que notificar que hemos consumido, para que el productor pueda consumir
        notifyAll();
        //Ahora tenemos que devolver ese caracter
        return this.buffer[this.siguiente];
    }
    //AL ESTAR SINCRONIZADOS, NO SE VAN A PISAR ENTRE SI UNOS Y OTROS.
    public synchronized void producir (char c){
        //Vamos a producir, mientras el array este lleno (buffer lleno) le decimos que se espere, ya que no puede continuar hasta que alguien le consuma
        //Al consumidor luego le notificaremos que hemos hecho algo para el
        while (this.estaLlena){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //En la posicion siguiente (que al principio es 0) le metemos ese c, ese producto
        buffer[siguiente] = c;
        //aumentamos el productor
        siguiente++;

        //Tengo que decir que si ese siguiente es igual a la longitud del array, esta llena es true.
        if(siguiente == this.buffer.length){
            this.estaLlena = true;
        }
        //de forma implicita, si esta lleno, no esta vacio
        this.estaVacia = false;

        //Ahora notificamos que todos los que estan esperando pueden continuar, usamos el notifyAll, porque el notify es solo a uno, así avisamos a todos los consumidores posibles
        notifyAll();
    }

}

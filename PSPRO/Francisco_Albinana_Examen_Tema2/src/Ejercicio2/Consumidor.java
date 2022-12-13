package Ejercicio2;

/**
 * Clase consumidora, que va a coger dinero si hay, y a la que le tengo que pasar la hucha común.
 */
public class Consumidor implements Runnable {

    //Atributos
    private Hucha hucha;

    //Constructores
    public Consumidor(){}
    public Consumidor(Hucha consumir){
        this.hucha = consumir;
    }

    /**
     * Método run para cada consumidor, que debe coger una cantidad aleatoria cada cierto tiempo aleatorio.
     */
    @Override
    public void run() {
        //Dinero que voy a retirar.
        int dineroRetirado;
        //Para que nunca paren
        while (true){
            try {
                //Intervalo de tiempo aleatorio que tardan en retirar dinero.
                Thread.sleep((int)((Math.random()*280)+20));
                //Dinero retirado de la hucha (lo guardo en la variable temporal para mostrarlo luego)
                dineroRetirado = hucha.cogerDinero();
                //Indico cuanto he retirado.
                System.out.printf("El hilo %s ha cogido %d de dinero de la hucha." + System.lineSeparator(), Thread.currentThread().getName(), dineroRetirado);
            } catch (InterruptedException e) {
                System.out.println("\033[31;1;4mError ya que el hilo " + Thread.currentThread().getName() + " ha sido interrumpido inesperadamente " + e.getMessage() + " causado por " + e.getCause() + "\033[0m" + System.lineSeparator());
            }
        }
    }
}

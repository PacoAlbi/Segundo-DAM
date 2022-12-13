package Ejercicio2;

/**
 * Clase productora, que recolecta dinero y lo mete en la hucha.
 */
public class Productor implements Runnable {

    //Atributos
    private Hucha hucha;

    //Constructores.
    public Productor (){}
    public Productor (Hucha recolectado){
        this.hucha = recolectado;
    }

    /**
     * Método para cada productor, que pone una cantidad aleatoria de dinero en la hucha.
     */
    @Override
    public void run() {
        int dinero;
        //Para que no pare nunca
        while (true){
            //Cantidad a poner
            dinero = (int)((Math.random()*21)+4);
            //Lo pongo en la hucha
            hucha.ponerDinero(dinero);
            //Indico lo que se ha puesto y quien lo ha puesto.
            System.out.printf("El hilo %s pone %d de dinero en la hucha." + System.lineSeparator(), Thread.currentThread().getName(), dinero);
            try {
                //Sigo recolectando dinero un tiempo aleatorio para poner.
                Thread.sleep((int)((Math.random()*190)+10));
            } catch (InterruptedException e) {
                System.out.println("\033[31;1;4mError ya que el hilo " + Thread.currentThread().getName() + " ha sido interrumpido inesperadamente " + e.getMessage() + " causado por " + e.getCause() + "\033[0m" + System.lineSeparator());
            }
        }
    }
}

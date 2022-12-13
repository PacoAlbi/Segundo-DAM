package Ejercicio2;

public class Hucha {

    //Atributos que van a ser la cantidad de dinero total de la hucha, y el booleano que avisará a productores y consumidores si pueden coger o soltar.
    private int cantidad;
    private boolean huchaLlena = false;

    /**
     * Método para coger dinero de la hucha.
     * @return Devuelve un entero que es el dinero retirado.
     */
    public synchronized int cogerDinero() {
        int dineroCogido = (int) (((Math.random() * 30) + 10));
        while (!huchaLlena && dineroCogido>cantidad) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("\033[31;1;4mError ya que el hilo " + Thread.currentThread().getName() + " ha sido interrumpido inesperadamente " + e.getMessage() + " causado por " + e.getCause() + "\033[0m" + System.lineSeparator());
            }
        }
        huchaLlena = false;
        notifyAll();
        cantidad -= dineroCogido;
        return dineroCogido;
    }

    /**
     * Método para poner dinero en la hucha.
     * @param dinero Un entero que es el dinero depositado por los recolectores.
     */
    public synchronized void ponerDinero(int dinero) {
        while (huchaLlena) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("\033[31;1;4mError ya que el hilo " + Thread.currentThread().getName() + " ha sido interrumpido inesperadamente " + e.getMessage() + " causado por " + e.getCause() + "\033[0m" + System.lineSeparator());
            }
        }
        cantidad += dinero;
        huchaLlena = true;
        notifyAll();
    }
}
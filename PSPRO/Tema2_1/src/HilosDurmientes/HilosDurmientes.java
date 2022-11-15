package HilosDurmientes;

public class HilosDurmientes extends Thread {

    /**
     * Método run heredado de la clase Thread que tiene un bucle infinito que escribe el nombre por pantalla, y detiene la ejecución entre 1 y 10 segundos.
     */
    @Override
    public void run () {
        //Empiezo el bucle infinito.
        while (true) {
            //Imprimo los hilos por sus nombres.
            System.out.printf("Soy el bucle %s y estoy trabajando." + System.lineSeparator(), getName());
            try {
                //Programo una interrupción aleatoria de entre 1 y 10 segundos.
                Thread.sleep((long)(Math.random()*10000+1000));
                //Capturamos la excepción.
            } catch (InterruptedException e) {
                System.out.printf("Hilo %s interrumpido.", getName());
                return;
            }
        }
    }

    public static void main(String[] args) {
        //Creo los 5 hilos.
        HilosDurmientes Hilo1 = new HilosDurmientes();
        HilosDurmientes Hilo2 = new HilosDurmientes();
        HilosDurmientes Hilo3 = new HilosDurmientes();
        HilosDurmientes Hilo4 = new HilosDurmientes();
        HilosDurmientes Hilo5 = new HilosDurmientes();

        //Seteo sus nombres para escribirlos.
        Hilo1.setName("Paco");
        Hilo2.setName("Carmelo");
        Hilo3.setName("Pedro");
        Hilo4.setName("Eva");
        Hilo5.setName("Manu");

        //Iniciamos los 5 hilos.
        Hilo1.start();
        Hilo2.start();
        Hilo3.start();
        Hilo4.start();
        Hilo5.start();
    }
}
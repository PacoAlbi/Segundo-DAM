//RESPUESTAS A LAS PREGUNTAS DE TEORÍA

//Ponerle una prioridad ayuda, pero según la teoría el sistema operativo lo toma más que nada como sugerencia, supongo que no ayudará,mucho.
//Para evitar interbloqueo, prefiero hacer métodos sincronizados en los puntos calientes, como son siempre la toma de palillos.
//No he averiguado como depurar multihilo con IntelliJ, en cuanto lo averigue explico cómo hacerlo...


package Filosofos;

public class Filosofos implements Runnable {

    private Thread filosofo;
    private static Cena cena = new Cena();
    private int palilloIzquierdo, palilloDerecho;
    private int comensal;

    /**
     * Hago un solo objeto Cena para que lo compartan entre todos los hilos.
     */
    public static void main(String args[]){
        for(int i = 0; i < 5; i++){
            Filosofos pensante = new Filosofos(i);
        }
    }

    //Constructor para iniciar los hilos.
    public Filosofos (int x){
        this.comensal = x;
        palilloIzquierdo = cena.palilloIzquierdo(comensal);
        palilloDerecho = cena.palilloDerecho(comensal);
        filosofo = new Thread(this);
        filosofo.setPriority((int)(Math.random()*10)); //No sé por qué me lanza una excepción que le da igual al ponerle las prioridades...
        filosofo.start();
    }

    /**
     * Método que pone al filósofo a pensar y hace una espera.
     */
    public void pensar(){
        try{
            System.out.println ("El filósofo " + (comensal+1) + " está filosofando.");
            filosofo.sleep((int)(Math.random()*1000));
        }catch(InterruptedException e){
            System.out.println("\033[31;1;4mError" + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }

    /**
     * Método que comprueba la disponibilidad de los palillos de cada filósofo, y le deja cogerlos si están libres.
     */
    public void cogerPalillos(){
        Palillos t1= cena.cogerPalillos(palilloIzquierdo);
        Palillos t2= cena.cogerPalillos(palilloDerecho);
        t1.usar();
        t2.usar();
    }

    /**
     * Método que pone al filósofo a comer si tiene palillos.
     */
    public void comer(){
        try{
            System.out.println("El filósofo " + (comensal+1) + " está comiendo.");
            filosofo.sleep((int)(Math.random()*2000));
            System.out.println("El filósofo " + (comensal+1) + " ha terminado de comer.");
        }catch(InterruptedException e){
            System.out.println("\033[31;1;4mError" + System.lineSeparator() + e.getMessage() + " causado por " + e.getCause() + "\033[0m");
        }
    }

    /**
     * Método para soltar los palillos.
     */
    protected void soltarPalillos(){
        Palillos t1= cena.cogerPalillos(palilloIzquierdo);
        Palillos t2= cena.cogerPalillos(palilloDerecho);
        t1.dejar();
        t2.dejar();
    }

    /**
     * Método run por hilo que hace todo el recorrido de los hilos.
     */
    public void run(){
        while(true){
            pensar();
            cogerPalillos();
            comer();
            soltarPalillos();
        }
    }
}
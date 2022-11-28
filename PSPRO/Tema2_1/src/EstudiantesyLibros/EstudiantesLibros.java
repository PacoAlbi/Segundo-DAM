package EstudiantesyLibros;

public class EstudiantesLibros implements Runnable {

    //Creo el array de booleanos para los libros, como si fuera la biblioteca. Es estática para que sea única para todos los estudiantes.
    public static boolean[] biblioteca = new boolean[9];

    public static void main(String[] args) {
        //Creo los estudiantes.
        EstudiantesLibros estudiante = new EstudiantesLibros();
        for (int i = 1; i <= 4; i++) {
            Thread hilo = new Thread(estudiante, "Estudiante " + (i));
            hilo.start();
        }
    }

    /**
     * Método para reservar los libros por estudiante, sincronizado para que reserven de 1 en 1.
     * @param libro1 Libro a reservar.
     * @param libro2 Libro a reservar.
     */
    public synchronized void reservarLibros (int libro1, int libro2) {
        //Intento pillar dos libros dentro del array.
        while (biblioteca[libro1] || biblioteca[libro2]) {
            try {
                //Mientras tenga los libros, pongo el hilo a esperar (los está usando).
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        //Pongo los libros a true si aún no los ha reservado.
        biblioteca[libro1] = true;
        biblioteca[libro2] = true;
    }

    /**
     * Esto te lo he tenido que mirar, porque me daba un error que no reconocía, y no se me ocurría sacarlo fuera... sorry...
     */
    public synchronized void devolverLibros (int libro1, int libro2) {
        biblioteca[libro1] = false;
        biblioteca[libro2] = false;
        this.notifyAll();
    }

    /**
     * Cada estudiante entra a reservar.
     */
    @Override
    public void run() {
        try {
            while (true) {
                //Elijo un par de libros al azar.
                int libro1 = ((int) (Math.random()*9));
                int libro2 = ((int) (Math.random()*9));
                //Si se repiten cambio de libro.
                while (libro1 == libro2) {
                    libro2 = ((int) (Math.random()*9));
                }
                //Reservo los libros.
                reservarLibros(libro1, libro2);
                System.out.println(Thread.currentThread().getName() + " ha reservado los libros " + (libro1+1) + " y " + (libro2+1) + ".");
                //Tiempo entre 3 y 5 segundos en leerlos.
                Thread.sleep((long)(Math.random()*3000), (int)(Math.random()*5000));
                System.out.println(Thread.currentThread().getName() + " ha devuelto los libros.");
                //Devuelvo los libros.
                devolverLibros(libro1, libro2);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
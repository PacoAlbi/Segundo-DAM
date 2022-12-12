package ProductorConsumidorHDD;

public class ProductorConsumidorHDD {

    /**
     * En este ejercicio, crea un contenedor para todos los productores y consumidores.
     */
    public static void main(String[] args) {
        //Según el número de productores y consumidores que haya, y el tamaño del buffer, se parará más o menos
        Buffer b = new Buffer(10);
        Productor p1 = new Productor(b);
        Productor p2 = new Productor(b);
        Productor p3 = new Productor(b);
        Productor p4 = new Productor(b);
        Productor p5 = new Productor(b);
        Consumidor c1 = new Consumidor(b);
        Consumidor c2 = new Consumidor(b);
        Consumidor c3= new Consumidor(b);
        Consumidor c4 = new Consumidor(b);
        Consumidor c5 = new Consumidor(b);
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}

package Ejercicio1_7;

public class Hilos {

    public static void main(String[] args) {
        Thread h = Thread.currentThread();
        System.out.println(h.getName());
        System.out.println(h.getState());
        System.out.println(h.getId() + "CON METODO DEPRECATED");
        System.out.println(h.threadId());
        System.out.println(h.isDaemon());
        System.out.println(h.getPriority());

        System.out.println("PRIORIDADES");
        System.out.println("PRIORIDAD MAXIMA: " + Thread.MAX_PRIORITY);
        System.out.println("PRIORIDAD MINIMA: " + Thread.MIN_PRIORITY);
        System.out.println("PRIORIDAD POR DEFECTO: " + Thread.NORM_PRIORITY);

        int ip1, ip2, ip3, ip4;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ip1= (int) (Math.random() * 255);
            ip2= (int) (Math.random() * 255);
            ip3= (int) (Math.random() * 255);
            ip4= (int) (Math.random() * 255);
            System.out.printf("%d.%d.%d.%d" + System.lineSeparator(), ip1,ip2,ip3,ip4);
        }
    }
}

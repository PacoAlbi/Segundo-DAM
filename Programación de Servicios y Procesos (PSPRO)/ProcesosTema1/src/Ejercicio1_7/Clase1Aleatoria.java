package Ejercicio1_7;

public class Clase1Aleatoria {

    public static void main(String[] args) {

        int ip1, ip2, ip3, ip4;

        for (int i = 0; i < 10; i++) {
            ip1= (int) (Math.random() * 255);
            ip2= (int) (Math.random() * 255);
            ip3= (int) (Math.random() * 255);
            ip4= (int) (Math.random() * 255);
            System.out.printf("%d.%d.%d.%d" + System.lineSeparator(), ip1,ip2,ip3,ip4);
        }
    }
}

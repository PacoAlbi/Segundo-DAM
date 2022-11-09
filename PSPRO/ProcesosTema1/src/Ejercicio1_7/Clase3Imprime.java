package Ejercicio1_7;

import java.util.Scanner;

public class Clase3Imprime {

    public static void main(String[] args) {

        String ip;
        int ip1;
        String [] primero;

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            ip = sc.nextLine();
            primero = ip.split("\\.");
            ip1 = Integer.parseInt(primero[0]);
            //ip1 = Integer.parseInt(ip.split("\\.")[0]);   Una forma de unir las dos sentencias de arriba en una sola.
            if (ip1 <= 127){
                System.out.printf("La ip %s es de clase A" + System.lineSeparator(),ip);
            } else if (ip1 <= 191) {
                System.out.printf("La ip %s es de clase B" + System.lineSeparator(),ip);
            } else {
                System.out.printf("La ip %s es de clase C" + System.lineSeparator(),ip);
            }
        }
        sc.close();
    }
}

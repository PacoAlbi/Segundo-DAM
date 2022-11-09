package Ejercicio1_7;

import java.util.Scanner;

public class Clase2ABC {

    public static void main(String[] args) {

        String ip;
        int ip1;
        String [] primero;

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            ip = sc.nextLine();
            primero = ip.split("\\.");
            ip1 = Integer.parseInt(primero[0]);

            if (ip1<=223){
                System.out.println(ip);
            }
        }
        sc.close();
    }
}

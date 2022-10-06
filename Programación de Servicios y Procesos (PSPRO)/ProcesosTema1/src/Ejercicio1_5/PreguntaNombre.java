package Ejercicio1_5;

import java.util.Scanner;

public class PreguntaNombre {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.printf("Hola %s", nombre);
        sc.close();
    }
}
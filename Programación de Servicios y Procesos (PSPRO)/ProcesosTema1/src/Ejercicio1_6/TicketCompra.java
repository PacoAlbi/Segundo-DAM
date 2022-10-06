package Ejercicio1_6;

import java.util.Scanner;

public class TicketCompra {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int codigo, cantidad;
        double precio, total;

        codigo = sc.nextInt();
        precio = sc.nextDouble();
        cantidad = sc.nextInt();
        total = precio * cantidad;

        System.out.printf("%d - %.2f - %d - %.2f" + System.lineSeparator(), codigo, precio, cantidad, total);
        sc.close();
    }
}

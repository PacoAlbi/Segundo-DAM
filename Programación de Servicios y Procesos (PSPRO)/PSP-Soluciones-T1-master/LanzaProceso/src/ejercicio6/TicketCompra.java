package ejercicio6;

import java.util.Scanner;

public class TicketCompra {

	public static void main(String[] args) {
		int codigo, cantidad;
		double precio, total;
		Scanner sc = new Scanner(System.in);
//		System.out.println("Introduzca el código de producto: ");
		codigo = sc.nextInt();
//		System.out.println("Introduzca el precio del producto: ");
		precio = sc.nextDouble();
//		System.out.println("Introduzca la cantidad del producto: ");
		cantidad = sc.nextInt();
		sc.close();
		total = precio*cantidad;
		
		System.out.println(codigo + " - " + precio + " - " + cantidad + " - " + total);
//		System.out.printf("%d - %.2f - %d - %.2f\n", codigo, precio, cantidad, total);
	}

}

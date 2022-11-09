package ejercicio5;

import java.util.Scanner;

public class PreguntaNombre {

	public static void main(String[] args) {
		String nombre;
		Scanner sc = new Scanner(System.in);
		
//		System.out.println("Introduzca su nombre: ");
		nombre = sc.nextLine();
		sc.close();
		System.out.println("¡Hola " + nombre + "!");
		

	}

}

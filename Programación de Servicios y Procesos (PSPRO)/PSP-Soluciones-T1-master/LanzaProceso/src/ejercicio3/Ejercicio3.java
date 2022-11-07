//Crea una clase Java que lance un proceso haciendo uso de la clase ProcessBuilder. En vez de tomar el comando por los argumentos del main,
// debe solicitarle al usuario por consola que introduzca el comando/programa a ejecutar.
//REDIRECCIÓN ENTRADA/SALIDA CON PROCESSBUILDER

//Partiendo del ejercicio 2, modifícalo para redireccionar la salida estándar del proceso a un fichero de texto llamado salidaProcesoLento.txt.

package ejercicio3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el comando a ejecutar: ");
		
		String[] comando = sc.nextLine().split(" ");
		
		ProcessBuilder pb = new ProcessBuilder(comando);
		
//		pb.directory(new File("D:\\Servicios\\LanzaProceso\\bin"));
		pb.inheritIO();
		sc.close();
		try {
			Process p = pb.start();
			p.waitFor();
			System.out.println("El proceso ha terminado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}

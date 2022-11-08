package Ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Esta clase lee una serie de líneas de la entrada estándar, las cuales están
 * compuestas por los apellidos y los nombres de un listado de alumnos. Estas
 * líneas tienen el formato: Apellido1 Apellido2, Nombre
 * A continuación, pinta por la salida estándar el mismo listado pero ordenado
 * por nombre en vez de por apellido. Además, pinta cada nombre con el siguiente
 * formato: Nombre Apellido1 Apellido2
 */
public class OrdenaNombres {

	public static void main(String[] args) {
		// Línea que contendrá los datos de un línea.
		// La voy a ir leyendo de la entrada estándar
		String linea;

		// Creo el Scanner para leer de la entrada estándar
		Scanner sc = new Scanner(System.in);
		List<String> lista = new ArrayList<>();
		String alumno;
		// Mientras haya líneas que leer seguiremos leyendo
		while (sc.hasNextLine()) {
			linea = sc.nextLine();
			alumno = linea.split(", ")[1];
			alumno += " " + linea.split(", ")[0];
			System.out.println(alumno);
		}
		sc.close();
	}
}

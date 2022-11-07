//Crea una clase Java llamada PreguntaNombre.java. Esta clase debe preguntarle al usuario su nombre, el cual debe introducirlo
// por la entrada estándar, e imprimir en la salida estándar “¡Hola nombre!”, donde nombre es el nombre introducido por teclado.
// Crea otra clase que se encargue de lanzar PreguntaNombre.java como un proceso. Además, redirecciona la entrada estándar para
// que se lea desde un fichero. La salida del proceso debe ser la estándar, es decir, la pantalla.

package ejercicio5;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class LanzaPreguntaNombre {

	public static void main(String[] args) {
		String[] comando = { "java", "ejercicio5.PreguntaNombre" };
		ProcessBuilder pb = new ProcessBuilder(comando);
		pb.directory(new File("D:\\Servicios\\LanzaProceso\\bin"));

		pb.redirectOutput(Redirect.INHERIT);
		pb.redirectInput(new File("D:\\Servicios\\LanzaProceso\\src\\ejercicio5\\entrada.txt"));
		
		try {
			Process p = pb.start();
			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

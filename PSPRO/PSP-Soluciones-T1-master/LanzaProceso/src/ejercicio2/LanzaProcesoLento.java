//Crea un programa que lance la clase ProcesoLento.Java (para ello, mete en el mismo paquete la clase ProcesoLento
// .java y la clase que vayas a crear). Utiliza el método isAlive() de la clase Process para comprobar si la clase ProcesoLento
// se sigue ejecutando e imprimir un mensaje indicando que el proceso sigue en ejecución. Esta comprobación debe hacerla cada 3
// segundos mientras esté en ejecución. Cuando ya no esté en ejecución debe terminar, para lo cual utiliza Thread.sleep(int tiempo_ms).



		package ejercicio2;

import java.io.File;
import java.io.IOException;

public class LanzaProcesoLento {

	public static void main(String[] args) {
		String[] comando = {"java", "ejercicio2.ProcesoLento"};
		
		ProcessBuilder pb = new ProcessBuilder(comando);
		pb.redirectOutput(new File("D:\\Servicios\\salida.txt"));
		
		pb.directory(new File("D:\\Servicios\\LanzaProceso\\bin"));
		//pb.inheritIO();
		try {
			Process p = pb.start();
			
			while(p.isAlive()) {
				System.out.println("Sigue en ejecución");
				Thread.sleep(3000);
			}
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

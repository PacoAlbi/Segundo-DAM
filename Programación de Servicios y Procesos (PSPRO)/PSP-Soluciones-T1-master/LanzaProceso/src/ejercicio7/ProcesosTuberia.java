//En este ejercicio vamos a lanzar varios procesos, cuyas entradas y salidas están enlazadas mediante tuberías. Para lo que usaremos el método startPipeline. Para ello, vamos a crear 3 clases distintas que serán los distintos procesos a lanzar:
//Clase 1: Va a generar 10 direcciones IP de forma aleatoria y las va a imprimir por la salida estándar.
//Clase 2: Va a leer 10 direcciones IP de teclado y va a imprimir por consola únicamente aquellas que pertenezcan a las clases A, B o C.
//Clase 3: Va a leer una serie de direcciones IP por teclado (no sabemos cuántas van a llegar) y va a imprimir por consola la dirección IP y a continuación la clase a la que pertenece.
//Tienes que crear una clase que lance estos tres procesos en el orden en el que se especifican, de forma que la salida estándar de uno sea la entrada estándar del siguiente. La salida estándar del último proceso debe ser un fichero de texto.
//CONSEJO: Establece para los tres procesos la salida de error estándar, para en caso de que haya algún error durante la ejecución, éste se pinte en la consola.
//REDIRECCIÓN A STREAMS DE LA CLASE PROCESS


package ejercicio7;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

public class ProcesosTuberia {

	public static void main(String[] args) {
		ProcessBuilder pb1 = new ProcessBuilder("java", "lanzaproceso.Proceso1");
//		pb1.inheritIO();
		ProcessBuilder pb2 = new ProcessBuilder("java", "lanzaproceso.Proceso2");
		ProcessBuilder pb3 = new ProcessBuilder("java", "lanzaproceso.Proceso3");
		pb1.directory(new File("D:\\Servicios\\LanzaProceso\\bin"));
		pb2.directory(new File("D:\\Servicios\\LanzaProceso\\bin"));
		pb3.directory(new File("D:\\Servicios\\LanzaProceso\\bin"));
//	
		List<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();
		lpb.add(pb1);
		lpb.add(pb2);
		lpb.add(pb3);
//		pb3.redirectOutput(Redirect.INHERIT);
		pb1.redirectError(Redirect.INHERIT);
		pb2.redirectError(Redirect.INHERIT);
		pb3.redirectError(Redirect.INHERIT);
		
		pb3.redirectOutput(new File("salida.txt"));
		try {
			List<Process> lProcess = ProcessBuilder.startPipeline(lpb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

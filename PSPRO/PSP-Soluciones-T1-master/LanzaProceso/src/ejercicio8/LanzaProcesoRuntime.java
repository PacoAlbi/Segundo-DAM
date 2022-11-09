//En este ejercicio vamos a lanzar varios procesos, cuyas entradas y salidas están enlazadas mediante tuberías. Para lo que usaremos el método startPipeline. Para ello, vamos a crear 3 clases distintas que serán los distintos procesos a lanzar:
//Clase 1: Va a generar 10 direcciones IP de forma aleatoria y las va a imprimir por la salida estándar.
//Clase 2: Va a leer 10 direcciones IP de teclado y va a imprimir por consola únicamente aquellas que pertenezcan a las clases A, B o C.
//Clase 3: Va a leer una serie de direcciones IP por teclado (no sabemos cuántas van a llegar) y va a imprimir por consola la dirección IP y a continuación la clase a la que pertenece.
//Tienes que crear una clase que lance estos tres procesos en el orden en el que se especifican, de forma que la salida estándar de uno sea la entrada estándar del siguiente. La salida estándar del último proceso debe ser un fichero de texto.
//CONSEJO: Establece para los tres procesos la salida de error estándar, para en caso de que haya algún error durante la ejecución, éste se pinte en la consola.
//REDIRECCIÓN A STREAMS DE LA CLASE PROCESS

package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LanzaProcesoRuntime {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		String[] comando = {"java", "-classpath", "D:\\Servicios\\LanzaProceso\\bin", "lanzaproceso.Proceso1"};
		
		try {
			Process p = r.exec(comando);
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"));
			
			String line = br.readLine();
			while(line!=null) {
				bw.write(line);
				bw.newLine();
				line = br.readLine();
			}
			bw.close();
			br.close();
			isr.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

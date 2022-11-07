//Realiza de nuevo el ejercicio 5, pero en vez de utilizar ProcessBuilder para lanzar la clase PreguntaNombre.java
// utiliza la clase Runtime. Utiliza el método getOutputStream() de la clase Process para que tome los datos de un fichero de texto,
// por ejemplo, entradaNombre.txt. Para poder ver la salida en la consola habrá que usar el método getInputStream() e imprimirlo por pantalla.

package ejercicio9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Ejercicio9 {

	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		String[] comando = { "java", "-classpath", "C:\\Users\\Elena\\git\\PSP-Soluciones-T1\\LanzaProceso\\bin", "ejercicio9.PreguntaNombre" };

		try {
			Process p = r.exec(comando);
			FileReader fr = new FileReader("C:\\Users\\Elena\\git\\PSP-Soluciones-T1\\LanzaProceso\\src\\ejercicio9\\entradaNombre.txt");
			BufferedReader br = new BufferedReader(fr);
			
			OutputStream os = p.getOutputStream();
			OutputStreamWriter osr = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osr);
			
			// Escribo en la entrada del proceso lo escrito en el fichero entradaNombre.txt
			String line = br.readLine();
			while(line!=null) {
				bw.write(line);
				bw.newLine();
				line = br.readLine();
			}
			
			bw.close();
			p.waitFor();
			InputStream is = p.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br2 = new BufferedReader(isr);
			
			String linea = br2.readLine();
			while(linea!=null) {
				System.out.println(linea);
				linea = br2.readLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

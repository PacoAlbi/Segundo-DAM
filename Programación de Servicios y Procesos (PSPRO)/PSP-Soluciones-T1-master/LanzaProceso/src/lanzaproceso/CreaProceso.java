package lanzaproceso;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class CreaProceso {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("java", "lanzaproceso.HolaMundo");
		pb.directory(new File("D:\\Servicios\\LanzaProceso\\bin"));
		System.out.println("Voy a lanzar el proceso");
		pb.inheritIO();
		
		Map<String,String> mapa = pb.environment();
		Set<String> claves = mapa.keySet();
		
		for(String clave : claves) {
			String valor = mapa.get(clave);
			System.out.println(clave + " = " + valor );
		}
		/*
		try {
			Process p = pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}

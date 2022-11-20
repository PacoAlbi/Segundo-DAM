package Sincronizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorHojasSync extends Thread {

	private static List<String> lista = new ArrayList<>();

	/**
	 * Cambio lo del interior del run() a un método fuera, synchronized, para que entren de uno en uno
	 * los 10 hilos que generan 10 textos cada uno.
	 */
	public static synchronized void escritorSincronizado(){
		//Uso una lista sincronizada, aunque si la quitas y usas una normal, también vale ya que el mismo método lo
		//sincroniza todo.
		List<String> listaSincronizada = Collections.synchronizedList(lista);
		for (int i = 0; i < 10; i++) {
			listaSincronizada.add("Texto" + i);
		}
		System.out.println("Separación de hilo"); //Esto para que yo lo vea bien.
		for (String string : listaSincronizada) {
			System.out.println(string);
		}
	}

	@Override
	public void run() {
		//Aquí llamo al método sincronizado ya, para que inicie los hilos.
		escritorSincronizado();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new GestorHojasSync().start();
		}
	}
}

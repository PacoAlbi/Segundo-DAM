package Sincronizacion;

import java.util.concurrent.CopyOnWriteArrayList;

public class GestorHojasPaco extends Thread {

	//private static List<String> lista = new ArrayList<String>();
	private static CopyOnWriteArrayList<String> lista = new CopyOnWriteArrayList();
	//private static ConcurrentHashMap<Integer, String> listaS = new ConcurrentHashMap<>();

	//Otra forma de intentar solucionar el problema, pero no me ha dado buenos resultados totales.
	@Override
	public void run() {
		//ConcurrentMap<Integer, String> listaS = new ConcurrentHashMap<>();

		for (int i = 0; i < 10; i++) {
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				System.out.println("Error: " + e.getMessage() + " causado por " + e.getCause());
//			}
			lista.add("Texto" + i);
			//lista.add("Texto" + i);
		}

		System.out.println("Separación de hilo");
		for (String string : lista) {

			System.out.println(string);
		}
		//listaS.clear();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new GestorHojasPaco().start();
		}

	}

}

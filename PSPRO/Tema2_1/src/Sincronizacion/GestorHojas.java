package Sincronizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorHojas extends Thread {

	private static List<String> lista = new ArrayList<>();
	private static List<String> listaSincronizada = Collections.synchronizedList(lista);

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			listaSincronizada.add("Texto" + i);
		}

		synchronized (listaSincronizada) {
			for (String string : listaSincronizada) {
				System.out.println(string);
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new GestorHojas().start();
		}

	}

}

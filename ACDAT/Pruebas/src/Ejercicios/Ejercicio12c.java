package Ejercicios;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Ejercicio12c {

    public static void main(String[] args) {
        ordenar();
    }

    public static void ordenar (){

        File archivoaLeer = new File("palabrasSeparadas.txt");
        File archovoaEscribir = new File("palabrasOrdenadas.txt");
        String palabra;

        ArrayList<String> lista = new ArrayList<>();

        try {
            RandomAccessFile leer = new RandomAccessFile(archivoaLeer, "r");
            RandomAccessFile escribir = new RandomAccessFile(archovoaEscribir, "rw");

            palabra = leer.readLine();
            while (palabra != null){

                lista.add(palabra);
                palabra = leer.readLine();

            }

            lista.sort(null);

            for (String s : lista) {
                escribir.writeUTF(s + System.lineSeparator());
            }

            System.out.println(lista);//compruebo la lista por si acaso

            leer.close();
            escribir.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

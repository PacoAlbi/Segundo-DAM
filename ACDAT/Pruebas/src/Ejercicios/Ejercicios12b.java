package Ejercicios;

import java.io.*;

public class Ejercicios12b {

    public static void main(String[] args) {
        lecturaSecuencial();
    }

    public static void lecturaSecuencial () {
        char[] palabra = new char[5];
        File fichero = new File("palabras.txt");
        File fichero2 = new File("palabrasSeparadas.txt");
        try {
            FileReader leer = new FileReader(fichero);
            FileWriter escribir = new FileWriter(fichero2);
            int i = 0;
            while (leer.read(palabra) != -1){
                if (i!=0) {
                    escribir.write("\n");
                }
                escribir.write(palabra);
                i++;
            }
            leer.close();
            escribir.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
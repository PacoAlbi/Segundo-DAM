package Ejercicio2;

import java.io.*;

/**
 * Precondiciones: El fichero debe estar ya creado.
 * Clase que cuenta las líneas de un documento de texto predefinido he imprime el total por pantalla.
 * Postcondiciones: No tiene.
 */
public class CuentaLineas {

    public static void main(String[] args) {
        //Creo los canales.
        FileReader fr = null;
        BufferedReader br = null;
        //Variable que guardará cada línea.
        String linea;
        //Variable para contar las líneas leídas.
        int contador = 0;
        try {
            //Abro el documento.
            fr = new FileReader(new File("src/Ejercicio2/numLineas.txt"));
            br = new BufferedReader(fr);
            //Leo una linea.
            linea = br.readLine();
            //Compruebo que no esté vacía.
            while (linea != null) {
                //Sumo uno si hay línea.
                contador++;
                //Leo otra línea.
                linea = br.readLine();
            }
            //Imprimo el resultado por pantalla.
            System.out.printf("El número total de líneas del documento son %d", contador);
            //Controlo las posibles excepciones lanzadas.
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
            System.out.println("---------------------");
            e.printStackTrace();
            System.exit(3);
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(2);
            //Ahora cierro los canales abiertos.
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
                //Controlo las posibles excepciones lanzadas.
            } catch (IOException e) {
                System.out.println("Error cerrando el buffer");
                System.out.println("------------------------");
                e.printStackTrace();
                System.exit(2);
            }
        }
    }
}

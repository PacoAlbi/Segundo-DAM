package Deivid;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ManejadoraFicheros {
    public static List<String> leerFichero () {
        String linea;
        List<String> texto = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("fichero.txt"))) {

            linea = br.readLine();
            while (linea != null) {
                texto.add(linea);
                linea = br.readLine();
            }

        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error leyendo el fichero.");
            e.printStackTrace();
        }
        return texto;
    }
    public static void escribirEnFichero(List<String> mensaje){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("fichero.txt"))){
            for (String linea:mensaje) {
                bw.write(linea);
                bw.newLine();
            }
        }catch (IOException e){
            System.err.println("Error leyendo el fichero.");
            e.printStackTrace();
        }
    }
}

package Clases;

import java.io.*;

public class GestionFicheros {

    String dir = "src\\caguilar\\";

    public void crearArbolDirectorios(String nombre){

        File d = new File(nombre);
        try {
            FileReader reader = new FileReader(d);

            BufferedReader br = new BufferedReader(reader);
            String linea;
            linea = br.readLine();
            while(linea!= null){
                File file = new File(dir+linea);
                file.mkdir();
                linea = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

import java.io.*;

public class Main {



    public static void main(String[] args) {

        String fichero = "Archivo/carpetas.txt";
        String ruta = "C:\\Users\\falbinana\\";

        File d = new File(fichero);

        try {
            FileReader leer = new FileReader(d);
            BufferedReader lectura = new BufferedReader(leer);

            String linea;
            linea = lectura.readLine();
            while(linea!= null){
                File file = new File(ruta+linea);
                file.mkdirs();
                linea = lectura.readLine();
            }

            lectura.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
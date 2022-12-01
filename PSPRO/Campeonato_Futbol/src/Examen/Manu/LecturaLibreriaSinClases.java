package Examen.Manu;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaLibreriaSinClases {

    public static void main(String[] args) {

        List<String> listaPersonas = new ArrayList<>();
        List<String> listaLibros = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/Examen/Libreria.txt"));
            String linea;
            boolean sonLibros = false;
            linea = br.readLine();

            while(linea != null){

                if(linea.equals("##")){
                    sonLibros = true;
                }

                if(!sonLibros){
                    listaPersonas.add(linea);
                }else{
                    if(!linea.equals("##")){
                        listaLibros.add(linea);
                    }

                }

                linea = br.readLine();
            }

            for (int i = 0; i < listaPersonas.size(); i++) {
                System.out.println(listaPersonas.get(i));
            }

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            for (int i = 0; i < listaLibros.size(); i++) {
                System.out.println(listaLibros.get(i));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Fichero libreria.txt no encontrado");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero libreria.txt");
        }
    }
}

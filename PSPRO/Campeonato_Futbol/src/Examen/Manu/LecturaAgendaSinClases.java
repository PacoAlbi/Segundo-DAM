package Examen.Manu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaAgendaSinClases {

    public static void main(String[] args) {

        List<String> listaNombres = new ArrayList<>();
        List<String> listaTelefonos = new ArrayList<>();

        try {
            File f = new File("personasConTelefono.txt");
            BufferedReader br = new BufferedReader(new FileReader("src/Examen/agenda.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(f));
            String linea,nombre,telefono,persona;
            linea = br.readLine();

            while(linea != null){
                if(isNumeric(linea)){
                    listaTelefonos.add(linea);
                }else{
                    listaNombres.add(linea);
                }
                linea = br.readLine();
            }

            for (int i = 0; i < listaNombres.size(); i++) {
                nombre = listaNombres.get(i);
                telefono = listaTelefonos.get(i);

                persona = nombre + " " + telefono;

                bw.write(persona);
                bw.newLine();


            }

            br.close();
            bw.close();

        } catch (FileNotFoundException e) {
            System.out.println("Fichero agenda.txt no encontrado");
        } catch (IOException e) {
            System.out.println("Error al leer el fichero agenda.txt");
        }
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}

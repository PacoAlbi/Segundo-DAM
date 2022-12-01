package DAL;

import Rondas.Equipo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LecturaFicheros {


    public ArrayList<Equipo> leerEquipos(){
        ArrayList<Equipo> equipos = new ArrayList<>();
        BufferedReader br;
        String linea;
        var contador = 0;
        try{
            br = new BufferedReader(new FileReader("src/Files/equipos.txt"));

            while((linea = br.readLine()) != null){
                equipos.add(new Equipo(linea));
                contador++;
            }

        } catch (IOException e) {
            System.err.printf("La cagaste %n");
        }
        System.err.printf("Hay %d equipos %n", contador);
        return equipos;
    }

}

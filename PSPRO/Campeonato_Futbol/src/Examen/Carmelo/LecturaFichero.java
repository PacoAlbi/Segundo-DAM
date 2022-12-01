package Examen.Carmelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class LecturaFichero {

    public static void main(String[] args) {
        LecturaFichero f = new LecturaFichero();

        ArrayList<clsPersona> personas = f.leerPersonas();

        ArrayList<clsLibro> libros = f.leerLibros();


        for (clsPersona p:personas
        ){
            System.out.println(p);
        }



        for(clsLibro l:libros){
            System.out.println(l);
        }
    }

    public ArrayList<clsPersona> leerPersonas(){

        ArrayList<clsPersona> personas = new ArrayList<>();
        BufferedReader br;
        String linea;
        try{
            br = new BufferedReader(new FileReader("src/Examen/Libreria.txt"));

            while(!(linea = br.readLine()).equals("##")){

                    var nombreApellidos = linea.split(" ");
                    personas.add(new clsPersona(nombreApellidos[0], nombreApellidos[1]));

            }

        } catch (IOException e) {
            System.err.printf("La cagaste %n");
        }
        return personas;
    }

    public ArrayList<clsLibro> leerLibros(){
        ArrayList<clsLibro> libros = new ArrayList<>();
        BufferedReader br;
        String linea;
        try{
            br = new BufferedReader(new FileReader("src/Examen/Libreria.txt"));

            while(!(linea = br.readLine()).equals("##")){

            }
            while((linea = br.readLine()) != null){

                libros.add(new clsLibro(linea));

            }
        } catch (IOException e) {
            System.err.printf("La cagaste %n");
        }
        return libros;
    }
}

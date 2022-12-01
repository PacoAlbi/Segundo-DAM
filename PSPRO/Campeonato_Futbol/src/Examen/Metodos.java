package Examen;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodos {

    public static void main(String[] args) {
        leerFichero();
        leerFicheroBuff();
    }

    public static List<Persona> leerFichero () {
        Scanner scanner;
        String linea;
        Persona nuevaPersona;
        List<Persona> lista = new ArrayList<>();
        try {
            scanner = new Scanner(new File("src/Examen/agenda.txt"));
            while (scanner.hasNextLine()){
                nuevaPersona = new Persona();
                linea = scanner.nextLine();
                nuevaPersona.setNombre(linea.split(" ")[0]);
                nuevaPersona.setApellido(linea.split(" ")[1]);
                linea = scanner.nextLine();
                nuevaPersona.setTelefono(linea);
                lista.add(nuevaPersona);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lista);
        return lista;
    }

    public static List<Persona> leerFicheroBuff () {
        FileReader fichero;
        BufferedReader br;
        String linea;
        Persona nuevaPersona;
        List<Persona> lista = new ArrayList<>();
        try {
            fichero = new FileReader("src/Examen/agenda.txt");
            br = new BufferedReader(fichero);
            while ((linea = br.readLine()) != null){
                nuevaPersona = new Persona();
                nuevaPersona.setNombre(linea.split(" ")[0]);
                nuevaPersona.setApellido(linea.split(" ")[1]);
                linea = br.readLine();
                nuevaPersona.setTelefono(linea);
                lista.add(nuevaPersona);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lista);
        return lista;
    }
}
package Ejercicio1_3;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String [] comandos;

        //String comando = sc.nextLine();

        String comando = JOptionPane.showInputDialog(System.in);

        comandos = comando.split(" ");


        ProcessBuilder pb = new ProcessBuilder(comandos);
        File directorio = new File("C:\\Users\\falbinana\\IdeaProjects\\ProcesosTema1\\src\\Ejercicios");
        pb.directory(directorio);
        pb.inheritIO();


        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

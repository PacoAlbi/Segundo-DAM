package Ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class Procesos {

    /**
     *
     */
    public static void crearCarpeta(){
        Scanner sc = new Scanner(System.in);
        String rutaCarpeta, nombreDirectorio;
        System.out.println("Escriba la ruta");
        rutaCarpeta = sc.nextLine();
        System.out.println("Escriba el nombre del directorio");
        nombreDirectorio = sc.nextLine();
        String[] comando = {"cmd","/C","mkdir " + rutaCarpeta + "\\" + nombreDirectorio};
        ProcessBuilder pb1 = new ProcessBuilder(comando);
        pb1.inheritIO();
        try{
            Process p1 = pb1.start();
            p1.waitFor();
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e) {
            System.out.println("Proceaso interrumpido");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(3);
        }
    }

    /**
     *
     */
    public static void crearFichero(){
        Scanner sc = new Scanner(System.in);
        String rutaCarpeta, nombreFichero;
        System.out.println("Escriba la ruta");
        rutaCarpeta = sc.nextLine();
        System.out.println("Escriba el nombre del fichero");
        nombreFichero = sc.nextLine();
        String[] comando= {"cmd","/C","type","nul",">",rutaCarpeta + "\\" + nombreFichero + ".txt"};
        ProcessBuilder pb2 = new ProcessBuilder(comando);
        pb2.inheritIO();
        try{
            Process p2 = pb2.start();
            p2.waitFor();
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(2);
        } catch (InterruptedException e) {
            System.out.println("Proceaso interrumpido");
            System.out.println("--------------------------");
            e.printStackTrace();
            System.exit(3);
        }
    }

    /**
     *
     */
    public static void mostrarContenido(){
        Scanner sc = new Scanner(System.in);
        String rutaCarpeta;
        System.out.println("Escriba la ruta");
        rutaCarpeta = sc.nextLine();
        if (rutaCarpeta.isEmpty()){
            System.out.println(System.getProperty("user.dir"));
        }else{
            String[] comando= {"cmd","/C","tree ",rutaCarpeta};
            ProcessBuilder pb3 = new ProcessBuilder(comando);
            pb3.inheritIO();
            try{
                Process p3 = pb3.start();
                p3.waitFor();
            } catch (IOException e) {
                System.out.println("Error de lectura/escritura");
                System.out.println("--------------------------");
                e.printStackTrace();
                System.exit(2);
            } catch (InterruptedException e) {
                System.out.println("Proceaso interrumpido");
                System.out.println("--------------------------");
                e.printStackTrace();
                System.exit(3);
            }
        }
    }
}
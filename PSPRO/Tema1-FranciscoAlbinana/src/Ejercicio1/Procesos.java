package Ejercicio1;

import java.io.IOException;
import java.util.Scanner;

public class Procesos {

    /**
     * Precondiciones: No tiene.
     * Método que mediante la consola de comandos crea un directorio en una ruta dada por el usuario.
     * Postcondiciones: No tiene.
     */
    public static void crearCarpeta(){
        //Abro mi lectura estandar.
        Scanner sc = new Scanner(System.in);
        //Variables para almacenar la ruta y el nombre del nuevo directorio.
        String rutaCarpeta, nombreDirectorio;
        //Pido la ruta y el nombre del directorio y los almaceno.
        System.out.println("Escriba la ruta");
        rutaCarpeta = sc.nextLine();
        System.out.println("Escriba el nombre del directorio");
        nombreDirectorio = sc.nextLine();
        //Preparo el comando para el proceso.
        String[] comando = {"cmd","/C","mkdir " + rutaCarpeta + "\\" + nombreDirectorio};
        //Creo el proceso.
        ProcessBuilder pb1 = new ProcessBuilder(comando);
        //Redireccionamos la entrada y salida estandar.
        pb1.inheritIO();
        try{
            //Lanzo el proceso y espero.
            Process p1 = pb1.start();
            p1.waitFor();
            //Controlo las posibles excepciones lanzadas.
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
     * Precondiciones: No tiene.
     * Método que mediante la consola de comandos crea un fichero en una ruta y con un nombre dados por el usuario.
     * Postcondiciones: No tiene.
     */
    public static void crearFichero(){
        //Abro mi lectura estandar.
        Scanner sc = new Scanner(System.in);
        //Variables para almacenar la ruta y el nombre del nuevo fichero.
        String rutaCarpeta, nombreFichero;
        //Pido la ruta y el nombre del fichero y los almaceno.
        System.out.println("Escriba la ruta");
        rutaCarpeta = sc.nextLine();
        System.out.println("Escriba el nombre del fichero");
        nombreFichero = sc.nextLine();
        //Preparo el comando para el proceso.
        String[] comando= {"cmd","/C","type","nul",">",rutaCarpeta + "\\" + nombreFichero + ".txt"};
        //Creo el proceso.
        ProcessBuilder pb2 = new ProcessBuilder(comando);
        //Redireccionamos la entrada y salida estandar.
        pb2.inheritIO();
        try{
            //Lanzo el proceso y espero.
            Process p2 = pb2.start();
            p2.waitFor();
            //Controlo las posibles excepciones lanzadas.
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
     * Precondiciones: No tiene.
     * Método que muestra un tree de la ruta introducida por el usuario, y si no, la ruta actual.
     * Postcondiciones: No tiene.
     */
    public static void mostrarContenido(){
        //Abro mi lectura estandar.
        Scanner sc = new Scanner(System.in);
        //Variable para almacenar la ruta.
        String rutaCarpeta;
        //Pido la ruta y la almaceno.
        System.out.println("Escriba la ruta");
        //Leo una línea.
        rutaCarpeta = sc.nextLine();
        //Compruebo que la línea no esté vacía.
        if (rutaCarpeta.isEmpty()){
            //Si está vacía imprimo la ruta actual de trabajo.
            System.out.println(System.getProperty("user.dir"));
        }else{
            //Si me han pasado una ruta, ejecuto el proceso.
            //Preparo el comando para el proceso.
            String[] comando= {"cmd","/C","tree ",rutaCarpeta};
            //Creo el proceso.
            ProcessBuilder pb3 = new ProcessBuilder(comando);
            //Redireccionamos la entrada y salida estandar.
            pb3.inheritIO();
            try{
                //Lanzo el proceso y espero.
                Process p3 = pb3.start();
                p3.waitFor();
                //Controlo las posibles excepciones lanzadas.
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
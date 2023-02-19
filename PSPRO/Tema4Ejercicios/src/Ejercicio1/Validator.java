package Ejercicio1;

import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;

/*
Una clase que se encargue de validar un usuario y una contraseña.
Al igual que la anterior, contendrá un método main y solicitará por teclado un usuario y una contraseña.
Debe comprobar que dicho usuario y contraseña se encuentran en el fichero y que se permite el acceso a la aplicación.
 */
public class Validator {
    /**
     * Precondiciones: No tiene.
     * Main que se encarga de validar un usuario y una contraseña preguntándolo por teclado y comprobando si son correctos.
     * Postcondiciones: Devuelve un mensaje según la validación.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Validación de usuario");
        System.out.println("Introduce tu nombre de usuario:");
        String nombre = sc.nextLine();
        System.out.println("Introduce la contraseña:");
        String password = sc.nextLine();
        if (validarUsuarioHash(nombre, password)) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado, usuario o contraseña incorrectos");
        }
    }
    /**
     * Precondiciones: Recibe un nombre de usuario y una contraseña.
     * Comprueba si el nombre de usuario y la contraseña son correctos sacados de un fichero llamado credenciales.cre
     * a través de un resumen de la contraseña en modo hexadecimal (tipo hash).
     * Postcondiciones: Devuelve true si el nombre de usuario y la contraseña son correctos, false en caso contrario.
     * @param nombre String Nombre de usuario
     * @param password String Contraseña
     * @return boolean validado
     */
    private static boolean validarUsuarioHash(String nombre, String password) {
        //Línea del fichero
        String linea;
        //Booleano que indica si el usuario y la contraseña son correctos
        boolean validado = false;
        try {
            //Paso la contraseña a resumen con el método getDigest de la clase Coder
            byte[] resumen = Coder.getDigest(password);
            //Paso el resumen a hexadecimal para poder compararlo con el resumen (hash) del fichero
            String passwordHash = String.format("%064x", new BigInteger(1, resumen));
            //Creo un BufferedReader para leer el fichero
            BufferedReader br = new BufferedReader(new FileReader("src/Ejercicio1/credenciales.cre"));
            //Leo la primera línea
            linea = br.readLine();
            //Mientras no sea null, leo el fichero
            while (linea != null) {
                //Si el nombre de usuario coincide con el nombre de usuario de la línea
                if (linea.split(";")[0].equals(nombre)) {
                    //Saco el resumen (hash) de la línea
                    String pass = linea.split(";")[2];
                    //Si el resumen (hash) de la línea coincide con el resumen (hash) de la contraseña
                    if (passwordHash.equals(pass)) {
                        //Validado pasa a true
                        validado = true;
                        //Salgo del bucle para que no tenga que recorrer el fichero completo si ya ha encontrado el usuario y la contraseña
                        break;
                    }
                }
                //Leo la siguiente línea
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de lectura");
            e.printStackTrace();
        }
        //Devuelvo el validado
        return validado;
    }

    private static boolean validarUsuarioResumen (String nombre, String password) {
        String linea;
        boolean validado = false;
        try {
            byte[] resumen = Coder.getDigest(password);
            BufferedReader br = new BufferedReader(new FileReader("src/Ejercicio1/credenciales.cre"));
            linea = br.readLine();
            while (linea != null) {
                if (linea.split(";")[0].equals(nombre)) {
                    byte[] pass = new byte[linea.split(";")[1].length()];
                    for (int i = 0; i < linea.split(";")[1].length(); i++) {
                        pass[i] = linea.split(";")[1].getBytes(linea)[i];
                    }
                    if (Coder.compararResumenes(resumen, pass)) {
                        validado = true;
                        break;
                    }
                }
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error de lectura");
            e.printStackTrace();
        }
        return validado;
    }

    public static class ReadBytesFromFile {
        public static void main(String[] args) {
            String fileName = "src/Ejercicio1/credenciales.cre";
            File file = new File(fileName);
            byte[] bytesArray = new byte[(int) file.length()];
            FileInputStream fis;
            try {
                fis = new FileInputStream(file);
                fis.read(bytesArray);
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Array de bytes del archivo " + fileName + " : " + bytesArray);
        }
    }
}
package Ejercicio1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/*
Una clase que se encargue de validar un usuario y una contraseña.
Al igual que la anterior, contendrá un método main y solicitará por teclado un usuario y una contraseña.
Debe comprobar que dicho usuario y contraseña se encuentran en el fichero y que se permite el acceso a la aplicación.
 */
public class Validator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Validación de usuario");
        System.out.println("Introduce tu nombre de usuario:");
        String nombre = sc.nextLine();
        System.out.println("Introduce la contraseña:");
        String password = sc.nextLine();
        if (validarUsuario(nombre, password)) {
            System.out.println("Acceso permitido");
        } else {
            System.out.println("Acceso denegado");
        }
    }

    private static boolean validarUsuario(String nombre, String password) {
        String linea;
        boolean validado = false;
        try {
            byte[] resumen = Coder.getDigest(password);
            String passwordHash = String.format("%064x", new BigInteger(1, resumen));
            BufferedReader br = new BufferedReader(new FileReader("src/Ejercicio1/credenciales.cre"));
            linea = br.readLine();
            while (linea != null) {
                if (linea.split(" ")[0].equals(nombre)) {
                    String pass = linea.split(" ")[2];
                    if (passwordHash.equals(pass)) {
                        validado = true;
                        break;
                    }
                }
                linea = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
        } catch (IOException e) {
            System.err.println("Error de lectura");
        }
        return validado;
    }
}
package Ejercicio1;
/*
Una clase que contenga un main que realice el registro del usuario.
Se encargará de pedir por teclado el usuario y la contraseña y almacenará en fichero el usuario y el resumen de la contraseña.
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Register {
    /**
     * Precondiciones: No tiene
     * Main que se encarga de registrar un usuario y su contraseña en el fichero credenciales.cre
     * Postcondiciones: Registra un usuario y su contraseña en el fichero credenciales.cre
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registro de usuario");
        System.out.println("Introduce el nombre de usuario:");
        String nombre = sc.nextLine();
        System.out.println("Introduce la contraseña:");
        String password = sc.nextLine();
        System.out.println("Introduce la contraseña de nuevo:");
        String password2 = sc.nextLine();
        if (password.equals(password2)) {
            byte[] resumen = Coder.getDigest(password);
            guardarCredenciales(nombre, resumen);
            System.out.println("Usuario registrado correctamente");
        } else {
            System.out.println("Las contraseñas no coinciden");
        }

    }

    /**
     * Precondiciones: Recibe un nombre de usuario y un resumen de contraseña
     * Guarda en el fichero credenciales.cre el nombre de usuario y el resumen de la contraseña
     * Postcondiciones: Guarda en el fichero credenciales.cre el nombre de usuario y el resumen de la contraseña
     * @param nombre String Nombre de usuario
     * @param resumen byte[] Resumen de la contraseña
     */
    private static void guardarCredenciales(String nombre, byte[] resumen) {
        String passwordHash = String.format("%064x", new BigInteger(1, resumen));
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ejercicio1/credenciales.cre", true));
            bw.write(nombre + " " + Arrays.toString(resumen) + " " + passwordHash);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.err.println("Error al registrar el usuario");
        }
    }
}
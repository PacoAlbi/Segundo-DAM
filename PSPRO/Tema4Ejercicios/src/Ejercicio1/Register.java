package Ejercicio1;
/*
Una clase que contenga un main que realice el registro del usuario.
Se encargará de pedir por teclado el usuario y la contraseña y almacenará en fichero el usuario y el resumen de la contraseña.
 */
import java.util.Scanner;

public class Register {
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
            Coder coder = new Coder();
            String passwordHash = coder.hash(password);
            Validator validator = new Validator();
            if (validator.validate(nombre, passwordHash)) {
                System.out.println("Usuario registrado correctamente");
            } else {
                System.out.println("Error al registrar el usuario");
            }
        } else {
            System.out.println("Las contraseñas no coinciden");
        }

    }
}
import Conxion.Conexion;
import Entities.*;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Conexion conexion = new Conexion();
        conexion.abrirConexion();
        Scanner scanner = new Scanner(System.in);
        Profesores alumno = new Profesores();
        System.out.println("Nombre:");
        alumno.setNombre(scanner.next());
        System.out.println("Ape1");
        alumno.setApe1(scanner.next());
        System.out.println("Ape2");
        alumno.setApe2(scanner.next());
        conexion.listarProfesorado();

        //conexion.guardar(alumno);
        conexion.cerrar();

    }
}

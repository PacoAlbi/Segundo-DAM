package Conecction;

import Entidades.Nave;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

public class DAONaves {
    /**
     * Precondiciones: No tiene.
     * Hace las preguntas para insertar una nueva nave productora y la manda a insertar.
     * Postcondiciones: No tiene.
     */
    public static void insertarNave() {
        Scanner sc = new Scanner(System.in);
        Nave nave = new Nave();
        System.out.println("Introduce el nombre del ganadero");
        nave.setGanadero(sc.nextLine());
        System.out.println("Introduce la ubicación de la nave");
        nave.setUbicacion(sc.nextLine());
        nave.setFechaCreacionRegistro(Timestamp.from(Instant.now()));
        Conexion.insertarNave(nave);
    }
    /**
     * Precondiciones: No tiene.
     * Recoge una nave por su identificador y la muestra por pantalla.
     * Postcondiciones: No tiene.
     */
    public static void getNave (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id de la nave");
        int id = sc.nextInt();
        Conexion.getOne("Naves","_id",id);
    }
    /**
     * Precondiciones: No tiene.
     * Actualiza el nombre del propietario de una nave.
     * Postcondiciones: No tiene.
     */
    public static void actualizarGanadero (){
        Scanner sc = new Scanner(System.in);
        System.out.println(Conexion.getListNaves());
        System.out.println("Introduce el id de la nave");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el nombre del nuevo propietario");
        String nombre = sc.nextLine();
        Conexion.modificarPropietario(id, nombre);
    }
    /**
     * Precondiciones: No tiene.
     * Elimina una nave por su identificador.
     * Postcondiciones: No tiene.
     */
    public static void eliminiarNave (){
        Scanner sc = new Scanner(System.in);
        System.out.println(Conexion.getListNaves());
        System.out.println("Introduce el id de la nave");
        int id = sc.nextInt();
        Conexion.borrarDocumento("Naves", "_id", id);
    }
}
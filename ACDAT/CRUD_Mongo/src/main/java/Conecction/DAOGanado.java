package Conecction;

import Entidades.Ganado;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

public class DAOGanado {
    /**
     * Precondiciones: No tiene.
     * Hace las preguntas para insertar una nueva vaca y la manda a insertar.
     * Postcondiciones: No tiene.
     */
    public static void insertarGanado() {
        Scanner sc = new Scanner(System.in);
        Ganado ganado = new Ganado();
        System.out.println("Introduce el nombre de la vaquiña");
        ganado.setNombre(sc.nextLine());
        System.out.println("Introduce la fecha de entrada en formato aaaa-mm-dd");
        ganado.setFechaEntrada(Date.valueOf(sc.nextLine()));
        System.out.println("Introduce el id de la nave");
        ganado.setIdNave(sc.nextInt());
        System.out.println("Introduce el id de la madre, 0 si no lo sabes");
        ganado.setIdMadre(sc.nextInt());
        ganado.setFechaCreacionRegistro(Timestamp.from(Instant.now()));
        Conexion.insertarGanado(ganado);
    }
    /**
     * Precondiciones: No tiene.
     * Recoge una vaca por su identificador y la muestra por pantalla.
     * Postcondiciones: No tiene.
     */
    public static void getVaca (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id de la vaca");
        int id = sc.nextInt();
        Conexion.getOne("Ganado","_id",id);
    }
    /**
     * Precondiciones: No tiene.
     * Actualiza el nombre de una vaca por su identificador.
     * Postcondiciones: No tiene.
     */
    public static void actualizarNombre (){
        Scanner sc = new Scanner(System.in);
        System.out.println(Conexion.getListGanado());
        System.out.println("Introduce el id de la vaca");
        int id = sc.nextInt();
        System.out.println("Introduce el nuevo nombre");
        String nombre = sc.next();
        Conexion.modificarNombreVaca(id, nombre);
    }
    /**
     * Precondiciones: No tiene.
     * Actualiza la nave de una vaca por su identificador.
     * Postcondiciones: No tiene.
     */
    public static void actualizarNave (){
        Scanner sc = new Scanner(System.in);
        System.out.println(Conexion.getListGanado());
        System.out.println("Introduce el id de la vaca");
        int id = sc.nextInt();
        System.out.println("Introduce el id de la nueva nave");
        int nave = sc.nextInt();
        Conexion.modificarNaveVaca(id, nave);
    }
    /**
     * Precondiciones: No tiene.
     * Actualiza la fecha de sacrificio de una vaca por su identificador.
     * Postcondiciones: No tiene.
     */
    public static void actualizarFechaSacrificio (){
        Scanner sc = new Scanner(System.in);
        System.out.println(Conexion.getListGanado());
        System.out.println("Introduce el id de la vaca");
        int id = sc.nextInt();
        System.out.println("Introduce la fecha de sacrificio en formato aaaa-mm-dd");
        String valor = sc.next();
        Conexion.modificarSacrificioVaca(id, valor);
    }
    /**
     * Precondiciones: No tiene.
     * Elimina una vaca por su identificador.
     * Postcondiciones: No tiene.
     */
    public static void eliminiarVaca (){
        Scanner sc = new Scanner(System.in);
        System.out.println(Conexion.getListGanado());
        System.out.println("Introduce el id de la vaca");
        int id = sc.nextInt();
        Conexion.borrarDocumento("Ganado", "_id", id);
    }
}
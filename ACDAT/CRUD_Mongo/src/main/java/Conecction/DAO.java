package Conecction;

import Entidades.Ganado;
import Entidades.Nave;
import Entidades.Produccion;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb").setLevel(Level.OFF);
        //Conexion.insertarGanado(new Ganado(Date.valueOf("2015-03-01"), "Felisa", 1, 1, Timestamp.from(Instant.now())));
        //Conexion.insertarNave(new Nave("Felix Bolaños", "Wilbur", Timestamp.from(Instant.now())));
        //Conexion.insertarProduccion(new Produccion(1, 10, 2017, 6, Timestamp.from(Instant.now())));
        //System.out.println(Conexion.getListGanado());
        //System.out.println(Conexion.getListNaves());
        //System.out.println(Conexion.getListProduccion());
        //insertarGanado();
        //Conexion.borrarDocumento("Ganado", "_id", 4);
        //Conexion.asignarNave(2,4);
    }

    public static void insertarGanado2() {
        Scanner sc = new Scanner(System.in);
        Ganado ganado = new Ganado();
        System.out.println("Introduce el nombre de la vaquiña");
        ganado.setNombre(sc.nextLine());
        System.out.println("Introduce la fecha de entrada en formato aaaa-mm-dd");
        ganado.setFechaEntrada(Date.valueOf(sc.nextLine()));
        System.out.println("Introduce la fecha de sacrificio");
        ganado.setFechaSacrificio(Date.valueOf(sc.nextLine()));
        System.out.println("Introduce el id de la nave");
        ganado.setIdNave(sc.nextInt());
        System.out.println("Introduce el id de la madre");
        ganado.setIdMadre(sc.nextInt());
        ganado.setFechaCreacionRegistro(Timestamp.from(Instant.now()));
        Conexion.insertarGanado(ganado);
    }

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

    public static void insertarProduccion() {
        Scanner sc = new Scanner(System.in);
        Produccion produccion = new Produccion();
        System.out.println("Introduce el id de la vaquiña");
        produccion.setIdVaca(sc.nextInt());
        System.out.println("Introduce el mes de producción");
        produccion.setMesProduccion(sc.nextInt());
        System.out.println("Introduce los litros producidos");
        produccion.setLitros(sc.nextInt());
        System.out.println("Introduce el año de producción");
        produccion.setAnoProduccion(sc.nextInt());
        produccion.setFechaCreacionRegistro(Timestamp.from(Instant.now()));
        Conexion.insertarProduccion(produccion);
    }
}
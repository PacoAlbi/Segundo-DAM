package Conecction;

import Entidades.Produccion;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

public class DAOProduccion {
    /**
     * Precondiciones: No tiene.
     * Hace las preguntas para insertar una nueva producción y la manda a insertar.
     * Postcondiciones: No tiene.
     */
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
    /**
     * Precondiciones: No tiene.
     * Imprime la producción en litros por vaca.
     * Postcondiciones: No tiene.
     */
    public static void produccionPorVaca() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el id de la vaquiña");
        int idVaca = sc.nextInt();
        Conexion.getProduccionPorVaca(idVaca);
    }
    /**
     * Precondiciones: No tiene.
     * Imprime la producción en litros por mes.
     * Postcondiciones: No tiene.
     */
    public static void produccionPorMes() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el mes de producción");
        int mes = sc.nextInt();
        Conexion.getProduccionPorMes(mes);
    }
    /**
     * Precondiciones: No tiene.
     * Imprime la producción en litros por año.
     * Postcondiciones: No tiene.
     */
    public static void produccionPorAnio() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el año de producción");
        int anio = sc.nextInt();
        Conexion.getProduccionPorAno(anio);
    }
}
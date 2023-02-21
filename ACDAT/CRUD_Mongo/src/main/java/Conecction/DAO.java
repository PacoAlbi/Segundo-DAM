package Conecction;

import Entidades.Ganado;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Scanner;

public class DAO {
    public static void main(String[] args) {
        insertarGanado();
    }

    public static void insertarGanado() {
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
}
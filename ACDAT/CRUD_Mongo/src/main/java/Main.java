import Conecction.Conexion;
import Entidades.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Utilidades.Menu.menuPrincipal;
public class Main {

    //    System.out.println("\033[31;1;4mEn Construcción\033[0m"); //Para poner el texto en rojo; negrita; subrayado por ese orden dentro de los ;
    //    System.out.println("\033[93;1;4mEn Construcción\033[0m"); //Amarillo
    //    System.out.println("\033[92;1;4mEn Construcción\033[0m"); //Verde
    //    System.out.println("\033[94;1;4mEn Construcción\033[0m"); //Azul

    public static void main(String[] args) {
        Logger.getLogger("org.mongodb").setLevel(Level.OFF);
        //Conexion.insertarGanado(new Ganado(Date.valueOf("2015-03-01"), "Felisa", 1, 1, Timestamp.from(Instant.now())));
        //Conexion.insertarNave(new Nave("Felix Bolaños", "Wilbur", Timestamp.from(Instant.now())));
        //Conexion.insertarProduccion(new Produccion(1, 10, 2017, 6, Timestamp.from(Instant.now())));
        menuPrincipal();
    }
}
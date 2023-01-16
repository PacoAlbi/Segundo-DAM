package InetAddress;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            //Para obtener la direccion IP a traves de un nombre
            InetAddress direccion=InetAddress.getByName("www.google.es");
            // Para que nos devuelva la direccion IP
            System.out.printf("Direccion IP: "+direccion.getHostAddress());

            System.out.println("");

            // Metodo para que devuelva a traves de un array de bytes la IP, Suelen salir numeros negativos
            // por ello no vamos a usarlo
            byte[] direccionIP=direccion.getAddress();
            System.out.printf(Arrays.toString(direccionIP));

            System.out.print("\nPara Obtener la direccion IP del lado del servidor");

            // Te devuelve la direccion local del servidor
            InetAddress local=InetAddress.getLocalHost();
            System.out.print(" Direccion IP local: " + local);




        } catch (UnknownHostException e) {
            System.err.println("Error: no se encuentra la direccion de Host");
        }
    }
}
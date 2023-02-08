package Ejercicio2Hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            //Variables de conexión
            int puertoServidor = 60000;
            ServerSocket socketServidor = new ServerSocket(puertoServidor);
            Socket peticionCliente;
            while (true) {
                //Queda a la espera de peticiones y las acepta cuando las recibe
                System.out.println("Esperando peticiones de clientes");
                peticionCliente = socketServidor.accept();
                System.out.println("(Servidor) conexión establecida...");
                new Gestor(peticionCliente).start();
            }
        } catch (IOException e) {
            System.err.println("Error en la creación del Socket Servidor");
            e.printStackTrace();
        }
    }
}
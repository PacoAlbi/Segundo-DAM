package Ejercicio1Hilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        //Variables de conexión
        int puertoCliente = 60000;
        DatagramSocket socket;
        DatagramPacket paqueteEntrada;
        //Creo el buffer
        byte[] buffer;
        try {
            //Creamos socket y le indicamos el puerto
            socket = new DatagramSocket(puertoCliente);
            while (true){
                //Queda a la espera de peticiones y las acepta cuando las recibe
                System.out.println("Esperando peticiones de clientes");
                //Creo el buffer
                buffer = new byte[64];
                //Creo el datagrama del servidor.
                paqueteEntrada = new DatagramPacket(buffer, buffer.length);
                //Recivo el paquete.
                socket.receive(paqueteEntrada);
                //Creo un hilo
                new Gestor(socket, paqueteEntrada).start();
            }
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error recibiendo el paquete");
            e.printStackTrace();
        }
    }
}
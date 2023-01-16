package Conexion_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Pasos Para Crear El Servidor
 */
public class ServidorTCP {
    public static void main(String[] args) {

        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor=new ServerSocket(50000);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el metodo
            System.out.println("Esperando peticiones");
            Socket socketCliente=socketServidor.accept();

            // 3.- Flujo de entrada y salida
            System.out.println("Abriendo flujos de entrada y salida");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 4.- Intercambiar datos con el cliente
            System.out.println("(Servidor) Leo el mensaje del cliente...");
            System.out.println("Mensaje del cliente "+ is.read());

            System.out.println("(Servidor) Envio el mensaje al cliente numero 7");
            os.write(7);

            // Cerramos los flujos de lectura y escritura
            is.close();
            os.close();

            // Cerramos la conexion
            socketServidor.close();
            socketCliente.close();

        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket en el puerto 50000");
        }

    }
}

package Conexion_TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteTCP {

    public static void main(String[] args) {

        try {
            // 1.- Creacion del Socket de tipo cliente
            System.out.println("(Cliente) Creacion del socket");
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),50000);
            // 2.- Abrir flujo de lectura y escritura de datos
            System.out.println("(Cliente) Abrimos flujos de lectura y escritura");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 3.- Intercambiar datos con el servidor
            System.out.println("(Cliente) Envia mensaje al servidor 14");
            os.write(14);

            System.out.println("(Cliente) Lectura del mensaje del Servidor");
            System.out.println("(Cliente) Mensaje recibido enviado por servidor "+ is.read());

            // 4.- Cerrar los flujos de lectura y escritura
            System.out.println("(Cliente) Cerramos la conexion");
            os.close();
            is.close();

            // 5.- Cerramos la conexion
            socketCliente.close();

        } catch (UnknownHostException e) {
            System.err.println("ERROR: error no se encuentra el Host");
        }catch (IOException e) {
            System.err.println("ERROR: Problema con la conexion");
        }


    }
}

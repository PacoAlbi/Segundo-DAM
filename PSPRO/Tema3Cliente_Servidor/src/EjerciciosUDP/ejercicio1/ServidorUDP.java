package EjerciciosUDP.ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServidorUDP {

    public static void main(String[] args) {

        try {

            System.out.println("Creacion del socket del servidor");
            DatagramSocket socket = new DatagramSocket(41500);

            System.out.println("Creacion del array de bytes");

            while (true) {
                byte[] buffer = new byte[64];

                System.out.println("Creacion del datagrama del servidor");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                System.out.println("A la espera de recibir datagrama");
                socket.receive(packet);

                System.out.println("Leemos el mensaje");
                String mensaje = "Hola " + new String(packet.getData()).trim() + " desde el servidor.";

                byte[] mensajeAEnviar = mensaje.getBytes();

                DatagramSocket socketEnviar = new DatagramSocket();

                DatagramPacket packetMensaje = new DatagramPacket(mensajeAEnviar, mensajeAEnviar.length,packet.getAddress(), packet.getPort());

                socketEnviar.send(packetMensaje);

            }


        } catch (SocketException e) {
            System.out.println("Error en la creacion del socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error en la recepcion del paquete");
            e.printStackTrace();
        }
    }
}

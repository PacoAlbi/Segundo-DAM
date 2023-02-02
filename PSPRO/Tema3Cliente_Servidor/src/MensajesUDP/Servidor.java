package MensajesUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        DatagramSocket socket;
        DatagramPacket packet;
        DatagramSocket socketEnviar;
        DatagramPacket packetMensaje;
        byte[] buffer;
        byte[] mensajeAEnviar;
        try {
            System.out.println("Creacion del socket del servidor");
            socket = new DatagramSocket(41500);
            while (true) {
                System.out.println("Creacion del array de bytes y renovación.");
                buffer = new byte[64];
                System.out.println("Creacion del datagrama del servidor");
                packet = new DatagramPacket(buffer, buffer.length);
                System.out.println("A la espera de recibir datagrama");
                socket.receive(packet);
                System.out.println("Leemos el mensaje");
                String mensaje = "Hola " + new String(packet.getData()).trim() + " desde el servidor.";
                mensajeAEnviar = mensaje.getBytes();
                socketEnviar = new DatagramSocket();
                packetMensaje = new DatagramPacket(mensajeAEnviar, mensajeAEnviar.length, packet.getAddress(), packet.getPort());
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
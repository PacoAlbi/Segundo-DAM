package MensajesUDP;

import java.io.IOException;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        InetAddress direccion;
        DatagramSocket socket;
        DatagramPacket packet;
        DatagramPacket packetRecibido;
        byte[] buffer;
        byte[] mensajeRecibido;
        String linea;
        try {
            direccion = InetAddress.getLocalHost();
            System.out.println("Creacion del socket del cliente");
            socket = new DatagramSocket();
            System.out.println("Introduce una cadena : ");
            for (int i = 0; i < 10000; i++) {
                linea = "Mensaje " + i;
                buffer = linea.getBytes();
                System.out.println("Creacion del datagrama del cliente");
                packet = new DatagramPacket(buffer, buffer.length, direccion, 41500);
                socket.send(packet);
                mensajeRecibido = new byte[64];
                packetRecibido = new DatagramPacket(mensajeRecibido, mensajeRecibido.length);
                socket.receive(packetRecibido);
                System.out.println("El valor de la cadena introducida es : " + new String(packetRecibido.getData()).trim());
            }
            linea = "Fin del mensaje";
            buffer = linea.getBytes();
            packet = new DatagramPacket(buffer, buffer.length, direccion, 41500);
            socket.send(packet);
            socket.close();
        } catch (SocketException e) {
            System.out.println("Error en la creacion del socket");
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Error al obtener la ip local");
        } catch (IOException e) {
            System.out.println("Error en el envio del paquete");
            e.printStackTrace();
        }
    }
}
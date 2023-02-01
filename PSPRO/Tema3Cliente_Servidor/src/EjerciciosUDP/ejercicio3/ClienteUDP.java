package EjerciciosUDP.ejercicio3;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClienteUDP {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try {
            InetAddress direccion = InetAddress.getLocalHost();
            System.out.println("Creacion del socket del cliente");
            DatagramSocket socket = new DatagramSocket();

            System.out.println("Introduce una cadena : ");
            byte[] buffer = sc.next().getBytes();

            System.out.println("Creacion del datagrama del cliente");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length,direccion,41500);

            socket.send(packet);

            byte[] mensajeRecibido = new byte[64];

            DatagramPacket packetRecibido = new DatagramPacket(mensajeRecibido, mensajeRecibido.length);

            socket.receive(packetRecibido);

            System.out.println("El valor de la cadena introducida es : " + new String(packetRecibido.getData()).trim());

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

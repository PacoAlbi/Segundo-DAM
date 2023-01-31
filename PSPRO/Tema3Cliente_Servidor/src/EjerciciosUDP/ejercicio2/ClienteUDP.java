package EjerciciosUDP.ejercicio2;

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
            System.out.println("Introduce la cadena 1 : ");
            byte[] bufferCadena1 = sc.next().getBytes();

            System.out.println("Introduce la cadena 2 : ");
            byte[] bufferCadena2 = sc.next().getBytes();

            System.out.println("Creacion del datagrama del cliente");
            DatagramPacket packet1 = new DatagramPacket(bufferCadena1, bufferCadena1.length,direccion,41500);
            DatagramPacket packet2 = new DatagramPacket(bufferCadena2, bufferCadena2.length,direccion,41500);

            socket.send(packet1);
            socket.send(packet2);

            byte[] buffer1Recibido = new byte[64];
            byte[] buffer2Recibido = new byte[64];
            DatagramPacket packet1Recibido = new DatagramPacket(buffer1Recibido, buffer1Recibido.length);
            DatagramPacket packet2Recibido = new DatagramPacket(buffer2Recibido, buffer2Recibido.length);

            socket.receive(packet1Recibido);
            socket.receive(packet2Recibido);

            socket.close();

            System.out.println(new String(packet1Recibido.getData()).trim());
            System.out.println(new String(packet2Recibido.getData()).trim());

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

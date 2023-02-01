package EjerciciosUDP.ejercicio3;

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
                String mensaje = new String(packet.getData()).trim();

                int sumaAscii = 0;

                for (int i = 0; i < mensaje.length(); i++) {

                    char caracter = mensaje.charAt(i);
                    int valorAscii = (int) caracter;
                    sumaAscii += valorAscii;
                }

                byte[] mensajeAEnviar = String.valueOf(sumaAscii).getBytes();

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

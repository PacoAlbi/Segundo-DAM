package MensajesUDP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    public static void main(String[] args) {
        //Creo las variables.
        DatagramSocket socket;
        DatagramPacket packet;
        BufferedWriter bufferedWriter;
        String mensaje;
        //Creo el buffer de lectura.
        byte[] buffer;
        try {
            System.out.println("Leyendo datos.");
            //Creo el socket de datagrama.
            socket = new DatagramSocket(60000);
            //Creo el buffer para el escribir el archivo.
            bufferedWriter = new BufferedWriter(new FileWriter("src/MensajesUDP/mensajeRecibido.txt"));
            //Inicio el servidor.
            while (true) {
                //Inicio el buffer de escritura.
                buffer = new byte[64];
                //Creo el datagrama del servidor.
                packet = new DatagramPacket(buffer, buffer.length);
                //Recivo el paquete.
                socket.receive(packet);
                //Saco los datos a una cadena.
                mensaje = new String(packet.getData()).trim();
                //Compruebo si es condición de salida.
                if (mensaje.equals("Fin")) break;
                //Escribo en el fichero los datos.
                bufferedWriter.write(mensaje.split(" ")[1]);
                //Bajo una línea.
                bufferedWriter.newLine();
            }
            //Cierro el buffer de escritura del fichero.
            bufferedWriter.close();
            System.out.println("Fin de la lectura.");
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error recibiendo el paquete");
            e.printStackTrace();
        }
    }
}
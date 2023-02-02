package MensajesUDP;

import java.io.IOException;
import java.net.*;

public class Cliente {

    //Creo las variables de clase.
    private static DatagramSocket socket;
    private static DatagramPacket packet;

    public static void main(String[] args) {
        //Creo las variables.
        InetAddress direccion;
        try {
            System.out.println("Empieza el programa.");
            //Pillo la dirección del cliente.
            direccion = InetAddress.getLocalHost();
            //Creo el socket de datagrama.
            socket = new DatagramSocket();
            //Creo el bucle.
            crearMensajes(direccion);
            System.out.println("Programa finalizado con éxito.");
            //Cierro la comunicación.
            socket.close();
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Error obteniendo ip local");
        }
    }
    /**
     * Precondiciones: Debe recibir una dirección a la que enviar los datos.
     * Método que genera los mensajes mediante un bucle y los manda.
     * Postcondiciones: No tiene.
     * @param direccion Dirección del Host tipo InetAddress
     */
    private static void crearMensajes (InetAddress direccion){
        String linea;
        //Creo el buffer de escritura.
        byte[] buffer;
        try {
            for (int i = 0; i < 10000; i++) {
                //Creo el mensaje.
                linea = "Mensaje: " + i;
                //Transformo los datos a bytes.
                buffer = linea.getBytes();
                //Creo el paquete para enviar.
                packet = new DatagramPacket(buffer, buffer.length, direccion, 60000);
                //Mando el paquete.
                socket.send(packet);
            }
            //Creo la última línea.
            linea = "Fin";
            //La transformo a bytes.
            buffer = linea.getBytes();
            //Creo el paquete para enviar.
            packet = new DatagramPacket(buffer, buffer.length, direccion, 60000);
            //Mando el paquete.
            socket.send(packet);
        } catch (IOException e) {
            System.out.println("Error enviando el paquete");
            e.printStackTrace();
        }
    }
}
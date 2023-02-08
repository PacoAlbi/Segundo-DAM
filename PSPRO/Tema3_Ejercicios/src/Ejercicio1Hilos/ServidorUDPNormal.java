package Ejercicio1Hilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Random;

public class ServidorUDPNormal {
    public static void main(String[] args) {
        //Creo el número secreto.
        int numeroSecreto = new Random().nextInt(0, 100);
        //Creo las variables.
        DatagramSocket socketEnviar;
        DatagramSocket socketRecibir;
        DatagramPacket packetEnviar;
        DatagramPacket packetRecibir;
        int puertoCliente = 60000;
        int numero;
        String mensaje;
        //Creo el buffer de lectura.
        byte[] buffer;
        try {
            System.out.println("Leyendo datos.");
            //Creo el socket de datagrama.
            socketRecibir = new DatagramSocket(puertoCliente);
            //Inicio el servidor.
            while (true) {
                //Inicio el buffer de escritura.
                buffer = new byte[64];
                //Creo el datagrama del servidor.
                packetRecibir = new DatagramPacket(buffer, buffer.length);
                //Recivo el paquete.
                socketRecibir.receive(packetRecibir);
                //Saco los datos a una cadena.
                numero = Integer.parseInt(new String(packetRecibir.getData()).trim());
                mensaje = acertarNumero(numero, numeroSecreto);
                //Creo el buffer
                byte[] mensajeAenviar = mensaje.getBytes();
                socketEnviar = new DatagramSocket();
                packetEnviar = new DatagramPacket(mensajeAenviar, mensajeAenviar.length,packetRecibir.getAddress(), packetRecibir.getPort());
                socketEnviar.send(packetEnviar);
                //Compruebo si es condición de salida.
                //if (mensaje.equals("Fin")) break;
            }
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error recibiendo el paquete");
            e.printStackTrace();
        }
    }
    /**
     * Método para comprobar si el número pasado es primo o no.
     * @param num Un entero que es el número a comprobar.
     * @param numeroSecreto Un entero que es el que hay que adivinar.
     * @return Un String con el resultado.
     */
    public static String acertarNumero (int num, int numeroSecreto) {
        String resultado;
        if (num == numeroSecreto) {
            resultado = "¡Enhorabuena! Has acertado el número";
        } else if (num < numeroSecreto) {
            resultado = "El número mandado es inferior al número secreto";
        } else {
            resultado = "El número mandado es superior al número secreto";
        }
        return resultado;
    }
}
package Ejercicio2;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    private static DatagramSocket socket;
    private static final String DIRECCION = "192.168.56.1";
    private static final int PUERTO = 45000;

    public static void main(String[] args) {
        String mensaje;
        DatagramPacket packet;
        byte[] bufferEntrada;
        try{
            socket = new DatagramSocket();
            leerCadena();
            bufferEntrada = new byte[128];
            packet = new DatagramPacket(bufferEntrada, bufferEntrada.length);
            socket.receive(packet);
            mensaje = new String(packet.getData()).trim();
            System.out.println(mensaje);
            socket.close();
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error recibiendo la respuesta");
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: No tiene.
     * Método que lee la cadena del teclado, y la manda al servidor para su comprobación.
     * Postcondiciones: No tiene.
     */
    private static void leerCadena (){
        String cadena;
        Scanner sc = new Scanner(System.in);
        System.out.println("\033[91;1;4mIntroduzca la cadena de 'CREATE numAlum nombreAlum' ó SELECT.\033[0m");
        cadena = sc.nextLine();
        byte[] buffer;
        try {
            buffer = cadena.getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(DIRECCION), PUERTO); //Cambiar despues, no olvidar
            socket.send(packet);
        } catch (UnknownHostException e) {
            System.out.println("Error servidor desconocido");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error enviando el paquete");
            e.printStackTrace();
        }
    }
}
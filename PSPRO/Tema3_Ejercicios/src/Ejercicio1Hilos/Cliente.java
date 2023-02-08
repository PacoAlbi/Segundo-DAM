package Ejercicio1Hilos;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    //Creo las variables de clase.
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Creo las variables.
        DatagramSocket socketEnviar;
        DatagramSocket socketRecibir;
        DatagramPacket packetEnviar;
        DatagramPacket packetRecibir;
        InetAddress direccion;
        int numero;
        String mensaje;
        int puertoServidor = 60000;
        //String nombreServidor = "localhost";??
        byte[] bufferEnviar;
        byte[] bufferRecivir;
        try {
            System.out.println("¡Averigua el número secreto!");
            //Pillo la dirección del cliente.
            direccion = InetAddress.getLocalHost();
            //Creo el socket de datagrama.
            socketEnviar = new DatagramSocket();
            socketRecibir = new DatagramSocket();
            do {
                System.out.println("Introduce un número");
                numero = sc.nextInt();
                bufferEnviar = String.valueOf(numero).getBytes();
                packetEnviar = new DatagramPacket(bufferEnviar, bufferEnviar.length, direccion, puertoServidor);
                socketEnviar.send(packetEnviar);
                bufferRecivir = new byte[64];
                packetRecibir = new DatagramPacket(bufferRecivir, bufferRecivir.length);
                socketRecibir.receive(packetRecibir);
                mensaje = new String(packetRecibir.getData());
                System.out.println(mensaje.trim());
            } while (!mensaje.equals("¡Enhorabuena! Has acertado el número"));
            System.out.println("Enhorabuena! has acertado el número.");
            //Cierro la comunicación.
            socketEnviar.close();
            socketRecibir.close();
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Error obteniendo ip local");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

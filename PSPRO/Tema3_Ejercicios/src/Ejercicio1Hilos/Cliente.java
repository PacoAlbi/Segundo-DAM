package Ejercicio1Hilos;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    //Creo las variables de clase.
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Creo las variables.
        DatagramSocket socket;
        DatagramPacket packetEnviar;
        DatagramPacket packetRecibir;
        InetAddress direccion;
        int puertoServidor = 60000;
        //Variables del programa
        int numero;
        String mensaje;
        //String nombreServidor = "localhost";?? ¿Necesario?
        //Creo los buffer
        byte[] buffer;
        try {
            System.out.println("¡Averigua el número secreto!");
            //Pillo la dirección del cliente.
            direccion = InetAddress.getLocalHost();
            //Creo el socket de datagrama.
            socket = new DatagramSocket();
            do {
                System.out.println("Introduce un número");
                //Leo el número
                numero = sc.nextInt();
                //Preparo el buffer para enviar
                buffer = String.valueOf(numero).getBytes();
                //Preparo el paquete
                packetEnviar = new DatagramPacket(buffer, buffer.length, direccion, puertoServidor);
                //Envío el paquete
                socket.send(packetEnviar);
                //Preparo el buffer para recibir
                buffer = new byte[64];
                //Preparo el paquete para recibir
                packetRecibir = new DatagramPacket(buffer, buffer.length);
                //Recibo el paquete
                socket.receive(packetRecibir);
                //Saco el mensaje
                mensaje = new String(packetRecibir.getData()).trim();
                //Imprimo el mensaje
                System.out.println(mensaje);
            } while (!mensaje.equals("¡Enhorabuena! Has acertado el número"));
            //Cierro la comunicación.
            socket.close();
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (UnknownHostException e) {
            System.out.println("Error obteniendo ip local");
        } catch (IOException e) {
            System.out.println("Error enviando datos.");
            e.printStackTrace();
        }
    }
}
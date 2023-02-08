package Ejercicio1Hilos;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

public class Gestor extends Thread {
    private DatagramSocket socketEntrada;
    private DatagramPacket paquete;
    public Gestor (DatagramSocket socket, DatagramPacket paquete){
        super();
        this.socketEntrada = socket;
        this.paquete = paquete;
    }
    @Override
    public void run() {
        realizarProceso();
    }
    public void realizarProceso (){
        //Creo el número secreto.
        int numeroSecreto = new Random().nextInt(0, 100);
        int numero = Integer.parseInt(new String(paquete.getData()).trim());
        String mensaje = acertarNumero(numero, numeroSecreto);
        byte[] mensajeEnviado = mensaje.getBytes();
        DatagramPacket paqueteSalida = new DatagramPacket(mensajeEnviado, mensajeEnviado.length,paquete.getAddress(),paquete.getPort());
        try {
            socketEntrada.send(paqueteSalida);
        } catch (IOException e) {
            System.out.println("Error enviando el paquete");
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
package Ejercicio3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        String peticion;
        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor = new ServerSocket(2000);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el método,
            // y lo hacemos en bucle infinito, porque es un servidor y no debe apagarse.
            while (true) {
                System.out.println("(Servidor) Esperando peticiones.");
                Socket socketCliente = socketServidor.accept();

                // 3.- Flujo de entrada y salida
                System.out.println("(Servidor) Abriendo flujos de entrada y salida.");
                InputStream is = socketCliente.getInputStream();
                OutputStream os = socketCliente.getOutputStream();

                // 4.- Intercambiar datos con el cliente
                InputStreamReader inputStream = new InputStreamReader(is, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStream);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                do {
                    peticion = aciertaNumero(bufferedReader.read());
                    bufferedWriter.write(peticion);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                } while (peticion != null);

                // Cerramos los flujos de lectura y escritura
                is.close();
                os.close();
                bufferedReader.close();
                bufferedWriter.close();
                outputStreamWriter.close();

                //Cierro la conexión solo con ese cliente concreto
                socketCliente.close();
            }
        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket en el puerto 2500.");
            e.printStackTrace();
        }
    }

    /**
     * Método para comprobar si el número pasado es primo o no.
     * @param num Un entero que es el número a comprobar.
     * @return Un String con el resultado.
     */
    public static String aciertaNumero (int num) {
        int numeroSecreto = new Random().nextInt(0,100);
        String resultado;
        if (num == numeroSecreto){
            resultado = String.format("¡Enhorabuena! Has acertado el número, era el %d", num);
        } else if (num < numeroSecreto) {
            resultado = String.format("El número %d es inferior al número secreto", num);
        } else {
            resultado = String.format("El número %d es superior al número secreto", num);
        }
        return  resultado;
    }
}
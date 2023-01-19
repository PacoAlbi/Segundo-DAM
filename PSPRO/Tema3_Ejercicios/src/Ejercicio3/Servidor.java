package Ejercicio3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Servidor {
    public static void main(String[] args) {
        String peticion;
        int numeroSecreto = new Random().nextInt(0, 100);
        int numero;
        Socket socketCliente;
        InputStream is;
        OutputStream os;
        InputStreamReader inputStream;
        BufferedReader bufferedReader;
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor = new ServerSocket(2000);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el método,
            // y lo hacemos en bucle infinito, porque es un servidor y no debe apagarse.
            while (true) {
                System.out.println("(Servidor) Esperando peticiones.");
                socketCliente = socketServidor.accept();

                // 3.- Flujo de entrada y salida
                System.out.println("(Servidor) Abriendo flujos de entrada y salida.");
                is = socketCliente.getInputStream();
                os = socketCliente.getOutputStream();

                // 4.- Intercambiar datos con el cliente
                inputStream = new InputStreamReader(is, StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(inputStream);
                outputStreamWriter = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                bufferedWriter = new BufferedWriter(outputStreamWriter);


                numero = bufferedReader.read();
                bufferedReader.reset();
                peticion = aciertaNumero(numero, numeroSecreto);
                bufferedWriter.write(peticion);
                bufferedWriter.newLine();
                bufferedWriter.flush();


                // Cerramos los flujos de lectura y escritura
                bufferedWriter.close();
                bufferedReader.close();
                outputStreamWriter.close();
                is.close();
                os.close();

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
     * @param numeroSecreto Un entero que es el que hay que adivinar.
     * @return Un String con el resultado.
     */
    public static String aciertaNumero(int num, int numeroSecreto) {
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
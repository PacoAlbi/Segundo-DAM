package Ejercicio4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int suma = 0, numero;
        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor = new ServerSocket(3000);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el método,
            // y lo hacemos en bucle infinito, porque es un servidor y no debe apagarse.
            while (true) {
                System.out.println("(Servidor) Esperando peticiones.");
                Socket socketCliente = socketServidor.accept();

                // 3.- Flujo de entrada y salida
                System.out.println("(Servidor) Abriendo flujos de entrada y salida.");
                InputStream is = socketCliente.getInputStream();
                OutputStream os = socketCliente.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                // 4.- Intercambiar datos con el cliente
                InputStreamReader inputStream = new InputStreamReader(is, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStream);


                numero = bufferedReader.read();
                suma += numero;

                bufferedWriter.write(suma);
                bufferedWriter.newLine();
                bufferedWriter.flush();

                // Cerramos los flujos de lectura y escritura
                is.close();
                os.close();
                bufferedReader.close();
                bufferedWriter.close();

                //Cierro la conexión solo con ese cliente concreto
                socketCliente.close();
            }
        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket en el puerto 2500.");
            e.printStackTrace();
        }
    }
}
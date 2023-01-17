package Ejercicio1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor = new ServerSocket(49200);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el metodo
            while (true) {
                System.out.println("Esperando peticiones");
                Socket socketCliente = socketServidor.accept();

                // 3.- Flujo de entrada y salida
                System.out.println("Abriendo flujos de entrada y salida");
                InputStream is = socketCliente.getInputStream();
                OutputStream os = socketCliente.getOutputStream();

                // 4.- Intercambiar datos con el cliente
                InputStreamReader inputStream = new InputStreamReader(is, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStream);
                //System.out.println("Mensaje enviado por el cliente: " + bufferedReader.readLine());

                int numero = bufferedReader.read();
                System.out.println(esPrimo(numero));

                System.out.println("Mensaje para el servidor");
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write("Soy el servidor. Este mensaje es para el cliente");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                // Cerramos los flujos de lectura y escritura
                is.close();
                os.close();
                bufferedWriter.close();
                bufferedReader.close();

                //Cierro la conexión solo con ese cliente concreto
                socketCliente.close();
            }
            // Cerramos la conexion
            // socketServidor.close();
            // socketCliente.close();

        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket en el puerto 50000");
        }
    }

    public static String esPrimo(int num) {
        String resultado = "Es primo";
        boolean encontrado = false;
        if (num <= 1)
            resultado = "No es primo";
        for (int i = 2; i <= num / 2 && !encontrado; i++) {
            if (num % i == 0) {
                resultado = "No es primo";
            }
        }
        return resultado;
    }
}

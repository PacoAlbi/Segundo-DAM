package Ejercicio1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor = new ServerSocket(2500);

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

                int numero = bufferedReader.read();
                System.out.println("(Servidor) " + esPrimo(numero));

                // Cerramos los flujos de lectura y escritura
                bufferedReader.close();
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
     * @return Un String con el resultado.
     */
    public static String esPrimo(int num) {
        String resultado = "Es primo.";
        boolean encontrado = false;
        if (num <= 1)
            resultado = "No es primo.";
        for (int i = 2; i <= num / 2 && !encontrado; i++) {
            if (num % i == 0) {
                resultado = "No es primo.";
            }
        }
        return resultado;
    }
}

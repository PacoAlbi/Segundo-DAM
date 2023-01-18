package Ejercicio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // 1.- Crear un Socket servidor.
            ServerSocket socketServidor = new ServerSocket(1500);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente.
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
                //System.out.println("Mensaje enviado por el cliente: " + bufferedReader.readLine());

                int numero = bufferedReader.read();

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(os, "UTF-8");
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(factorial(numero));
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
            System.err.println("ERROR: Error al crear el socket en el puerto 1500.");
            e.printStackTrace();
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
        System.out.println(factorial(num));
        return resultado;
    }

    public static int factorial(int num){
        int factorial;
        if(num == 0){
            factorial = 1;
        }
        else
            factorial = num * factorial(num-1);
        return factorial;
    }
}

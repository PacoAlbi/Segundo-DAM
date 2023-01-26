package Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Servidor {

    private static BufferedWriter bufferedWriter;
    private static String ruta;
    public static void main(String[] args) {
        File fichero = new File(ruta);
        String peticion;
        int numeroSecreto = new Random().nextInt(0, 100);
        int numero;
        Socket socketCliente;
        InputStream is;
        OutputStream os;
        InputStreamReader inputStream;
        BufferedReader bufferedReader;
        OutputStreamWriter outputStreamWriter;

        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor = new ServerSocket(2000);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el método,
            // y lo hacemos en bucle infinito, porque es un servidor y no debe apagarse.
            while (true) {
                System.out.println("(Servidor.Servidor) Esperando peticiones.");
                socketCliente = socketServidor.accept();

                // 3.- Flujo de entrada y salida
                System.out.println("(Servidor.Servidor) Abriendo flujos de entrada y salida.");
                is = socketCliente.getInputStream();
                os = socketCliente.getOutputStream();

                // 4.- Intercambiar datos con el cliente
                inputStream = new InputStreamReader(is, StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(inputStream);
                outputStreamWriter = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                do{
                    numero = Integer.parseInt(bufferedReader.readLine());
                    peticion = aciertaNumero(numero, numeroSecreto);
                    bufferedWriter.write(peticion);
                    bufferedWriter.newLine();
                    bufferedWriter.flush();
                }while (numero!=numeroSecreto);


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
            System.err.println("ERROR: Error al crear el socket en el puerto 2000.");
            e.printStackTrace();
        }
    }
    public static void leerFichero (String ruta) {
        File fichero = new File(ruta);
        String linea;
        try {
            FileReader lector = new FileReader(fichero);
            BufferedReader bufferLectura = new BufferedReader(lector);
            linea = bufferLectura.readLine();
            while (linea!=null){


                linea = bufferLectura.readLine();
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
package Servidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Servidor {

    //Atributos de clase para usar en el código.
    private static BufferedWriter bufferedWriter;
    private static String ruta;

    public static void main(String[] args) {
        Socket socketCliente;
        InputStream is;
        OutputStream os;
        InputStreamReader inputStreamReader;
        OutputStreamWriter outputStreamWriter;
        BufferedReader bufferedReader;
        try {
            //Crear un Socket servidor.
            ServerSocket socketServidor = new ServerSocket(2000);

            //Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el método,
            //y lo hacemos en bucle infinito, porque es un servidor y no debe apagarse.
            while (true) {
                System.out.println("(Servidor.Servidor) Esperando peticiones.");
                socketCliente = socketServidor.accept();

                //Flujo de entrada y salida.
                System.out.println("(Servidor.Servidor) Abriendo flujos de entrada y salida.");
                is = socketCliente.getInputStream();
                os = socketCliente.getOutputStream();

                //Intercambiar datos con el cliente.
                inputStreamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(inputStreamReader);
                outputStreamWriter = new OutputStreamWriter(os, StandardCharsets.UTF_8);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                //Leo la ruta del cliente.
                ruta = bufferedReader.readLine();
                leerFichero();

                //Cerramos los flujos de lectura y escritura.
                bufferedWriter.close();
                bufferedReader.close();
                outputStreamWriter.close();
                inputStreamReader.close();
                is.close();
                os.close();

                //Cierro la conexión solo con ese cliente concreto.
                socketCliente.close();
            }
        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket en el puerto 2000.");
            e.printStackTrace();
        }
    }
    /**
     * Método que carga el fichero, lo lee y lo manda directamente al cliente.
     */
    public static void leerFichero() {
        String linea;
        try {
            File fichero = new File(ruta);
            FileReader lector = new FileReader(fichero);
            BufferedReader bufferLectura = new BufferedReader(lector);
            linea = bufferLectura.readLine();
            while (linea != null) {
                bufferedWriter.write(linea);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                linea = bufferLectura.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error abriendo el archivo.");
            e.printStackTrace();
        }
    }
}
package lecturaEscrituraClienteServidor;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        try {
            // 1.- Crear un Socket servidor
            ServerSocket socketServidor=new ServerSocket(50000);

            // 2.- Espera y acepta conexiones, para ello creamos el socket cliente, ya que es lo que devuelve el metodo
            System.out.println("Esperando peticiones");
            Socket socketCliente=socketServidor.accept();

            // 3.- Flujo de entrada y salida
            System.out.println("Abriendo flujos de entrada y salida");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 4.- Intercambiar datos con el cliente
            InputStreamReader inputStream=new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStream);
            System.out.println("Mensaje enviado por el cliente:" + bufferedReader.readLine());

            System.out.println("Mensaje para el servidor");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os,"UTF-8");
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("Soy el servidor. Este mensaje es para el cliente");
            bufferedWriter.newLine();
            bufferedWriter.flush();

            // Cerramos los flujos de lectura y escritura
            is.close();
            os.close();
            bufferedWriter.close();
            bufferedReader.close();

            // Cerramos la conexion
            socketServidor.close();
            socketCliente.close();

        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket en el puerto 50000");
        }
    }
}

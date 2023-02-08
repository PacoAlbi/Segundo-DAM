package Ejercicio2Hilos;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServidorTCPNormal {
    public static void main(String[] args) {
        //Variables de conexión
        int puertoServidor = 60000;
        ServerSocket socketServidor;
        Socket socketCliente;
        //Variables de salida
        OutputStream outputStream;
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        //Variables de entrada
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        //Variables del programa
        BufferedReader lecturaFichero;
        String cadenaCliente;
        String cadenaFichero;
        String mensajeSalida = null;
        try {
            //
            socketServidor = new ServerSocket(puertoServidor);
            while (true){
                //Creo el socket
                System.out.println("Esperando peticiones de clientes");
                socketCliente = socketServidor.accept();
                //Preparo la lectura/entrada
                outputStream = socketCliente.getOutputStream();
                //Preparo el intercambio con el cliente
                outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                bufferedWriter = new BufferedWriter(outputStreamWriter);
                //Preparo la escritura/salida
                inputStream = socketCliente.getInputStream();
                //Preparo el intercambio con el cliente
                inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                bufferedReader = new BufferedReader(inputStreamReader);
                cadenaCliente = bufferedReader.readLine();
                //Preparo la lectura del fichero
                lecturaFichero = new BufferedReader(new FileReader("src/Ejercicio2Hilos/dnsCasero.txt"));
                cadenaFichero = lecturaFichero.readLine();
                while (cadenaFichero != null){
                    if (cadenaFichero.split(" ")[0].equals(cadenaCliente)){
                        mensajeSalida = "La ip de " + cadenaCliente + " es " + cadenaFichero.split(" ")[1];
                    } else {
                        mensajeSalida = "Lo sentimos, dirección web no registrada.";
                    }
                    cadenaFichero = lecturaFichero.readLine();
                }
                bufferedWriter.write(mensajeSalida);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                //Cerramos flujo de datos
                bufferedWriter.close();
                bufferedReader.close();
                outputStreamWriter.close();
                inputStreamReader.close();
                inputStream.close();
                outputStream.close();
                //Cierro la conexión solo con ese cliente concreto
                socketCliente.close();
            }
        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket de salida.");
            e.printStackTrace();
        }
    }
}
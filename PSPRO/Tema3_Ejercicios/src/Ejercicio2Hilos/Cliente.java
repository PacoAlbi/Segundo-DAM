package Ejercicio2Hilos;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        //Variables de conexión
        int puertoServidor = 60000;
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
        Scanner scanner = new Scanner(System.in);
        String cadena;
        try {
            //Creo el socket
            socketCliente = new Socket(InetAddress.getLocalHost(), puertoServidor);
            //Preparo la escritura/salida
            outputStream = socketCliente.getOutputStream();
            //Preparo el intercambio con el cliente
            outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            //Preparo la lectura/entrada
            inputStream = socketCliente.getInputStream();
            //Preparo el intercambio con el cliente
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            //Intercambio de datos
            System.out.println("Introduzca la dirección web");
            cadena = scanner.next();
            bufferedWriter.write(cadena);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            cadena = bufferedReader.readLine();
            System.out.println(cadena);
            System.out.println("\033[93;1;4mGracias por usar nuestro servidor DNS\033[0m");
            //Cerramos flujo de datos
            bufferedWriter.close();
            bufferedReader.close();
            outputStreamWriter.close();
            inputStreamReader.close();
            inputStream.close();
            outputStream.close();
            socketCliente.close();
        } catch (IOException e) {
            System.err.println("ERROR: Problema con la conexión.");
            e.printStackTrace();
        }
    }
}
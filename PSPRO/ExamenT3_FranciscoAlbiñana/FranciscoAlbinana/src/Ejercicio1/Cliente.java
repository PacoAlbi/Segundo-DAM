package Ejercicio1;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {
    //Variables de la clase
    private static final String DIRECCION = "172.26.0.1";
    private static final int PUERTO = 45000;

    public static void main(String[] args) {
        //Variables de conexión
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
            socketCliente = new Socket(DIRECCION, PUERTO);
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
            System.out.println("\033[91;1;4mIntroduzca la operación que desea realizar.\033[0m");
            System.out.println("\033[91;1;2mDebe tener el formato: num1;operación;num2.\033[0m");
            //Recojo la cadena con la operación
            cadena = scanner.nextLine();
            //Mando la cadena con la operación
            bufferedWriter.write(cadena);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            //Espero la respuesta
            cadena = bufferedReader.readLine();
            //Imprimo el mensaje
            System.out.println(cadena);
            System.out.println("\033[93;1;4mGracias por usar nuestra calculadora potente.\033[0m");
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
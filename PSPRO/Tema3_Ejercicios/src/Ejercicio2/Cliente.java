package Ejercicio2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        int numero;
        try {
            //1.- Creacion del Socket del tipo Cliente
            System.out.println("(Cliente) Creamos Socket");
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),1500);

            // 2.- Abrimos flujo de lectura y escritura
            System.out.println("(Cliente) Abrimos flujo de entrada y salida.");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 3.- Intercambiamos datos con el servidor
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

            numero = leerNumero();
            bufferedWriter.write(numero);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            InputStreamReader inputStreamReader=new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            System.out.printf("El factorial del número %d es %s", numero, bufferedReader.read());

            // 4.- cerramos flujo de datos
            bufferedWriter.close();
            bufferedReader.close();
            outputStreamWriter.close();
            inputStreamReader.close();
            is.close();
            os.close();

        } catch (IOException e) {
            System.err.println("ERROR: Problema con la conexión.");
            e.printStackTrace();
        }
    }

    /**
     * Método para leer un número del usuario y mandarlo al servidor para comprobaciones.
     * @return Devuelve un entero con el número si es válido.
     */
    public static int leerNumero (){
        int numero;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca un número.");
        numero = sc.nextInt();
        while (numero < 0){
            System.out.println("El número no puede ser negativo, perdone las molestias.");
            numero = sc.nextInt();
        }
        return numero;
    }
}

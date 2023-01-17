package Ejercicio4;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        int suma, numero;
        Scanner sc = new Scanner("numeros.txt");
        try {
            //1.- Creacion del Socket del tipo Cliente
            System.out.println("(Cliente) Creamos Socket");
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),3000);

            // 2.- Abrimos flujo de lectura y escritura
            System.out.println("(Cliente) Abrimos flujo de entrada y salida");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 3.- Intercambiamos datos con el servidor
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            InputStreamReader inputStreamReader=new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            numero = sc.nextInt();
            while (sc.hasNextLine()){
                bufferedWriter.write(numero);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                numero = sc.nextInt();
            }
            suma = bufferedReader.read();
            System.out.printf("La suma total de los números del fichero es %d", suma);

            // 4.- cerramos flujo de datos
            is.close();
            os.close();
            bufferedWriter.close();
            bufferedReader.close();
            outputStreamWriter.close();
            inputStreamReader.close();
            sc.close();

        } catch (IOException e) {
            System.err.println("ERROR: Problema con la conexión.");
            e.printStackTrace();
        }
    }
}

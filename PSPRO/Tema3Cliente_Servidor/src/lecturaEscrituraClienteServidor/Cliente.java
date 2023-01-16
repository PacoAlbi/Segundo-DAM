package lecturaEscrituraClienteServidor;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {


        try {
            //1.- Creacion del Socket del tipo Cliente
            System.out.println("(Cliente) Creamos Socket");
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),50000);

            // 2.- Abrimos flujo de lectura y escritura
            System.out.println("(Cliente) Abrimos flujo de entrada y salida");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 3.- Intercambiamos datos con el servidor
            System.out.println("(Cliente) ");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("Soy el Cliente. Este mensaje hace una peticion al servidor");
            bufferedWriter.newLine();
            bufferedWriter.flush();



            InputStreamReader inputStreamReader=new InputStreamReader(is,"UTF-8");
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            System.out.println("Mensaje enviado por el Servidor: " + bufferedReader.readLine());
            // 4.- cerramos flujo de datos
            bufferedWriter.close();
            is.close();
            os.close();
            bufferedWriter.close();
            bufferedReader.close();
            outputStreamWriter.close();
            inputStreamReader.close();


        } catch (IOException e) {
            System.err.println("ERROR: Problema con la conexion");
        }
    }



}

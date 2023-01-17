package Ejercicio2;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {


        try {
            //1.- Creacion del Socket del tipo Cliente
            System.out.println("(Cliente) Creamos Socket");
            //InetAddress dirección = InetAddress.getByName("Pongo la ip del que toque"); Para poner cualquier direccion
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),49200);

            // 2.- Abrimos flujo de lectura y escritura
            System.out.println("(Cliente) Abrimos flujo de entrada y salida");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 3.- Intercambiamos datos con el servidor
            System.out.println("(Cliente) ");
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);

            int numero = leerNumero();
            bufferedWriter.write(numero);
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
            e.printStackTrace();
        }
    }

    public static int leerNumero (){
        int numero;
        numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número"));
        while (numero <= 0){
            numero = Integer.parseInt(JOptionPane.showInputDialog("El número no puede ser negativo"));
        }
        return numero;
    }

}

package Ejercicio1;

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
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),2500);

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

            // 4.- cerramos flujo de datos
            bufferedWriter.close();
            outputStreamWriter.close();
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
        numero = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número."));
        while (numero <= 0){
            numero = Integer.parseInt(JOptionPane.showInputDialog("El número no puede ser negativo."));
        }
        return numero;
    }
}

package Cliente;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        String acertado;
        int numero;
        try {
            //1.- Creacion del Socket del tipo Cliente.Cliente
            System.out.println("(Cliente.Cliente) Creamos Socket");
            //InetAddress dirección = InetAddress.getByName("Pongo la ip del que toque"); Para poner cualquier direccion
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),2000);

            // 2.- Abrimos flujo de lectura y escritura
            System.out.println("(Cliente.Cliente) Abrimos flujo de entrada y salida");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            // 3.- Intercambiamos datos con el servidor
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            InputStreamReader inputStreamReader=new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            do {
                numero = leerNumero();
                bufferedWriter.write(String.valueOf(numero));
                bufferedWriter.flush();
                acertado =  bufferedReader.readLine();
                System.out.println("(Servidor.Servidor) " + acertado + " numero mandado: " + numero);
            } while (!(acertado.equals("¡Enhorabuena! Has acertado el número")));

            // 4.- cerramos flujo de datos
            bufferedWriter.close();
            bufferedReader.close();
            outputStreamWriter.close();
            inputStreamReader.close();
            is.close();
            os.close();
            socketCliente.close();

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
        while (numero < 0 || numero > 100){
            System.out.println("El número debe ser entre 0 y 100, ambos inclusive.");
            numero = sc.nextInt();
        }
        return numero;
    }
}

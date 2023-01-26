package Cliente;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cliente {

    //Atributos de clase para usar en el código.
    private static String ruta;
    private static String respuesta;
    private static BufferedReader bufferedReader;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            //Creacion del Socket del tipo Cliente.Cliente.
            System.out.println("(Cliente.Cliente) Creamos Socket");
            //InetAddress dirección = InetAddress.getByName("Pongo la ip del que toque"); Para poner cualquier direccion
            Socket socketCliente=new Socket(InetAddress.getLocalHost(),2000);

            //Abrimos flujo de lectura y escritura.
            System.out.println("(Cliente.Cliente) Abrimos flujo de entrada y salida");
            InputStream is=socketCliente.getInputStream();
            OutputStream os=socketCliente.getOutputStream();

            //Intercambiamos datos con el servidor.
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(os, StandardCharsets.UTF_8);
            BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
            InputStreamReader inputStreamReader=new InputStreamReader(is, StandardCharsets.UTF_8);
            bufferedReader=new BufferedReader(inputStreamReader);

            //Pido la ruta al usuario.
            System.out.println("Indique la ruta del fichero que desea leer");
            //Leo la ruta.
            ruta = scanner.nextLine();
            //Mando la ruta al servidor.
            bufferedWriter.write(ruta);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            //Recibo e imprimo la respuesta.
            escribirRespuesta();

            //cerramos flujo de datos.
            bufferedWriter.close();
            bufferedReader.close();
            outputStreamWriter.close();
            inputStreamReader.close();
            is.close();
            os.close();
            scanner.close();
            socketCliente.close();
        } catch (IOException e) {
            System.err.println("ERROR: Problema con la conexión.");
            e.printStackTrace();
        }
    }
    /**
     * Método que recibe la respuesta del servidor y la imprime por pantalla.
     */
    private static void escribirRespuesta (){
        try {
            //Leo una linea.
            respuesta = bufferedReader.readLine();
            while (respuesta!=null){
                //Escribo la respuesta.
                System.out.println(respuesta);
                //Leo una línea nueva.
                respuesta = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error abriendo el archivo.");
            e.printStackTrace();
        }
        System.out.println(System.lineSeparator() + "\033[93;1;4mFinalizada la lectura del texto.\033[0m");
        System.out.println("\033[93;1;4mGracias por usar nuestro servidor ^^.\033[0m");
    }
}
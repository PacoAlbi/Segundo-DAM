package Ejercicio2Hilos;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Gestor extends Thread {
    //Variables compartidas
    private Socket socket;
    private OutputStream outputStream;
    private InputStream inputStream;

    public Gestor (Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        realizarProceso();
    }
    /**
     * Precondiciones: No tiene.
     * Método que hace la conexión con el cliente y comprueba su petición.
     * Postcondiciones: No tiene.
     */
    public void realizarProceso (){
        //Variables de salida
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        //Variables de entrada
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        //Variables del programa
        String cadenaCliente;
        try {
            //Preparo la lectura/entrada
            outputStream = this.socket.getOutputStream();
            //Preparo el intercambio con el cliente
            outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            //Preparo la escritura/salida
            inputStream = this.socket.getInputStream();
            //Preparo el intercambio con el cliente
            inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);
            //Leo la petición
            cadenaCliente = bufferedReader.readLine();
            //Mando la respuesta
            bufferedWriter.write(comprobarCadenas(cadenaCliente));
            //Limpio el buffer
            bufferedWriter.newLine();
            bufferedWriter.flush();
            //Cerramos flujo de datos
            bufferedWriter.close();
            bufferedReader.close();
            outputStreamWriter.close();
            inputStreamReader.close();
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.err.println("Error, cliente desconectado.");
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir la cadena con la petición del cliente.
     * Función que recibe una cadena con la URL que el cliente quiere averiguar su ip
     * y devuelve una cadena con el mensaje de salida a través de una lectura de un
     * fichero que contiene las DNS.
     * Postcondiciones: Devuelve una cadena con la respuesta.
     * @param peticion String de entrada.
     * @return String de salida.
     */
    private String comprobarCadenas (String peticion){
        BufferedReader lecturaFichero;
        String mensajeSalida = null;
        String lectura;
        try {
            //Preparo la lectura del fichero
            lecturaFichero = new BufferedReader(new FileReader("src/Ejercicio2Hilos/dnsCasero.txt"));
            lectura = lecturaFichero.readLine();
            while (lectura != null){
                if (lectura.split(" ")[0].equals(peticion)){
                    mensajeSalida = "La ip de " + peticion + " es " + lectura.split(" ")[1];
                    break;
                } else {
                    mensajeSalida = "Lo sentimos, dirección web no registrada.";
                }
                lectura = lecturaFichero.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error, archivo no encontrado");
            e.printStackTrace();
        }
        return mensajeSalida;
    }
}
package Ejercicio1;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Hilo extends Thread {
    //Variables compartidas
    private final Socket SOCKET;
    public Hilo (Socket socket){
        this.SOCKET = socket;
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
    private void realizarProceso(){
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
            OutputStream outputStream = SOCKET.getOutputStream();
            //Preparo el intercambio con el cliente
            outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            //Preparo la escritura/salida
            InputStream inputStream = SOCKET.getInputStream();
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
     * Método que recibe la cadena del cliente y hace la operación según el operando.
     * Postcondiciones: Devuelve una cadena con la respuesta.
     * @param peticion String de entrada.
     * @return String de salida.
     */
    private String comprobarCadenas (String peticion){
        String mensajeSalida = null;
        try {
            int num1 = Integer.parseInt(peticion.split(";")[0]);
            String operacion = peticion.split(";")[1];
            int num2 = Integer.parseInt(peticion.split(";")[2]);
            switch (operacion){
                case "+": {
                    mensajeSalida = String.valueOf((num1 + num2));
                    break;
                }
                case "-": {
                    mensajeSalida = String.valueOf((num1 - num2));
                    break;
                }
                case "/": {
                    mensajeSalida = String.valueOf((num1 / num2));
                    break;
                }
                case "*": {
                    mensajeSalida = String.valueOf((num1 * num2));
                    break;
                }
                default: {
                    mensajeSalida = String.valueOf(0);
                }
            }
        } catch (NumberFormatException e){
            mensajeSalida = String.valueOf(0);
        } catch (ArithmeticException e ){
            mensajeSalida = String.valueOf(0);
        }
        return mensajeSalida;
    }
}
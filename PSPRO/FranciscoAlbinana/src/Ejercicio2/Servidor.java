package Ejercicio2;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Servidor {
    private static DatagramSocket socketEnviar;
    private static DatagramSocket socketRecibir;
    private static DatagramPacket packetEnviar;
    private static DatagramPacket packetRecibir;


    public static void main(String[] args) {
        //Creo las variables.
        int puertoCliente = 45000;
        String mensaje;
        byte[] buffer;
        try{
            socketRecibir = new DatagramSocket(puertoCliente);
            while (true){
                buffer = new byte[64];
                packetRecibir = new DatagramPacket(buffer, buffer.length);
                socketRecibir.receive(packetRecibir);
                mensaje = new String(packetRecibir.getData()).trim();
                comprobarFicher(mensaje);
            }
        } catch (SocketException e) {
            System.out.println("Error creando el socket");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ERROR al realizar la operación");
            e.printStackTrace();
        }
    }
    /**
     * Precondiciones: Debe recibir un String con la petición del cliente
     * Método para leer el mensaje del cliente, y según lo que ponga, hacer un create o un select y mandarle al cliente la respuesta.
     * Postcondiciones: No tiene.
     * @param mensaje
     * @return
     */
    private static String comprobarFicher (String mensaje){
        String respuesta = "";
        byte[] bufferSalida;
        try {
            BufferedReader lecturaFichero = new BufferedReader(new FileReader("src/Ejercicio2/alumnos.txt"));
            BufferedWriter escrituraFichero = new BufferedWriter(new FileWriter("src/Ejercicio2/alumnos.txt", true));
            //Compruebo el tipo de orden que me mandan.
            //Divido el mensaje según los separadores que he dicho y me quedo el primero, que es la orden
            //Compruebo si es create
            if (mensaje.split(" ")[0].equals("CREATE")){
                //Me quedo con el numero y el nombre y lo mando al fichero.
                escrituraFichero.write(mensaje.split(" ")[1] + " " + mensaje.split(" ")[2]);
                escrituraFichero.newLine();
                //Creo la respuesta al cliente
                respuesta = "Alumno introducido correctamente";
                //Preparo la respuesta
                bufferSalida = respuesta.getBytes();
                socketEnviar = new DatagramSocket();
                packetEnviar = new DatagramPacket(bufferSalida, bufferSalida.length, packetRecibir.getAddress(), packetRecibir.getPort());
                //Le mando la respuesta
                socketEnviar.send(packetEnviar);
            } else {
                //Si es select, leo el fichero
                String lecturaLinea;
                //Leo una línea
                lecturaLinea = lecturaFichero.readLine();
                //Mientras siga leyendo
                while (lecturaLinea!=null){
                    //Creo un string con todos los nombres
                    respuesta = respuesta + System.lineSeparator() + lecturaLinea;
                    lecturaLinea = lecturaFichero.readLine();
                }
                //Preparo el string completo
                bufferSalida = respuesta.getBytes();
                socketEnviar = new DatagramSocket();
                packetEnviar = new DatagramPacket(bufferSalida, bufferSalida.length, packetRecibir.getAddress(), packetRecibir.getPort());
                //Mando el string completo
                socketEnviar.send(packetEnviar);
            }
            escrituraFichero.close();
            lecturaFichero.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error escribiendo en el fichero");
            e.printStackTrace();
        }
        return respuesta;
    }
}
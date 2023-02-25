package Ejercicio3;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class Cifrar {

    public static void main(String[] args) {
        byte [] mensaje;
        byte [] mensajeCifradoPrivada;
        byte [] mensajeCifradoPublica;
        try {
            PrivateKey clavePrivadaEmisor = CertifadoEmisor.getClavePrivada();
            PublicKey clavePublicaReceptor = CertificadoReceptor.getClavePublica();
            Cipher cifradorReceptor = Cipher.getInstance("RSA");
            Cipher cifradorEmisor = Cipher.getInstance("RSA");
            cifradorReceptor.init(Cipher.ENCRYPT_MODE, clavePublicaReceptor);
            cifradorEmisor.init(Cipher.ENCRYPT_MODE, clavePrivadaEmisor);
            List<String> texto = leerFichero();
            for (String lista : texto) {
                mensaje = lista.getBytes(StandardCharsets.UTF_8);
                mensajeCifradoPrivada = cifradorEmisor.doFinal(mensaje);
                mensajeCifradoPublica = cifradorReceptor.doFinal(mensajeCifradoPrivada);
                guardarFichero(mensajeCifradoPublica);
            }
        } catch (NoSuchPaddingException e) {
            System.err.println("No existe el padding seleccionado");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("El tamaño del bloque utilizado no es correcto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El padding utilizado es erróneo");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("La clave introducida no es válida");
            e.printStackTrace();
        }
    }

    private static List<String> leerFichero () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero a cifrar: ");
        String ruta = sc.nextLine();
        String linea;
        List<String> texto = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            linea = br.readLine();
            while (linea != null) {
                texto.add(linea);
                linea = br.readLine();
            }
            br.close();
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error leyendo el fichero.");
            e.printStackTrace();
        }
        return texto;
    }

    private static void guardarFichero (byte [] mensajeCifrado){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("mensajeCifrado.txt", true));
            bw.write(Base64.getEncoder().encodeToString(mensajeCifrado));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.err.println("Error guardando el fichero.");
            e.printStackTrace();
        }
    }
}
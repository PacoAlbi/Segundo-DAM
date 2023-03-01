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
import java.util.Scanner;

public class Descifrar {

    public static void main(String[] args) {
        byte [] mensajeDescifradoReceptor;
        byte [] mensajeDescifradoEmisor;
        try {
            PrivateKey clavePrivadaReceptor = CertificadoReceptor.getClavePrivada();
            Cipher cifradorReceptor = Cipher.getInstance("RSA");
            cifradorReceptor.init(Cipher.DECRYPT_MODE, clavePrivadaReceptor);
            PublicKey clavePublicaEmisor = CertifadoEmisor.getClavePublica();
            Cipher cifradorEmisor = Cipher.getInstance("RSA");
            cifradorEmisor.init(Cipher.DECRYPT_MODE, clavePublicaEmisor);
            mensajeDescifradoReceptor = cifradorReceptor.doFinal(leerFichero().readAllBytes());
            mensajeDescifradoEmisor = cifradorEmisor.doFinal(mensajeDescifradoReceptor);
            System.out.println(new String(mensajeDescifradoEmisor, StandardCharsets.UTF_8));
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
        } catch (IOException e) {
            System.err.println("La clave introducida no es válida");
            e.printStackTrace();
        }
    }

    private static FileInputStream leerFichero (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero a descifrar: ");
        String ruta = sc.nextLine();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/Ejercicio3/mensajeCifrado.txt");
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
            e.printStackTrace();
        }
        return fileInputStream;
    }
}

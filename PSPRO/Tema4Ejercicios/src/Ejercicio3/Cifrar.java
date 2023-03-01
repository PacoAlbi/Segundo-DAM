package Ejercicio3;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class Cifrar {

    public static void main(String[] args) {
        byte [] mensajeCifradoPrivada;
        byte [] mensajeCifradoPublica;
        try {
            PrivateKey clavePrivadaEmisor = CertifadoEmisor.getClavePrivada();
            Cipher cifradorEmisor = Cipher.getInstance("RSA");
            cifradorEmisor.init(Cipher.ENCRYPT_MODE, clavePrivadaEmisor);
            PublicKey clavePublicaReceptor = CertificadoReceptor.getClavePublica();
            Cipher cifradorReceptor = Cipher.getInstance("RSA");
            cifradorReceptor.init(Cipher.ENCRYPT_MODE, clavePublicaReceptor);
            mensajeCifradoPrivada = cifradorEmisor.doFinal(leerFichero().readAllBytes());
            mensajeCifradoPublica = cifradorReceptor.doFinal(mensajeCifradoPrivada);
            guardarFichero(mensajeCifradoPublica);
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
            System.err.println("Error de lectura del fichero");
            e.printStackTrace();
        }
    }
    private static FileInputStream leerFichero (){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero a cifrar: ");
        String ruta = sc.nextLine();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(ruta);
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado");
            e.printStackTrace();
        }
        return fileInputStream;
    }

    private static void guardarFichero (byte [] mensajeCifrado){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src/Ejercicio3/mensajeCifrado.txt");
            fileOutputStream.write(mensajeCifrado);
            fileOutputStream.close();
        } catch (IOException e) {
            System.err.println("Error de escritura del fichero");
            e.printStackTrace();
        }
    }
}
package Ejercicio3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class CertificadoReceptor {

    //Variables finales con los nombres de los ficheros donde se guardan las claves
    private static final String FICHEROCLAVEPUBLICA = "publicKeyReceptor.key";
    private static final String FICHEROCLAVEPRIVADA = "privateKeyReceptor.key";
    /**
     * Método principal que genera las claves y las guarda en ficheros
     */
    public static void main(String[] args) {
        KeyPair claves = generarClaves();
        guardarClaves(claves);
    }

    /**
     * Método que genera las claves con el algoritmo RSA y el tamaño de 2048
     * @return KeyPair con las claves generadas
     */
    public static KeyPair generarClaves() {
        KeyPairGenerator generador;
        KeyPair claves = null;
        try {
            generador = KeyPairGenerator.getInstance("RSA");
            generador.initialize(4096);
            claves = generador.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        }
        return claves;
    }

    /**
     * Método que guarda las claves en ficheros
     * @param claves KeyPair con las claves a guardar
     */
    public static void guardarClaves(KeyPair claves) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(FICHEROCLAVEPUBLICA);
            fileOutputStream.write(claves.getPublic().getEncoded());
            fileOutputStream.close();
            fileOutputStream = new FileOutputStream(FICHEROCLAVEPRIVADA);
            fileOutputStream.write(claves.getPrivate().getEncoded());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encuentra el fichero.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Se ha producido un error durante la escritura en el fichero.");
            e.printStackTrace();
        }
    }

    /**
     * Método que lee la clave pública del fichero
     * @return PublicKey con la clave pública
     */
    public static PublicKey getClavePublica() {
        File ficheroClavePublica = new File(FICHEROCLAVEPUBLICA);
        PublicKey clavePublica = null;
        try {
            byte[] bytesClavePublica = Files.readAllBytes(ficheroClavePublica.toPath());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(bytesClavePublica);
            clavePublica = keyFactory.generatePublic(publicKeySpec);
        } catch (IOException e) {
            System.err.println("Se ha producido en la lectura del fichero");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            System.err.println("La clave indicada no es válida");
            e.printStackTrace();
        }
        return clavePublica;
    }

    /**
     * Método que lee la clave privada del fichero
     * @return PrivateKey con la clave privada
     */
    public static PrivateKey getClavePrivada() {
        File ficheroClavePrivada = new File(FICHEROCLAVEPRIVADA);
        PrivateKey clavePrivada = null;
        try {
            byte[] bytesClavePrivada = Files.readAllBytes(ficheroClavePrivada.toPath());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(bytesClavePrivada);
            clavePrivada = keyFactory.generatePrivate(privateKeySpec);
        } catch (IOException e) {
            System.err.println("Se ha producido en la lectura del fichero");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            System.err.println("La clave indicada no es válida");
            e.printStackTrace();
        }
        return clavePrivada;
    }
}
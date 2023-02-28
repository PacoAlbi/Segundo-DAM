package Deivid;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncriptarConClavePrivadaEmisor {

    public static void main(String[] args) {

        try {
            // Ciframos con la clave privada
            PrivateKey clavePrivada = KeysManager.getClavePrivada(KeysManager.PRIVATE_KEY_FILE_EMISOR);

            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, clavePrivada);
            List<String> mensajeAEscribir = new ArrayList<>();
            for ( String linea : ManejadoraFicheros.leerFichero()) {
                byte[] mensaje = linea.getBytes(StandardCharsets.UTF_8);
                // Se cifra el mensaje
                byte[] mensajeCifrado = cipher.doFinal(mensaje);
                // Lo añadimos en Base64
                mensajeAEscribir.add(Base64.getEncoder().encodeToString(mensajeCifrado));
            }
            // Escribimos el mensaje cifrado en el fichero
            ManejadoraFicheros.escribirEnFichero(mensajeAEscribir);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            System.err.println("No existe el padding seleccionado");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("La clave introducida no es válida");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("El tamaño del bloque utilizado no es correcto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El padding utilizado es erróneo");
            e.printStackTrace();
        }

    }


}

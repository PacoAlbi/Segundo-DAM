package Ejercicio3;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Base64;

public class Descifrar {

    public static void main(String[] args) {
        byte [] mensaje;
        byte [] mensajeCifrado;
        String linea;
        try {
            BufferedReader br = new BufferedReader(new FileReader("mensajeCifrado.txt"));
            PrivateKey clavePrivada = CertifadoEmisor.getClavePrivada();
            Cipher cifrador = Cipher.getInstance("RSA");
            cifrador.init(Cipher.DECRYPT_MODE, clavePrivada);
            linea = br.readLine();
            while (linea != null) {
                mensajeCifrado = Base64.getDecoder().decode(linea);
                mensaje = cifrador.doFinal(mensajeCifrado);
                System.out.println(new String(mensaje, StandardCharsets.UTF_8));
                linea = br.readLine();
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
        } catch (IOException e) {
            System.err.println("La clave introducida no es válida");
            e.printStackTrace();
        }
    }
}

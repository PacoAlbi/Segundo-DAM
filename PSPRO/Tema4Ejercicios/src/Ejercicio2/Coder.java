package Ejercicio2;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Coder {

    private static final int LONGITUD = 16;
    private static final String ALGORITMO = "AES/ECB/PKCS5Padding";

    public static Key obtenerClave (String claveUsuario){
        Key clave = new SecretKeySpec(claveUsuario.getBytes(), 0, LONGITUD, "AES");
        return clave;
    }

    public static byte[] cifrar (String texto, Key clave){
        byte[] mensajeCifrado = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.ENCRYPT_MODE, clave);
            mensajeCifrado = cipher.doFinal(texto.getBytes());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            System.err.println("El padding seleccionado no existe");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("La clave utilizada no es válida");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("El tamaño del bloque elegido no es correcto");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El padding seleccionado no es correcto");
            e.printStackTrace();
        }
        return mensajeCifrado;
    }

    public static String descifrar (String mensajeCifrado, Key clave){
        String mensaje = null;
        try{
            Cipher cipher = Cipher.getInstance(ALGORITMO);
            cipher.init(Cipher.DECRYPT_MODE, clave);
            byte[] descifrar = cipher.doFinal(Base64.getDecoder().decode(mensajeCifrado));
            mensaje = new String(descifrar);
        } catch (NoSuchPaddingException e) {
            System.err.println("No existe el algoritmo especificado");
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("El padding seleccionado no existe");
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            System.err.println("La clave utilizada no es válida");
            e.printStackTrace();
        } catch (BadPaddingException e) {
            System.err.println("El tamaño del bloque elegido no es correcto");
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            System.err.println("El padding seleccionado no es correcto");
            e.printStackTrace();
        }
        return mensaje;
    }
}
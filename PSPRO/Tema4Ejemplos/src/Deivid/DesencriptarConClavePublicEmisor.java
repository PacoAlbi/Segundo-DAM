package Deivid;
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
public class DesencriptarConClavePublicEmisor {
    public static void main(String[] args) {
        try {
            // Tomamos la clave publica
            PublicKey publicKey = KeysManager.getClavePublica(KeysManager.PUBLIC_KEY_FILE_EMISOR);

            Cipher cipher = Cipher.getInstance("RSA");

            // Desciframos con la clave privada
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            List<String> mensajeAEscribir = new ArrayList<>();
            for (String linea:ManejadoraFicheros.leerFichero()) {
                byte[] mensajeCifrado = Base64.getDecoder().decode(linea);
                // Se obtiene el mensaje descifrado
                byte[] mensaje = cipher.doFinal(mensajeCifrado);
                mensajeAEscribir.add(new String(mensaje));
            }
            // Escribimos el mensaje descifrado en el fichero
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

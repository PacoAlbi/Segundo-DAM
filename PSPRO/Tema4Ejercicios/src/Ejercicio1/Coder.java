package Ejercicio1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
Una clase que se encargue del proceso de cálculo de hash. Las otras dos clases harán uso de esta.
Esta clase contendrá dos métodos:
getDigest: Obtiene el resumen del array de bytes proporcionado a partir del algoritmo proporcionado.
compararResumenes: compara dos arrays de bytes (resúmenes) indicando si son o no iguales.
 */
public class Coder {

    public static byte[] getDigest(String input) {
        MessageDigest algoritmo;
        byte[] byteinput;
        byte[] resumen;
        try {
            algoritmo = MessageDigest.getInstance("SHA-256");
            algoritmo.reset();
            algoritmo.update(byteinput);
            resumen = algoritmo.digest();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("El algoritmo seleccionado no existe");
            e.printStackTrace();
        }
        return resumen;
    }
}


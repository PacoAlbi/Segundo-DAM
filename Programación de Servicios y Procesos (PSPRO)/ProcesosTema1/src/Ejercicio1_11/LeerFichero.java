package ejercicio11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class LeerFichero {

    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:\\pruebas\\carpeta1\\fichero2.txt");
            BufferedReader br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {



    private static int punteroLeer =0;
    private static char letra, num;

    public static void main(String[] args) {

        //Declaro los ficheros de entrada y de salida
        File lectura = new File("src/letras.txt");
        File escritura = new File("src/escrituraInversa.txt");

        leerFichero(lectura); //funciona de las pruebas en clase.

        while (letra != '\uFFFF'){

            escribirFichero(escritura);
            leerFichero(lectura);

        }
    }

    public static void leerFichero(File fichero){

        try {
            RandomAccessFile lector = new RandomAccessFile(fichero,"r");

            lector.seek(punteroLeer);
            letra = (char)lector.read();
            num = (char)lector.read();

            //Cierro
            lector.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
        }

        punteroLeer += 2;//Para que llegue al siguiente grupo de letras

    }

    public static void escribirFichero(File fichero){

        //Variables auxiliares
        int posicion;
        char temp, numTemp;

        try {

            RandomAccessFile escribir = new RandomAccessFile(fichero,"rw");

            //Posicionamos el puntero en la ultima letra
            posicion = (int) escribir.length()-2;
            //Avanzamos las posicion de todas la letras en dos
            while(posicion>=0){
                escribir.seek(posicion);
                temp = (char)escribir.read();
                numTemp = (char)escribir.read();
                escribir.write(temp);
                escribir.write(numTemp);
                posicion -= 2; //Vuelvo para atrás
            }

            //Escribo
            escribir.seek(0);
            escribir.write(letra);
            escribir.write(num);

            //Cierro
            escribir.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
        }
    }
}

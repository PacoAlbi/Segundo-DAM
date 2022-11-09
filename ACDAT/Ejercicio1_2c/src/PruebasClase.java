import java.io.*;

public class PruebasClase {

    public static void main(String[] args) {
        File file = new File("src\\letras.txt");
        File fileW = new File("src\\escritura.txt");
        try {
            RandomAccessFile rafW = new RandomAccessFile(fileW, "rw");
            RandomAccessFile rafR = new RandomAccessFile(file, "r");

            int a;
            int j = 0;
            while (j <= 4) {
                rafR.seek(0);
                a = rafR.read();
                rafW.write(a);
                j++;
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void burbuja(int[] A) {
        int i, j, aux;
        for (i = 0; i < A.length - 1; i++) {
            for (j = 0; j < A.length - i - 1; j++) {
                if (A[j + 1] < A[j]) {
                    aux = A[j + 1];
                    A[j + 1] = A[j];
                    A[j] = aux;
                }
            }
        }
    }


    public static void Eva() {


        File file = new File("src\\abecedario.txt");
        File file2 = new File("abecedarioAlReves.txt");


        try {

            RandomAccessFile randomAccessFileLectura = new RandomAccessFile(file, "r");
            RandomAccessFile randomAccessFileEscritura = new RandomAccessFile(file2, "rw");
            int letra, texto;
            int i = 0;


            while ((letra = randomAccessFileLectura.read()) != -1) {


                if (i % 2 != 0) {
                    randomAccessFileEscritura.writeBytes(System.lineSeparator());
                    i++;
                }


                // conseguir que imprima al reves

                randomAccessFileEscritura.write(letra);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

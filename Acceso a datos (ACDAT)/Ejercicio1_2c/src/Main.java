
import java.io.*;

public class Main {

    public static void main(String[] args) {
        File file = new File("src\\a.txt");
        File fileW = new File("src\\cincoA.txt");
        try {
            RandomAccessFile rafW = new RandomAccessFile(fileW, "rw");
            RandomAccessFile rafR = new RandomAccessFile(file, "r");

            /*
            Mejor que lo lea en entero porque
            si recoge los bytes y se mueve a la siguiente posición se moverá a donde necesitamos
            En cambio, si lo hacemos con Char machacará la segunda posición del byte[] que lo compone
             */


            int a = 0;
            int j = 12;
            while (j >= 0) {
                rafR.seek(j);
                a = rafR.read();
                if (j % 2 != 0) {
                    j--;
                } else {
                    rafW.write(a);
                    j--;
                }


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

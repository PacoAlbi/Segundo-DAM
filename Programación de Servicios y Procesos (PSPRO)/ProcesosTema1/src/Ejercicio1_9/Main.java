package Ejercicio1_9;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String [] comando = {"java", "src/Ejercicio1_5/PreguntaNombre.java"};

        try {
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);


            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ejercicio1_8/salidaProcesoLento2.txt"));

            String line = br.readLine();
            while (line!=null){
                System.out.println(line);
                line = br.readLine();
            }

            is.close();
            isr.close();
            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
            e.printStackTrace();
        }
    }
}

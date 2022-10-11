package Ejercicio1_8;

import java.io.*;

public class Prueba {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String [] comando = {"java", "src/ProcesoLento/ProcesoLento.java"};

        try {
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);


            BufferedWriter bw = new BufferedWriter(new FileWriter("src/Ejercicio1_8/salida.txt"));

            String line = br.readLine();
            while (line!=null){
                //System.out.println(line); para probar que sale por pantalla,
                bw.write(line+System.lineSeparator());
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

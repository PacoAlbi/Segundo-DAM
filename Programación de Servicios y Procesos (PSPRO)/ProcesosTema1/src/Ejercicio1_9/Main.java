package Ejercicio1_9;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String [] comando = {"java", "src/Ejercicio1_5/PreguntaNombre.java"};

        try {
            File archivoLectura = new File("src/Ejercicio1_5/nombres.txt");
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            OutputStream os = p.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedReader br = new BufferedReader(isr);
            BufferedWriter bw = new BufferedWriter(osw);


            String escrit = bw.toString();
            String line = br.readLine();
            while (line!=null){
                System.out.println(line);
                p.getOutputStream();
                line = br.readLine();
            }
            is.close();
            os.close();
            isr.close();
            osw.close();
            br.close();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
            e.printStackTrace();
        }
    }
}

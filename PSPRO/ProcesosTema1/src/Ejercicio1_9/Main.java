package Ejercicio1_9;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String [] comando = {"java", "src/Ejercicio1_5/PreguntaNombre.java"};

        try {
            FileReader archivoLectura = new FileReader("src/Ejercicio1_5/nombres.txt");
            Process p = r.exec(comando);
            InputStream is = p.getInputStream();
            OutputStream os = p.getOutputStream();
            InputStreamReader isr = new InputStreamReader(is);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedReader br = new BufferedReader(archivoLectura);
            BufferedWriter bw = new BufferedWriter(osw);

            String linea = br.readLine();
            while (linea!=null){
                bw.write(linea);
                bw.newLine();
                linea = br.readLine();
            }

            bw.close();  //Si no cierro aquí, no me deja continuar con el proceso, mucho ojo con los buffer que bloquean...
            //p.waitFor(); //Lo puse porque pensé que era necesario, pero al conseguir que funcione y probar, vi que funciona igual
            br = new BufferedReader(isr); //Cambio ahora la entrada para que lea el nombre del txt. Vuelvo a crear el BR porque no se pueden castear.
            linea = br.readLine();  //Leo la nueva línea
            while (linea!=null){
                System.out.println(linea);
                linea = br.readLine();
            }

            is.close();
            os.close();
            isr.close();
            osw.close();
            br.close();
        } catch (IOException e) {
            System.out.println("Error de lectura/escritura");
            e.printStackTrace();
        }/* catch (InterruptedException e) {
            System.out.println("Error... esperando?");
            e.printStackTrace();
        }*/
    }
}

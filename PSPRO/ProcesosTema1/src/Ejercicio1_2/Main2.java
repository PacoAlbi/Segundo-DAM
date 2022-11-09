package Ejercicio1_2;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {

        if (args.length <= 0) {
            System.out.println("Debe indicarse comando a ejecutar.");
            System.exit(1);
        }

        ProcessBuilder pb = new ProcessBuilder(args);
        File directorio = new File("C:\\Users\\falbinana\\IdeaProjects\\ProcesosTema1\\src\\Ejercicios");
        pb.directory(directorio);
        Map<String, String> mapa = pb.environment();
        Set<String> claves = mapa.keySet();
        for (String clave: claves) {
            String valor = mapa.get(clave);
            System.out.println(clave + " = " + valor);
        }
        pb.inheritIO();

        try {

            Process p = pb.start();

            int codRet = p.waitFor();
            System.out.println("La ejecución de " + Arrays.toString(args)
                    + " devuelve " + codRet
                    + " " + (codRet == 0 ? "(ejecución correcta)" : "(ERROR)")
            );
        } catch (IOException e) {
            System.err.println("Error durante ejecución del proceso");
            System.err.println("Información detallada");
            System.err.println("---------------------");
            e.printStackTrace();
            System.err.println("---------------------");
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            System.exit(3);
        }
    }

}

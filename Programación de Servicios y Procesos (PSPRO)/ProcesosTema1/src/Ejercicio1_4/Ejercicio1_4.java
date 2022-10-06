import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Ejercicio1_4 {

    public static void main(String[] args) {

        if (args.length <= 0) {
            System.out.println("Debe indicarse comando a ejecutar.");
            System.exit(1);
        }

        ProcessBuilder pb = new ProcessBuilder(args);
        File directorio = new File("C:\\Users\\falbinana\\IdeaProjects\\ProcesosTema1\\src\\Ejercicios");
        File salidaProcesoLento = new File("src\\salidaProcesoLento.txt");
        pb.directory(directorio);
        pb.redirectOutput(salidaProcesoLento);
        //pb.inheritIO();


        try {

            Process p = pb.start();
            while (p.isAlive()){
                System.out.println("El proceso sigue vivo.");
                Thread.sleep(3000);
            }
            System.out.println("El proceso ha muerto, recemos por él.");

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
            // Indicamos que la ejecución termina con error 2
            System.exit(2);
        } catch (InterruptedException e) {
            System.err.println("Proceso interrumpido");
            // Indicamos que la ejecución termina con error 2
            System.exit(3);
        }
    }

}

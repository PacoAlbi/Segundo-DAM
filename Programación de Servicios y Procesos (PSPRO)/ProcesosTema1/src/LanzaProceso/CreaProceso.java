package LanzaProceso;

import java.io.IOException;

public class CreaProceso {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "src\\lanzaproceso\\HolaMundo.java");

        pb.inheritIO();

        try {
            pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

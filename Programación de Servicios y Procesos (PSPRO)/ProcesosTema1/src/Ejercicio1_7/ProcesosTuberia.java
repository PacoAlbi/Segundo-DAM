package Ejercicio1_7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcesosTuberia {

    public static void main(String[] args) {
        ProcessBuilder pb1 = new ProcessBuilder("");
        ProcessBuilder pb2 = new ProcessBuilder("");
        ProcessBuilder pb3 = new ProcessBuilder("");
        pb1.redirectInput(ProcessBuilder.Redirect.INHERIT);
        pb3.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        pb1.redirectErrorStream(true);
        pb2.redirectErrorStream(true);
        pb3.redirectErrorStream(true);

        List<ProcessBuilder> lpb = new ArrayList<ProcessBuilder>();
        lpb.add(pb1);
        lpb.add(pb2);
        lpb.add(pb3);

        try {
            List<Process> lProcess = ProcessBuilder.startPipeline(lpb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

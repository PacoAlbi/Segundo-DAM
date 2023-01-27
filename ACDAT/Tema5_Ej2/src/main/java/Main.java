import java.util.logging.Level;
import java.util.logging.Logger;

import static Utils.Menu.*;
/**
 * Clase Main que ejecuta el menú. También tengo algunos casos de prueba que no he querido borrar.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        menuPrincipal();
    }
}
import java.util.logging.Level;
import java.util.logging.Logger;

import static Utilidades.Menu.menuPrincipal;
public class Main {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb").setLevel(Level.OFF);
        menuPrincipal();
    }
}
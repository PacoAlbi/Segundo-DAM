import DAO.Conection;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Conection cn = new Conection();
        cn.abrirConexion();
        cn.cerrar();
    }
}

import Controles.Conexion;
import Controles.Menu;

public class Main {
    public static void main(String[] args) {
        Conexion.conectar();
        Menu.menuPrincipal();
        Conexion.desconectarBBDD();
    }
}

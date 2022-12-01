package DAL;

import java.sql.SQLException;
import java.sql.Statement;

public class CrearBBDD {

    public static void main(String[] args) {
        String[] campos = {"idEquipo VARCHAR(25) PRIMARY KEY,", "ganados int,", "empatados INT,", "perdidos INT,", "golesMarcados INT,", "golesRecibidos INT"};
        crearTabla("Equipos", campos);
    }

    public static void crearTabla(String tabla, String[] nombresCampos) {

        String create = "CREATE TABLE " + tabla + " (";
        Statement st;

        for (int i = 0; i < nombresCampos.length; i++) {
            create += nombresCampos[i];
        }
        create += ")";

        System.out.println(create);
        try {
            st = Conexion.conectar().createStatement();
            st.executeUpdate(create);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
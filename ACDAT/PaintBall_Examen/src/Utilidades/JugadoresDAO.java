package Utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JugadoresDAO {

    public void creaTablas () throws SQLException {
        Statement st = ConexionBBDD.conectar().createStatement();
        st.execute("");
    }

    public void carga_datos() throws FileNotFoundException, SQLException {
        File f = new File("src/Entidades/Personas.txt");
        Scanner sc = new Scanner(f);
        PreparedStatement st = ConexionBBDD.conectar().prepareStatement("");
        while (sc.hasNext()){
            String linea = sc.nextLine();


        }
    }

}

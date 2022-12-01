package Eva.manejadora;

import Eva.entidades.Equipos;
import Eva.dao.BaseDatos;
import java.io.*;

public class ManejadoraDAO {


    public static void lecturaFichero(){

        File f=new File("src/equipos.txt");
        BufferedReader br=null;

        try {

            FileReader fr= null;
            String equipo;
            fr = new FileReader(f);
            br=new BufferedReader(fr);
            Equipos equipo1;
            while((equipo = br.readLine()) !=null){

             equipo1=new Equipos(equipo);
             BaseDatos.insertarEquipo(equipo1);
            }
            System.out.println("Equipo leido correctamente");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public static void elegirEquipos(){


    }
}

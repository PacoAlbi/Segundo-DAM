package Vacas.UI;

import DAL.DAL;
import Entities.VQ_Ganado;
import Entities.VQ_Naves;

import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //VQ_Ganado vaca = new VQ_Ganado("12-12-2021", null, "Paka", 1, 12);
        //DAL.mostrarRegistro("listaVacas", "ID", 50);


       // DAL.mostrarRegistro("ContarVacasSinMadre");
      //  DAL.mostrarRegistroConString("ContarVacasSinMadre");
     //   DAL.mostrarRegistroConEntero("ContarVacasSinMadre");
        //DAL.mostrarRegistroDobles("NumeroLitrosMesYAnno","mes_produccion",8,"year_produccion",2015);
        var nave = new VQ_Naves();
   nave.setIdNave(11);
//        nave.setGanadero("Paco Albiñana");
//       nave.setUbicacion("Los cerros de Úbeda");
//        DAL.guardar(nave);
//       var vaca1 = new VQ_Ganado();
//        vaca1.setID(17);
        DAL.borrar2(nave);
    }
}

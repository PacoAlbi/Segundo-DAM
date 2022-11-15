using Mandaloriano_Entidades;
using System.Collections;

namespace Mandaloriano_DAL
{
    public static class clsListadoMisionesDAL
    {

        /// <summary>
        /// Devolvera una lista con todas las misiones disponibles
        /// </summary>
        /// <returns></returns>
        public static List<clsMisiones> obtenerListadoMisionesTotal()
        {
            List<clsMisiones> misiones = new List<clsMisiones>();
            misiones.Add(new clsMisiones(1,"Rescate del Baby Yoda","Debes hacerte con Grogu y " +
                "llevárselo a Luke SkyWalker para su entrenamiento.", 5000));
            misiones.Add(new clsMisiones(2, "Recuperar armadura Beskar",
                "La armadura de Bershka ha sido robada. Debes encontrarla.", 2000));
            misiones.Add(new clsMisiones(3, "Planeta Sorgon", "Debes llevar a un " +
                "niño de vuelta a su planeta natal “Sorgon”", 500));
            misiones.Add(new clsMisiones(4, "Renacuajos", "Debes llevar a una Dama Rana y sus" +
                " huevos de Tatooine a la luna del estuario Trask, donde su esposo fertilizará los" +
                " huevos", 500));
            return misiones;
        }
    }
}
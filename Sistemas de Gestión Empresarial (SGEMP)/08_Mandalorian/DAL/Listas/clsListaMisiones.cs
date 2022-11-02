using Entidades;

namespace DAL.Listas
{
    //Clase de "acceso a los datos".
    public class clsListaMisiones
    {
        //Método que devuelve una lista de misiones.
        public static List<clsMision> getListaCompletaMisiones ()
        {
            List<clsMision> lista = new List<clsMision>();
            lista.Add(new clsMision(1, "Rescate de Baby Yoda", "Debes hacerte con Grogu y llevárselo a Luke SkyWalker para su entrenamiento.\r\nRecompensa: 5000 créditos.\r\n"));
            lista.Add(new clsMision(2, "Recuperar armadura Beskar", "La armadura de Bershka ha sido robada. Debes encontrarla.\r\nREcompensa: 2000 créditos\r\nEl Beskar fue utilizado en gran medida por los mandalorianos como parte de su iniciativa colectiva para el avance tecnológico. Se vieron obligados durante muchos años a enfrentarse a los Jedi en luchas de poder, pero no pudieron explicar cómo los Jedi usaron la Fuerza para frustrarlos. El Beskar ayudó a la causa, e incluso a defenderse de un golpe indirecto de un sable de luz."));
            lista.Add(new clsMision(3, "Planeta Sorgon", "Debes llevar a un niño de vuelta a su planeta natal “Sorgon”.\r\nRecompensa: 500 créditos.\r\n"));
            lista.Add(new clsMision(4, "Renacuajos", "Debes llevar a una Dama Rana y sus huevos de Tatooine a la luna del estuario Trask, donde su esposo fertilizará los huevos.\r\nRecompensa: 500 créditos.\r\n"));

            return lista;
        }
        

    }
}

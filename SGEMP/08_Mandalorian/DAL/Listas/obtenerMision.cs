using Entidades;

namespace DAL.Listas
{
    //Clase para obtener una misión por id y devolverla al controlador.
    public class obtenerMision
    {
        //Método que devuelve una misión específica de la lista identificada por el Id.
        /// <summary>
        /// Método que devuelve una misión específica de la lista identificada por el Id.
        /// Precondición: id debe ser mayor que 0
        /// Postcondiciones: el objeto devuelto puede ser null o una misión rellan si se encuentra.
        /// </summary>
        /// <param name="Id">int</param>
        /// <returns>devuelve uns clsMision</returns>
        public static clsMision obtenerMisionId(int Id)
        {
            List<clsMision> listaMisiones = DAL.Listas.clsListaMisiones.getListaCompletaMisiones();
            return listaMisiones.Find(x => x.Id == Id);
        }
    }
}
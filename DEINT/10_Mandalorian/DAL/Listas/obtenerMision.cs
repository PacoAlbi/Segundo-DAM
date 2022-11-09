using Entidades;


namespace DAL.Listas
{
    //Clase para obtener una misión por id y devolverla al controlador.
    public class obtenerMision
    {
        //Método que devuelve una misión específica de la lista identificada por el Id.
        public static clsMision obtenerMisionId (int Id)
        {
            List<clsMision> listaMisiones = DAL.Listas.clsListaMisiones.getListaCompletaMisiones();
            return listaMisiones.Find(x => x.Id == Id);
        }
    }
}

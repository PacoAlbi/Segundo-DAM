using DAL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace BL.Listados
{
    public class clsListadoPersonasBL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la DAL y, según la lógica del negocio, saco una lista de personas de la base de datos.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve de la DAL un listado de personas.
        /// </summary>
        /// <returns>List de personas.</returns>
        public static ObservableCollection<clsPersona> getListadoPersonasBL()
        {
            return new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasDAL());
        }
    }
}
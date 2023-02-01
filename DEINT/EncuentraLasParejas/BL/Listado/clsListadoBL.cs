using DAL.Listado;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Listado
{
    public class clsListadoBL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la DAL y, según la lógica del negocio, saco una lista de jugadores.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve de la DAL un listado de jugadores.
        /// </summary>
        /// <returns>ObservableCollection de jugadores</returns>
        public static ObservableCollection<clsJugador> getListadoJugadoresBL()
        {
            return new ObservableCollection<clsJugador>(clsListadoDAL.getListadoJugadoresDAL());
        }
    }
}

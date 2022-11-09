using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Listas
{
    internal class clsListaMisionesBL
    {
        /// <summary>
        /// Función que llama a la DAL para pedir un listado de misiones completo y comprueba si es domingo para 
        /// mandarla o no mandarla.
        /// </summary>
        /// <returns></returns>
        public static List<clsMision> getListaCompletaMisionesBL()
        {
            List<clsMision> lista = null;
            if (!DateTime.Now.DayOfWeek.Equals(0))
            {
                lista =  DAL.Listas.clsListaMisiones.getListaCompletaMisiones();
            }
            return lista;
        }
    }
}

using Mandaloriano_Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mandaloriano_DAL
{
    public static class buscarMisionDAL
    {
        /// <summary>
        /// Devolvera la mision que coincida con el Id que entra por parametros
        /// Precondiciones: Ninguna
        /// Postcondiones: Ninguna
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public static clsMisiones busrcarMisionPorId(int id)
        {
            return clsListadoMisionesDAL.obtenerListadoMisionesTotal().Find(mision => mision.Id == id);
        }
    }
}

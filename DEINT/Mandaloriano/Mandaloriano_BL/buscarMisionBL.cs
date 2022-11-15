using Mandaloriano_DAL;
using Mandaloriano_Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mandaloriano_BL
{
    public static class buscarMisionBL
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
            return buscarMisionDAL.busrcarMisionPorId(id);
        }
    }
}

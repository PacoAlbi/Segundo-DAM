using Mandaloriano_DAL;
using Mandaloriano_Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Mandaloriano_BL
{
    public static class ListadoMisionesBL
    {
        public static List<clsMisiones> obtenerListadoMisionesTotal()
        {
            List<clsMisiones> misiones = new List<clsMisiones>();
            if (DateTime.Now.DayOfWeek != DayOfWeek.Sunday)
            {
                misiones = clsListadoMisionesDAL.obtenerListadoMisionesTotal();
            }
            return misiones;
        }
    }
}

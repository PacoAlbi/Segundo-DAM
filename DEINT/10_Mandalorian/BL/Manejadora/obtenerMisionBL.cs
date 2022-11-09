using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL.Manejadora
{
    internal class obtenerMisionBL
    {
        public static clsMision obtenerMisionIdBL (int Id)
        {
            return DAL.Listas.obtenerMision.obtenerMisionId(Id);
        }
    }
}

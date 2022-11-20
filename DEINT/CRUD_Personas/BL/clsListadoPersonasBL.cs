using DAL;
using DAL.Listados;
using Entidades;
using Microsoft.Data.SqlClient;
using System.Data;

namespace BL
{
    public class clsListadoPersonasBL
    {
        public static List<clsPersona> getListadoPersonasBL()
        {
            List<clsPersona> listadoPersonasBL = clsListadoPersonasDAL.getListadoPersonasDAL();
            return listadoPersonasBL;
        }
    }
}
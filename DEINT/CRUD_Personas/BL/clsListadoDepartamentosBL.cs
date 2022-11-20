using DAL;
using DAL.Listados;
using Entidades;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL
{
    public class clsListadoDepartamentosBL
    {
        public static List<clsDepartamentos> getListadoDepartamentosBL()
        {
            List<clsDepartamentos> listadoDepartamentosBL = clsListadoDepartamentosDAL.getListadoDepartamentosDAL();
            return listadoDepartamentosBL;
        }
    }
}

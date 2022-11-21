using DAL;
using DAL.Listados;
using Entidades;
using Microsoft.Data.SqlClient;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BL
{
    public class clsListadoDepartamentosBL
    {
        public static ObservableCollection<clsDepartamentos> getListadoDepartamentosBL()
        {
            ObservableCollection<clsDepartamentos> listadoDepartamentosBL = new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosDAL.getListadoDepartamentosDAL());
            return listadoDepartamentosBL;
        }
    }
}

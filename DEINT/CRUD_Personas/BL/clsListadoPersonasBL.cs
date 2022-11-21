using DAL;
using DAL.Listados;
using Entidades;
using Microsoft.Data.SqlClient;
using System.Collections.ObjectModel;
using System.Data;

namespace BL
{
    public class clsListadoPersonasBL
    {
        public static ObservableCollection<clsPersona> getListadoPersonasBL()
        {
            ObservableCollection<clsPersona> listadoPersonasBL = new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasDAL());
            return listadoPersonasBL;
        }
    }
}
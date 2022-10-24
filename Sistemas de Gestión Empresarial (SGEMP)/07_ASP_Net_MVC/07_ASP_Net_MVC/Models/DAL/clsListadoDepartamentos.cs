using _07_ASP_Net_MVC.Models.Entidades;
using System.Collections.Generic;

namespace _07_ASP_Net_MVC.Models.DAL
{
    public class clsListadoDepartamentos
    {

        public static List<clsDepartamento> listarDepartamentos()
        {
            List<clsDepartamento> lista = new List<clsDepartamento>();

            lista.Add(new clsDepartamento("Marketing", 3));
            lista.Add(new clsDepartamento("Ventas", 2));
            lista.Add(new clsDepartamento("Dirección", 1));
            lista.Add(new clsDepartamento("Logística", 6));
            lista.Add(new clsDepartamento("Operaciones", 4));
            lista.Add(new clsDepartamento("informática", 5));

            return lista;
        }
    }
}

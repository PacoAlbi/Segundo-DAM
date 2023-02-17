using DAL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace BL.Listados
{
    public class clsListadoDepartamentosBL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la DAL y, según la lógica del negocio, le pido una lista de departamentos.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de departamentos de la DAL.
        /// </summary>
        /// <returns>List de departamentos.</returns>
        public static ObservableCollection<clsDepartamentos> getListadoDepartamentosBL()
        {
            return new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosDAL.getListadoDepartamentosDAL());
        }
    }
}
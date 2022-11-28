using DAL;
using DAL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace BL.Listados
{
    public class clsListadoDepartamentosBL
    {
        /// <summary>
        /// Conecto con la DAL y, según la lógica del negocio, le pido una lista de departamentos.
        /// </summary>
        /// <returns>List de departamentos.</returns>
        public static ObservableCollection<clsDepartamentos> getListadoDepartamentosBL()
        {
            return new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosDAL.getListadoDepartamentosDAL());
        }

        /// <summary>
        /// Conecto con la DAL y, según la lógica del negocio, le pido un departamento por su id.
        /// </summary>
        /// <param name="Id"></param>
        /// <returns>Devuelvo un clsDepartamento si lo hemos encontrado.</returns>
        public static clsDepartamentos obtenerDepartamentoPorIdBL(int Id)
        {
            return clsListadoDepartamentosDAL.obtenerDepartamentoPorIdDAL(Id);
        }
    }
}

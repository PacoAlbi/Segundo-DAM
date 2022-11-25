using DAL;
using DAL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace BL.Listados
{
    public class clsListadoDepartamentosBL
    {
        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public static ObservableCollection<clsDepartamentos> getListadoDepartamentosBL()
        {
            return new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosDAL.getListadoDepartamentosDAL());
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public static clsDepartamentos obtenerDepartamentoPorIdBL(int Id)
        {
            return clsListadoDepartamentosDAL.obtenerDepartamentoPorIdDAL(Id);
        }
    }
}

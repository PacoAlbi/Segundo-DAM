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
            ObservableCollection<clsDepartamentos> listadoDepartamentosBL = new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosDAL.getListadoDepartamentosDAL());
            return listadoDepartamentosBL;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public static clsDepartamentos obtenerDepartamentoPorIdBL(int Id)
        {
            List<clsDepartamentos> departamentoBuscado = clsListadoDepartamentosDAL.getListadoDepartamentosDAL();
            return departamentoBuscado.Find(x => x.Id == Id);
        }
    }
}

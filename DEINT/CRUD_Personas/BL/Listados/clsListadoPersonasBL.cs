using DAL;
using DAL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace BL.Listados
{
    public class clsListadoPersonasBL
    {
        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public static ObservableCollection<clsPersona> getListadoPersonasBL()
        {
            return new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasDAL());
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public static clsPersona obtenerPersonaPorIdBL(int Id)
        {
            return clsListadoPersonasDAL.obtenerPersonaPorIdDAL(Id);
        }
    }
}
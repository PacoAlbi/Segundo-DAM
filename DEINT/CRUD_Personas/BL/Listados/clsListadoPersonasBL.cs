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
            ObservableCollection<clsPersona> listadoPersonasBL = new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasDAL());
            return listadoPersonasBL;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public static clsPersona obtenerPersonaPorIdBL(int Id)
        {
            List<clsPersona> personaBuscada = clsListadoPersonasDAL.getListadoPersonasDAL();
            return personaBuscada.Find(x => x.Id == Id);
        }
    }
}
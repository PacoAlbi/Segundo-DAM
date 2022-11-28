using DAL;
using DAL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace BL.Listados
{
    public class clsListadoPersonasBL
    {
        /// <summary>
        /// Conecto con la DAL y, según la lógica del negocio, saco una lista de personas de la base de datos.
        /// </summary>
        /// <returns>List de personas.</returns>
        public static ObservableCollection<clsPersona> getListadoPersonasBL()
        {
            return new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasDAL());
        }

        /// <summary>
        /// Conecto con la DAL y, según la lógica del negocio, le paso el id de la persona que quiero que busque en la base de datos.
        /// </summary>
        /// <param name="Id">Entero que representa el Id de la persona a buscar.</param>
        /// <returns>Devuelve una clsPersona encontrada por su Id.</returns>
        public static clsPersona obtenerPersonaPorIdBL(int Id)
        {
            return clsListadoPersonasDAL.obtenerPersonaPorIdDAL(Id);
        }
    }
}
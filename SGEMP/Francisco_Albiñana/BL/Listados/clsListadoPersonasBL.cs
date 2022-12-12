using DAL;
using DAL.Listados;
using Entidades;
using Microsoft.Data.SqlClient;
using System.Collections.ObjectModel;

namespace BL.Listados
{
    public class clsListadoPersonasBL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la DAL y, según la lógica del negocio, saco una lista de personas de la base de datos.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve de la DAL un listado de personas.
        /// </summary>
        /// <returns>List de personas.</returns>
        public static ObservableCollection<clsPersona> getListadoPersonasBL()
        {
            return new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasDAL());
        }

        /// <summary>
        /// Precondiciones: Debe recivir el id de una persona.
        /// Conecto con la DAL y, según la lógica del negocio, le paso el id de la persona que quiero que busque en la base de datos.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve de la DAL una persona.
        /// </summary>
        /// <param name="Id">Entero que representa el Id de la persona a buscar.</param>
        /// <returns>Devuelve una clsPersona encontrada por su Id.</returns>
        public static clsPersona obtenerPersonaPorIdBL(int Id)
        {
            return clsListadoPersonasDAL.obtenerPersonaPorIdDAL(Id);
        }

        /// <summary>
        /// Precondiciones: Debe recivir el id de un departamento.
        /// Busco en la Base de datos a un usuario pasando el Id del departamento como parámetro.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de la DAL.
        /// </summary>
        /// <param name="Id">Entero que representa el Id del departamento a buscar.</param>
        /// <returns>Devuelve una List<clsPersona> encontrado por la Id de su departamento.</returns>
        public static List<clsPersona> obtenerPersonasPorIdDepartamentoBL(int Id)
        {
            return clsListadoPersonasDAL.obtenerPersonasPorIdDepartamentoDAL(Id);
        }
    }
}
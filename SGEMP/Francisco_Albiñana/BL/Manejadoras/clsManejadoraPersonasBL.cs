using Entidades;
using DAL.Manejadoras;
using DAL;
using Microsoft.Data.SqlClient;

namespace BL.Manejadoras
{
    public class clsManejadoraPersonas
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de un departamento.
        /// Recibe un entero que es el id del departamento de las personas que queremos borrar.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Llama a la DAL para borrar a esas personas.
        /// </summary>
        /// <param name="id">Entero que es el ID del departamento.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarPersonaPorDepartamentoBL(int id)
        {
            return clsManejadoraPersonasDAL.borrarPersonaPorDepartamentoDAL(id);
        }
    }
}

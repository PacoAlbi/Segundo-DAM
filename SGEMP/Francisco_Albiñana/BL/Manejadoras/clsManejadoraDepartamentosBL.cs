using Entidades;
using DAL.Manejadoras;

namespace BL.Manejadoras
{
    public class clsManejadoraDepartamentos
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de un departamento.
        /// Recibe un entero que es el id del departamento a eliminar y, según la lógica del negocio, accede a la DAL para eliminarlo.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Llama a la DAL para borrar un departamento.
        /// </summary>
        /// <param name="id">Entero que representa el id del departamento a eliminar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarDepartamentosBL(int id)
        {
            return clsManejadoraDepartamentosDAL.borrarDepartamentosDAL(id);
        }
    }
}
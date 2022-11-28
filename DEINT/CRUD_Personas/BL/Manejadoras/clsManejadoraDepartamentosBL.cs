using Entidades;
using DAL.Manejadoras;

namespace BL.Manejadoras
{
    public class clsManejadoraDepartamentos
    {
        /// <summary>
        /// Recibe un entero que es el id del departamento a eliminar y, según la lógica del negocio, accede a la DAL para eliminarlo.
        /// </summary>
        /// <param name="id">Entero que representa el id del departamento a eliminar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarDepartamentosBL(int id)
        {
            return clsManejadoraDepartamentosDAL.borrarDepartamentosDAL(id);
        }

        /// <summary>
        /// Recibe un departamento ya editado y, según la lógica del negocio, lo manda a la DAL para actualizarlo.
        /// </summary>
        /// <param name="departamento">Departamento para editar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int editarDepartamentoBL(clsDepartamentos departamento)
        {
            return clsManejadoraDepartamentosDAL.editarDepartamentoDAL(departamento);
        }

        /// <summary>
        /// Recibe un departamentos ya relleno y, según la lógica del negocio, lo manda a la DAL para insertarlo.
        /// </summary>
        /// <param name="persona">Departamento para insertar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int insertarDepartamentoBL(clsDepartamentos departamento)
        {
            return clsManejadoraDepartamentosDAL.insertarDepartamentoDAL(departamento);
        }
    }
}

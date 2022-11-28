using Entidades;
using DAL.Manejadoras;

namespace BL.Manejadoras
{
    public class clsManejadoraPersonas
    {
        /// <summary>
        /// Recibe un entero que representa a una persona a eliminar, filtra según la lógica del negocio, y lo pasa a la DAL para eliminarla.
        /// </summary>
        /// <param name="id">Entero que es el ID de la persona.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarPersonaBL(int id)
        {
            return clsManejadoraPersonasDAL.borrarPersonaDAL(id);
        }

        /// <summary>
        /// Recibe una Persona ya editada, filtra según la lógica del negocio, y lo pasa a la DAL para actualizarla.
        /// </summary>
        /// <param name="persona">Persona para editar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int editarPersonaBL(clsPersona persona)
        {
            return clsManejadoraPersonasDAL.editarPersonaDAL(persona);
        }

        /// <summary>
        /// Recibe una persona ya rellena para, según la lógica del negocio, pasarlo a la DAL para insertarlo.
        /// </summary>
        /// <param name="persona">Persona a insertar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int insertarPersonasBL(clsPersona persona)
        {
            return clsManejadoraPersonasDAL.insertarPersonasDAL(persona);
        }
    }
}

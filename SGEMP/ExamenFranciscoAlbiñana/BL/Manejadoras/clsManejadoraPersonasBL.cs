using Entidades;
using DAL.Manejadoras;
using System.Net;

namespace BL.Manejadoras
{
    public class clsManejadoraPersonas
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de una persona.
        /// Recibe una Persona ya editada, filtra según la lógica del negocio, y lo pasa a la DAL para actualizarla.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Llama a la DAL para editar a la persona.
        /// </summary>
        /// <param name="persona">Persona para editar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int editarPersonaBL(clsPersona persona)
        {
            return clsManejadoraPersonasDAL.editarPersonaDAL(persona);
        }
    }
}
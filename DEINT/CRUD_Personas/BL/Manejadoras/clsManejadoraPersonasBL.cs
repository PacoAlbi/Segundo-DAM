﻿using Entidades;
using DAL.Manejadoras;

namespace BL.Manejadoras
{
    public class clsManejadoraPersonas
    {
        /// <summary>
        /// Precondiciones: Deber recivir la id de una persona.
        /// Recibe un entero que representa a una persona a eliminar, filtra según la lógica del negocio, y lo pasa a la DAL para eliminarla.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Llama a la DAL para borrar una persona.
        /// </summary>
        /// <param name="id">Entero que es el ID de la persona.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int borrarPersonaBL(int id)
        {
            return clsManejadoraPersonasDAL.borrarPersonaDAL(id);
        }

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

        /// <summary>
        /// Precondiciones: Debe recivir una persona rellena.
        /// Recibe una persona ya rellena para, según la lógica del negocio, pasarlo a la DAL para insertarlo.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Llama a la DAL para insertar a una nueva persona.
        /// </summary>
        /// <param name="persona">Persona a insertar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int insertarPersonasBL(clsPersona persona)
        {
            return clsManejadoraPersonasDAL.insertarPersonasDAL(persona);
        }
    }
}

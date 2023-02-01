using DAL.Manejadora;
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;

namespace BL.Manejadora
{
    public class clsManejadoraBL
    {
        /// <summary>
        /// Precondiciones: Debe recivir un jugador.
        /// Recibe un jugador y, según la lógica del negocio, lo pasa a la DAL para insertarlo.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Llama a la DAL para insertar un jugador.
        /// </summary>
        /// <param name="persona">Jugador a insertar.</param>
        /// <returns>Entero con el número de filas afectadas si las hay.</returns>
        public static int insertarJugadorBL(clsJugador jugador)
        {
            return clsManejadoraDAL.insertarJugadorDAL(jugador);
        }
    }
}

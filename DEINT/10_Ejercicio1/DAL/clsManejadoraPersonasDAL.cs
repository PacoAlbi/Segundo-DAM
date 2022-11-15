using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DAL
{
    //Acceso a las personas buscadas.
    public class clsManejadoraPersonasDAL
    {
        /// <summary>
        /// Método que devuelve una lista con las personas que contengan los carácteres que le pasamos y lo almacenamos a otra lista de obtenidas.
        /// </summary>
        /// <param name="cadena">Caracteres que entrada</param>
        /// <returns>List de personas obtenidas</returns>
        public static List<clsPersona> obtenerPersonas (string cadena)
        {
            List<clsPersona> listaCompleta = clsListadoPersonasDAL.getListadoPersonasCompleto();
            List<clsPersona> listaObtenida = new List<clsPersona>();

            listaObtenida.Add(listaCompleta.Find(x => x.Nombre.Contains(cadena) || x.Apellido.Contains(cadena)));

            return listaObtenida;
        }


    }
}

using Entidades;

namespace DAL
{
    // Acceso al listado de personas.
    public class clsListadoPersonasDAL
    {
        /// <summary>
        /// Método que devuelve una lista de personas.
        /// </summary>
        /// <returns>Una List de personas</returns>
        public static List<clsPersona> getListadoPersonasCompleto ()
        {
            List<clsPersona> listadoPersonasCompleto = new List<clsPersona>();

            listadoPersonasCompleto.Add(new clsPersona("Paco", "Albiñna"));
            listadoPersonasCompleto.Add(new clsPersona("Manu", "Lopez"));
            listadoPersonasCompleto.Add(new clsPersona("Pepe", "Gotera"));
            listadoPersonasCompleto.Add(new clsPersona("Mortadelo", "Perez"));
            listadoPersonasCompleto.Add(new clsPersona("Filemon", "Gutierrez"));
            listadoPersonasCompleto.Add(new clsPersona("Roberto", "Sedigno"));

            return listadoPersonasCompleto;
        }

    }
}
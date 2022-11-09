using Entidades;
using System.Collections.ObjectModel;

namespace DAL
{

    public class ListadoCompletoPersonas
    {

        /// <summary>
        /// Método que crea una lista de personas y se la pasa al controlador para ser mostrada.
        /// </summary>
        /// <returns>Devuelve un ObservableCollection de personas.</returns>
        public static ObservableCollection<clsPersona> obtenerListadoPersonas()
        {
            ObservableCollection<clsPersona> listaPersonas = new ObservableCollection<clsPersona>();

            listaPersonas.Add(new clsPersona("Paco", "Albiñana"));
            listaPersonas.Add(new clsPersona("Eva", "Ramos"));
            listaPersonas.Add(new clsPersona("Pepe", "Perez"));
            listaPersonas.Add(new clsPersona("Manuel", "Lopez"));            
            listaPersonas.Add(new clsPersona("Carmelo", "Aguilar"));
            listaPersonas.Add(new clsPersona("Fernando", "Galiana"));
            listaPersonas.Add(new clsPersona("Pedro", "Cornejo"));           
            listaPersonas.Add(new clsPersona("Marta", "Devos"));
            listaPersonas.Add(new clsPersona("Rocio", "Campos"));
            listaPersonas.Add(new clsPersona("Laura", "Alcazar"));

            return listaPersonas;
        }

    }
}
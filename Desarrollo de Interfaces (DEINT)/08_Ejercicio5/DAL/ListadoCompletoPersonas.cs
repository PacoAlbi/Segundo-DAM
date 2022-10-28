using Entidades;
using System.Collections.ObjectModel;

namespace DAL
{

    public class ListadoCompletoPersonas
    {

        /// <summary>
        /// Funcion que devuelve una lista de personas
        /// </summary>
        /// <returns></returns>
        public static ObservableCollection<clsPersona> obtenerListadoPersonas()
        {
            ObservableCollection<clsPersona> listaPersonas = new ObservableCollection<clsPersona>();



            listaPersonas.Add(new clsPersona("Eva", "Ramos"));
            listaPersonas.Add(new clsPersona("Virginia", "Delgado"));
            listaPersonas.Add(new clsPersona("Manuel", "Lopez"));
            listaPersonas.Add(new clsPersona("Paco", "Albiñana"));
            listaPersonas.Add(new clsPersona("Carmelo", "Aguilar"));
            listaPersonas.Add(new clsPersona("Pedro", "Cornejo"));
            listaPersonas.Add(new clsPersona("Xisca", "Rumier"));
            listaPersonas.Add(new clsPersona("Rosario", "Leon"));
            listaPersonas.Add(new clsPersona("Jesus Miguel", "Ramos"));
            listaPersonas.Add(new clsPersona("Carlos", "Rupias"));

            return listaPersonas;
        }

    }
}
using Entidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _08_Ejercicio5.Models.DAL
{
    public class clsListadoPersonasDAL
    {
        
        List<clsPersona> personas = new List<clsPersona>();

        /// <summary>
    	/// Función que nos devuelve un listado de todas las personas
    	/// </summary>
    	/// <returns>Listado de personas</returns>
    	public List<clsPersona> listadoCompletoPersonas ()
        {
            personas.Add(new clsPersona("Paco", "Albiñana"));
            personas.Add(new clsPersona("Eva", "Ramos"));
            personas.Add(new clsPersona("Fernando", "Galiana"));
            personas.Add(new clsPersona("Pepe", "Perez"));
            personas.Add(new clsPersona("Roberto", "Carlos"));
            personas.Add(new clsPersona("Manuel", "Lopez"));
        }

    }
}

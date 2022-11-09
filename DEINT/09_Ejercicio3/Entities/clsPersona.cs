using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace Entities
{
    // All the code in this file is included in all platforms.
    public class clsPersona
    {
        #region Atributos
        private string nombre;
        #endregion

        #region Propiedades
        public string Nombre
        {
            get { return nombre; }
            set { nombre = value;}
        }

        public clsPersona()
        {
            Nombre = "Paco";
        }
        public clsPersona(string nombre)
        {
            Nombre = nombre;
        }
        #endregion
    }
}
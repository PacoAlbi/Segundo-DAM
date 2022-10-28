using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Ejercicio123.Views
{
    public class Persona
    {
        #region atributos
        public string Name { get; set; }
        public String Apellido { get; set; }
        #endregion
        #region constructores
        public Persona() {
            Name = "";
            Apellido = "";
        }
        public Persona(string name, string apellido)
        {
            Name = name;
            Apellido = apellido;
        }

        #endregion
    }
}

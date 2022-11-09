using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _07_Pages.Modelos
{
    public class Persona
    {
        private String _name;
        private String _apellidos;

        public Persona(string name, string apellidos)
        {
            _name = name;
            _apellidos = apellidos;
        }

        public Persona()
        {
        }

        public String Name { get; set; }
        public String Apellidos { get; set; }
    }
}

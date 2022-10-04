using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace _05_Hola_Mundo_WebForm.Models
{
    public class clsPersona
    {
        #region Atributos
        private string nombre;
        private string apellido;
        #endregion

        #region Getter y Setter
        public string Nombre
        {
           get { return nombre; }
           set { nombre = value; }
        }

        public string Apellido
        {
            get { return apellido; }
            set { apellido = value; }
        }
        #endregion


        #region Constructores
        public clsPersona (string nombre, string apellido)
        {
            this.nombre = nombre;
            this.apellido = apellido;
        }
        public clsPersona () { }
        #endregion

    }
}
using System;

namespace _03_Hello_World_Entidades_Estandar  //Esto es el espacio de nombre de ese proyecto, es lo que llamamos cuando usamos el using o el import
{
    public class clsPersona
    {
        #region Atributos
        private string nombre;
        #endregion

        #region Propiedades
        public string Nombre
        {
            get { return nombre; }
            set { nombre = value; }
        }
        #endregion

        #region Constructores
        public clsPersona ()
        {

        }

        public clsPersona (string nombre)
        {
            Nombre = nombre;
        }
        #endregion
    }
}

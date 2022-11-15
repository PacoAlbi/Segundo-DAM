namespace Entidades
{
    // Clase persona.
    public class clsPersona
    {
        #region Atributos
        private string nombre;
        private string apellido;
        #endregion

        #region Propiedades
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

        public clsPersona()
        {
        }
        public clsPersona(string nombre, string apellido)
        {
            this.nombre = nombre;
            this.apellido = apellido;
        }
        #endregion
    }
}
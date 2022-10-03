namespace _05_Entidades
{


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
        public string Apellido {
            get { return apellido; }
            set { apellido = value; }
        }
        #endregion

        #region Constructores

        public clsPersona () {}

        public clsPersona (string nombre, string apellido)
        {
            Nombre = nombre;
            Apellido = apellido;
        }
        #endregion


    }
}
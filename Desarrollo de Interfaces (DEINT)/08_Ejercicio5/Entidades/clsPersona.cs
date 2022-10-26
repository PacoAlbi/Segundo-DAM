namespace Entidades
{
    // All the code in this file is included in all platforms.
    public class clsPersona
    {
        #region Atributos
        private string nombre;
        private string apellido;
        #endregion

        #region Constructores
        public clsPersona() { }
        public clsPersona(string nombre, string apellido)
        {
            this.nombre = nombre;
            this.apellido = apellido;
        }
        #endregion

        #region Getter y Setter
        public string GetNombre()
        {
            return nombre;
        }
        public void SetNombre(string nombre)
        {
            this.nombre=nombre;
        }
        public string GetApellido()
        {
            return apellido;
        }
        public void SetApellido(string apellido)
        {
            this.apellido = apellido;
        }
        #endregion
    }
}
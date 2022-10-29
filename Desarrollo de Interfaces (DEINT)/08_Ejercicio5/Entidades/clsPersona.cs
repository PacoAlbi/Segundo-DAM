namespace Entidades
{
    /// <summary>
    /// Clase base o entidad de persistencia
    /// </summary>
    public class clsPersona
    {
        #region Atributos
        public string Nombre { get; set; }
        public string Apellido { get; set; }
        #endregion

        #region Constructores
        public clsPersona() { }
        public clsPersona(string nombre, string apellido)
        {
            Nombre = nombre;
            Apellido = apellido;
        }
        #endregion
    }
}
namespace _10_Ejercicio1_ASP.Models.Entidades
{
    public class clsDepartamentos
    {
        #region Atributos
        private int id;
        private string nombre;
        #endregion

        #region Propiedades
        public int Id { get { return id; } set { id = value; } }
        public string Nombre { get { return nombre; } set { nombre = value; } }
        #endregion

        #region Constructores
        public clsDepartamentos() { }
        public clsDepartamentos(int id, string nombre)
        {
            this.id = id;
            this.nombre = nombre;
        }
        #endregion
    }
}

namespace Entidades
{
    public class clsDepartamentos
    {
        #region Atributos
        private int _id;
        private string _nombre;
        #endregion

        #region Propiedades
        public int id { get { return _id; } set { _id = value; } }
        public string nombre { get { return _nombre; } set { _nombre = value; } }
        #endregion

        #region Constructores
        public clsDepartamentos() { }
        public clsDepartamentos(int id, string nombre)
        {
            this._id = id;
            this._nombre = nombre;
        }
        public clsDepartamentos(string nombre)
        {
            this._nombre = nombre;
        }
        #endregion
    }
}
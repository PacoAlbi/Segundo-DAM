namespace Entidades
{   
    //Entidad de persistencia para definir las misiones.
    public class clsMision
    {
        #region Atributos
        public int Id { get; set; }
        public string NombreMision { get; set; }
        public string Descripcion { get; set; }
        #endregion

        #region Constructores
        public clsMision() { }

        public clsMision(int id, string nombreMision, string descripcion)
        {
            Id = id;
            NombreMision = nombreMision;
            Descripcion = descripcion;
        }
        #endregion
    }
}
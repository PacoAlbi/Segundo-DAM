using System.Reflection.Metadata;

namespace Mandaloriano_Entidades
{
    public class clsMisiones
    {
        #region atributos
        public int Id { get; set; }
        public string Nombre { get; set; }
        public string Descripcion { get; set; }
        public int Recompensa { get; set; }
        #endregion

        #region constructores
        public clsMisiones()
        {
            Id = -1;
            Nombre = "";
            Descripcion = "";
            Recompensa = 0;

        }
        public clsMisiones(int id, string nombre, string descripcion, int recompensa)
        {
            Id = id;
            Nombre = nombre;
            Descripcion = descripcion;
            Recompensa = recompensa;
        }

        #endregion

    }
}
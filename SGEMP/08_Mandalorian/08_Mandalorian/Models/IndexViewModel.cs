using Entidades;

namespace _08_Mandalorian.Models
{
    //Clase que le pasa a mi vista lo que necesita para mostrar, una misión y una lista de misiones.
    public class IndexViewModel
    {
        #region Atributos
        public clsMision Mision { get; set; }
        public List<clsMision> ListaMisiones { get; set; }
        #endregion
        #region Constructores
        public IndexViewModel() { }
        public IndexViewModel(clsMision mision, List<clsMision> listaMisiones)
        {
            Mision = mision;
            ListaMisiones = listaMisiones;
        }
        #endregion
    }
}

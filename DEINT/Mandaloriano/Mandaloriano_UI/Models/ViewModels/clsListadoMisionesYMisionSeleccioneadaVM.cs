using Mandaloriano_Entidades;

namespace Mandaloriano_UI.Models.ViewModels
{
    public class clsListadoMisionesYMisionSeleccioneadaVM
    {
        #region atributos
        public List<clsMisiones> listadoMisiones {get; set; }
        public clsMisiones misionSeleccionada { get; set; }
        #endregion
        #region contructores
        public clsListadoMisionesYMisionSeleccioneadaVM() { 
            listadoMisiones = new List<clsMisiones>();
            misionSeleccionada = new clsMisiones();
        }
        public clsListadoMisionesYMisionSeleccioneadaVM(List<clsMisiones> listadoMisiones, clsMisiones misionSeleccionada)
        {
            this.listadoMisiones = listadoMisiones;
            this.misionSeleccionada = misionSeleccionada;
        }

        #endregion
    }
}

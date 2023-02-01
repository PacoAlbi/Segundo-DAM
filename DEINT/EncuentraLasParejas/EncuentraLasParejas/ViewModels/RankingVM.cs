using BL.Listado;
using EncuentraLasParejas.ViewModels.Utilidades;
using Entidades;
using System.Collections.ObjectModel;


namespace EncuentraLasParejas.ViewModels
{   /// <summary>
    /// ViewModel que muestra la lista de los jugadores y sus tiempos ordenados por tiempo.
    /// </summary>
    public class RankingVM : clsVMBase
    {
        #region Atributos
        private ObservableCollection<clsJugador> listadoJugadores;
        #endregion

        #region Constructores
        public RankingVM()
        { 
            //Pido y ordeno la lista que voy a mostrar.
            listadoJugadores = new ObservableCollection<clsJugador>(clsListadoBL.getListadoJugadoresBL().OrderBy(r => r.Tiempo));
        }
        #endregion

        #region Propiedades
        public ObservableCollection<clsJugador> ListadoJugadores 
        {
            get
            { return listadoJugadores; }
            set
            {
                listadoJugadores = value;
                NotifyPropertyChanged(nameof(ListadoJugadores));
            }
        }
        #endregion
    }
}

using Examen_1_Evaluacion.ViewModel.Utilidades;
using System.Collections.ObjectModel;

namespace Examen_1_Evaluacion.ViewModel
{
    public class JuegoTableroVM : clsVMBase
    {
        #region Atributos
        private string[] _totalCartas;
        private string[] _reverso;
        private ObservableCollection<string> _mazoGenerado;
        private string _cartaSeleccionada;
        private DelegateCommand _pulsarCartaCommand;
        private int _ganar;
        #endregion

        #region Constructores
        public JuegoTableroVM() 
        {
            _ganar= 0;
            _mazoGenerado = generarMazo();
            _pulsarCartaCommand = new DelegateCommand(PulsarCartaCommand_Execute);
            _cartaSeleccionada = null;
        }   
        #endregion

        #region Propiedades
        public ObservableCollection<string> MazoGenerado { get { return _mazoGenerado; } set { _mazoGenerado = value; } }
        public DelegateCommand PulsarCartaCommand { get { return _pulsarCartaCommand;} }
        public string CartaSeleccionada
        {
            get { return _cartaSeleccionada;}
            set 
            {
                _cartaSeleccionada = value;
                NotifyPropertyChanged();
            }
        }
        public string[] Reverso
        {
            get { return _reverso; }
            set
            {
                string[] _reverso = { "reverso.jpg", "reverso.jpg", "reverso.jpg", "reverso.jpg", "reverso.jpg", "reverso.jpg", "reverso.jpg", "reverso.jpg", "reverso.jpg", };
            }

        }
        public int Ganar
        {
            get { return _ganar; }
            set { _ganar = value; }
        } 
        public string[] TotalCartas
        {
            get { return _totalCartas; }
            set { _totalCartas = value;  } }
        #endregion

        #region Commands
        /// <summary>
        /// El Command pillará la carta seleccionada y la comprobará con la lista de cartas, si es buena, suma uno a ganar, si no, uno a perder, al llegar a 3 de cualquiera mostrará un Display alert
        /// </summary>
        public void PulsarCartaCommand_Execute ()
        {
            if (ComprobarResultado())
            {
                Ganar++;
            }
            
        }
        #endregion

        #region Métodos
        /// <summary>
        /// Método para rellenar el mazo con todas las cartas y convertirlo en una Observable para mostrar a la Vista
        /// </summary>
        /// <returns>Observable collection de cartas para mostrar</returns>
        public ObservableCollection<string> generarMazo ()
        {
            TotalCartas = new string[9];
            TotalCartas[0] = "atst.jpg";
            TotalCartas[1] = "babyjoda.jpg";
            TotalCartas[2] = "kraytdragon.jpg";
            TotalCartas[3] = "mandalorian.jpg";
            TotalCartas[4] = "moffgideon.jpg";
            TotalCartas[5] = "mandalorian.jpg";
            TotalCartas[6] = "spider.jpg";
            TotalCartas[7] = "tradoshan.jpg";
            TotalCartas[8] = "babyjoda.jpg";
            ObservableCollection<string> listaAmostrar = new ObservableCollection<string>(TotalCartas);
            return listaAmostrar;
        }
        /// <summary>
        /// Método que comprueba el resultado al pulsar, si es buena (las dos buenas que hay), devuelve true, si es mala, devuelve false.
        /// </summary>
        public bool ComprobarResultado ()
        {
            bool resultado = false;
            if (CartaSeleccionada.Equals("mandalorian.jpg") || CartaSeleccionada.Equals("babyjoda.jpg"))
            {
                resultado = true;
            }
            return resultado;
        }
        #endregion
    }
}

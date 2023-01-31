
using examenDavidCarvajal_UI.Model;
using examenDavidCarvajal_UI.View;
using examenDavidCarvajal_UI.ViewModel.Utilidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace examenDavidCarvajal_UI.ViewModel
{
    public class tableroCartasVM : clsVMBase
    {
        #region Atributos
        private ObservableCollection<clsCarta> cartas;
        private clsCarta cartaSeleccionada;
        private DelegateCommand seleccionarCarta;
        private int cartasDesbloqueadasBuenas;
        private int cartasDesbloqueadasMalas;
        #endregion
        #region Propiedades
        public int CartasDesbloqueadasBuenas
        {
            get { return cartasDesbloqueadasBuenas; }
        }
        public int CartasDesbloqueadasMalas
        {
            get { return cartasDesbloqueadasMalas; }
        }
        public ObservableCollection<clsCarta> Cartas
        {
            get { return cartas; }
        }
        public clsCarta CartaSeleccionada
        {
            get { return cartaSeleccionada; }
            set
            {
                    cartaSeleccionada = value;
                
            }
        }
        public DelegateCommand SeleccionarCarta
        {
            get { return seleccionarCarta; }
        }

        #endregion
        #region Contructores
        public tableroCartasVM()
        {
            cartas = obtenerListadoCartas();
            cartaSeleccionada = new clsCarta();
            seleccionarCarta = new DelegateCommand(seleccionarCarta_Execute);
            cartasDesbloqueadasBuenas = 0;
            cartasDesbloqueadasMalas = 0;
        }
        #endregion
        #region Comandos
        /// <summary>
        /// Accion tras seleccionar una carta, le dara la vuelta a la carta seleccionada, comprobara de que tipo es, aumentando el contador de puntos de ese tipo. También comprobara si el juego a terminado ya o no
        /// </summary>
        private void seleccionarCarta_Execute()
        {
            //Cambiamos la imagen en la vista
            cartaSeleccionada.ImagenMostrada = cartaSeleccionada.TipoCarta;
            //Comprobamos si la imagen ya estaba destapada
            if (!cartaSeleccionada.Destapada)
            {
                //Actualizamos los contadores
                if (cartaSeleccionada.BuenaMala)
                {
                    cartasDesbloqueadasBuenas++;
                    NotifyPropertyChanged(nameof(CartasDesbloqueadasBuenas));
                }
                else
                {
                    cartasDesbloqueadasMalas++;
                    NotifyPropertyChanged(nameof(CartasDesbloqueadasMalas));
                }
                comprobarSiFinal();
            }
            cartaSeleccionada.Destapada = true;
            

        }
        #endregion
        #region MetodosAuxiliares
        /// <summary>
        /// Devolvera un listado con las 9 cartas del juego, ordenadas aleatoriamente
        /// </summary>
        /// <returns></returns>
        private ObservableCollection<clsCarta> obtenerListadoCartas()
        {
            ObservableCollection<clsCarta> cartasTemp = new ObservableCollection<clsCarta>();
            ObservableCollection<clsCarta> cartas = new ObservableCollection<clsCarta>();
            Random rnd = new Random();
            int numeroRandom;
            //Rellenamos la lista
            cartasTemp.Add(new clsCarta("babyJoda.jpg", true));
            cartasTemp.Add(new clsCarta("babyJoda.jpg", true));
            cartasTemp.Add(new clsCarta("mandalorian.jpg", true));
            cartasTemp.Add(new clsCarta("mandalorian.jpg", true));
            cartasTemp.Add(new clsCarta("atst.jpg", false));
            cartasTemp.Add(new clsCarta("kraytdragon.jpg", false));
            cartasTemp.Add(new clsCarta("moffgideon.jpg", false));
            cartasTemp.Add(new clsCarta("spider.jpg", false));
            cartasTemp.Add(new clsCarta("tradoshan.jpg", false));
            //Vamos introdunciendo en la lista vacias las cartas de la lista temporal de forma aleatoria
            for (int i = 0; i < 9; i++)
            {
                numeroRandom = rnd.Next(cartasTemp.Count);
                cartas.Add(cartasTemp[numeroRandom]);
                cartasTemp.Remove(cartasTemp[numeroRandom]);
            }

            return cartas;
        }
        /// <summary>
        /// Comprobara si la partida ha terminado, en el caso de haber terminada mostrara un mensaje preguntando si se quiere seguir jugando
        /// </summary>
        private async void comprobarSiFinal()
        {
            if (cartasDesbloqueadasBuenas == 3)
            {
                mensajeSeguirJugando("Enorabuena, ganaste la partida");
            }
            else if (cartasDesbloqueadasMalas == 3)
            {
                mensajeSeguirJugando("Vaya..., perdiste la partida");
            }
        }
        /// <summary>
        /// Mostrara un mensaje y preguntara al usuario si desea seguir jugando, en caso de responder si, se abrira una nueva pantalla con el tablero, en caso de no cerrara la aplicacion
        /// </summary>
        /// <param name="mensaje">Sera el titulo del mensaje que se mostrara</param>
        private async void mensajeSeguirJugando(string mensaje)
        {
            var respuesta = Application.Current.MainPage.DisplayAlert(
                   mensaje,
                   "Desea seguir jugando?",
                   "Si", "No");
            if (await respuesta)
            {
                //Reiniciamos las variables y notificamos el cambio
                cartas = obtenerListadoCartas();
                cartaSeleccionada = new clsCarta();
                cartasDesbloqueadasBuenas = 0;
                cartasDesbloqueadasMalas = 0;
                NotifyPropertyChanged(nameof(Cartas));
                NotifyPropertyChanged(nameof(CartasDesbloqueadasBuenas));
                NotifyPropertyChanged(nameof(CartasDesbloqueadasMalas));
            }
            else
            {
                App.Current.Quit();
            }
        }
        #endregion
    }
}
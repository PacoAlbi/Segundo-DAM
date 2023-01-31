using BL.Manejadora;
using EncuentraLasParejas.Models;
using EncuentraLasParejas.ViewModels.Utilidades;
using EncuentraLasParejas.Views;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EncuentraLasParejas.ViewModels
{
    public class TableroVM : clsVMBase
    {
        #region Atributos
        private int segundos;
        private Carta cartaSeleccionada;
        private Carta cartaAuxiliar;
        private int contadorFallos;
        private int contadorAciertos;
        private ObservableCollection<Carta> baraja;
        private ObservableCollection<Carta> barajaMostrada;
        private bool haySeleccionada = false;
        private DelegateCommand reiniciarPartida;
        #endregion

        #region Constructores
        public TableroVM()
        {
            cronometro();
            Segundos = 60;
            ContadorFallos = 0;
            ContadorAciertos = 0;
            hacerBaraja();
            BarajaMostrada = barajar(baraja);
            reiniciarPartida = new DelegateCommand(ReiniciarPartida_Executed);
        }
        #endregion

        #region Propiedades
        public Carta CartaSeleccionada
        {
            get
            {
                return cartaSeleccionada;
            }
            set
            {
                cartaSeleccionada = value;
                cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Anverso;

                if (!haySeleccionada)
                {
                    cartaAuxiliar = cartaSeleccionada;
                    haySeleccionada = true;
                }
                else if (cartaSeleccionada.ImagenMostrada.Equals(cartaAuxiliar.ImagenMostrada))
                {
                    contadorAciertos++;
                    haySeleccionada = false;
                }
                else
                {

                    cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Anverso;
                    //NotifyPropertyChanged(nameof(CartaSeleccionada));
                    var t = Task.Run(async delegate

                    {
                        
                        await Task.Delay(1000);
                        cartaAuxiliar.ImagenMostrada = cartaAuxiliar.Reverso;
                        cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Reverso;
                    });
                    t.Wait();

                    contadorFallos++;
                    haySeleccionada = false;
                }
                cartaSeleccionada = null;


            }
        }
        public int Segundos { get { return segundos; } set { segundos = value; NotifyPropertyChanged(nameof(Segundos)); } }
        public ObservableCollection<Carta> BarajaMostrada
        {
            get
            {
                return barajaMostrada;
            }
            set
            {
                barajaMostrada = value;
            }
        }
        public DelegateCommand ReiniciarPartida { get { return reiniciarPartida; } }
        public int ContadorFallos { get { return contadorFallos; } set { contadorFallos = value; } }
        public int ContadorAciertos { get { return contadorAciertos; } set { contadorAciertos = value; } }
        #endregion

        #region Commands
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método para reiniciar la partida.
        /// Postcondiciones: No tiene.
        /// </summary>
        private async void ReiniciarPartida_Executed()
        {
            await Shell.Current.GoToAsync("..");
            //Application.Current.MainPage = new TableroPage();
        }
        #endregion
        #region Métodos
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método para comprobar si ha encontrado todas las parejas e insertar su nombre en el ranking o si ha fallado demasiado.
        /// Postcondiciones: No tiene.
        /// </summary>
        private async void comprobarPartida()
        {
            if (ContadorAciertos == 9)
            {
                clsJugador jugador = new clsJugador();
                jugador.Tiempo = (60 - Segundos);
                jugador.Nombre = await Application.Current.MainPage.DisplayPromptAsync("¡Enhorabuena!", "Ha encontrado las 9 parejas en " + jugador.Tiempo + " segundos.", "Guardar", "Cancelar", "Introduzca su nombre");
                clsManejadoraBL.insertarJugadorBL(jugador);
                await Shell.Current.GoToAsync("..");
            }
            else if (ContadorFallos == 5)
            {
                preguntarJugar("Lo siento, ha fallado demasiadas veces.");
            }
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método que carga las cartas en la baraja.
        /// Postcondiciones: No tiene.
        /// </summary>
        private void hacerBaraja()
        {
            baraja = new ObservableCollection<Carta>();
            baraja.Add(new Carta("capitanamerica.png", "background2.png"));
            baraja.Add(new Carta("capitanamerica.png", "background2.png"));
            baraja.Add(new Carta("hulk.png", "background2.png"));
            baraja.Add(new Carta("hulk.png", "background2.png"));
            baraja.Add(new Carta("ironman.png", "background2.png"));
            baraja.Add(new Carta("ironman.png", "background2.png"));
            baraja.Add(new Carta("spiderman.png", "background2.png"));
            baraja.Add(new Carta("spiderman.png", "background2.png"));
            baraja.Add(new Carta("thor.png", "background2.png"));
            baraja.Add(new Carta("thor.png", "background2.png"));
            baraja.Add(new Carta("viudanegra.png", "background2.png"));
            baraja.Add(new Carta("viudanegra.png", "background2.png"));
            baraja.Add(new Carta("missmarvel.png", "background2.png"));
            baraja.Add(new Carta("missmarvel.png", "background2.png"));
            baraja.Add(new Carta("vision.png", "background2.png"));
            baraja.Add(new Carta("vision.png", "background2.png"));
            baraja.Add(new Carta("deadpool.png", "background2.png"));
            baraja.Add(new Carta("deadpool.png", "background2.png"));
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método que ordena la baraja aleatoriamente.
        /// Postcondiciones: Devuelve la baraja ordenada aleatoriamente.
        /// </summary>
        /// <param name="cartas">List de Carta</param>
        /// <returns>ObservableCollection Carta</returns>
        private ObservableCollection<Carta> barajar(ObservableCollection<Carta> cartas)
        {
            var rnd = new Random();
            var baraja = cartas.OrderBy(x => rnd.Next());
            return new ObservableCollection<Carta>(baraja);
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método para mostrar y controlar el tiempo de la partida.
        /// Postcondiciones: No tiene.
        /// </summary>
        [Obsolete]
        public void cronometro()
        {
            Device.StartTimer(TimeSpan.FromSeconds(1), () =>
            {
                Segundos--;
                if (Segundos == 0)
                {
                    preguntarJugar("El tiempo se ha agotado");
                    return false;
                }
                else
                {
                    return true;
                }
            });
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método que controla, al terminar la partida, si se desea jugar otra partida o no.
        /// Postcondiciones: Sigue o para el juego.
        /// </summary>
        /// <param name="mensaje">String con el mensaje</param>
        private async void preguntarJugar(string mensaje)
        {
            bool volverAjugar = await Application.Current.MainPage.DisplayAlert(mensaje, "¿Jugar otra partida?", "Sí", "No");
            if (volverAjugar)
            {
                //Application.Current.MainPage = new TableroPage();
                await Shell.Current.GoToAsync("///TableroPage");
            }
            else
            {
                //await Shell.Current.GoToAsync("..");
                await Shell.Current.GoToAsync("//MainPage");
                //Application.Current.Quit();
            }
        }
        #endregion
    }
}

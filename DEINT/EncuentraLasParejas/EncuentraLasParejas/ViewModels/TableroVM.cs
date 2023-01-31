using BL.Manejadora;
using EncuentraLasParejas.Models;
using EncuentraLasParejas.ViewModels.Utilidades;
using Entidades;
using System.Collections.ObjectModel;

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
        private bool seguir;
        #endregion

        #region Constructores
        public TableroVM()
        {
            Seguir = true;
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
                //Pillo la carta.
                cartaSeleccionada = value;
                //Muestro la imagen para que se vea.
                cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Anverso;
                //Compruebo que haya alguna seleccionada antes.
                if (!haySeleccionada)
                {
                    //Si no la hay, la pongo en una auxiliar para seguir mostrándola.
                    cartaAuxiliar = cartaSeleccionada;
                    //Aviso que ya hay una seleccionada.
                    haySeleccionada = true;
                }
                //Como ya hay una visible, compruebo si se ha acertado en la segunda.
                else if (cartaSeleccionada.ImagenMostrada.Equals(cartaAuxiliar.ImagenMostrada))
                {
                    //Aumento el contador de aciertos.
                    contadorAciertos++;
                    //Notifico a la vista el cambio.
                    NotifyPropertyChanged(nameof(ContadorAciertos));
                    //Aviso que la siguiente es nueva pareja.
                    haySeleccionada = false;
                    //Compruebo si se han alcanzado las condiciones de victoria.
                    comprobarPartida();
                }
                //Si no se ha acertado.
                else
                {
                    //var t = Task.Run(async delegate ESTE NO FUNCIONA
                    //{
                    //    await Task.Delay(1000);
                    //    cartaAuxiliar.ImagenMostrada = cartaAuxiliar.Reverso;
                    //    cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Reverso;
                    //});
                    //t.Wait();  
                    //Device.StartTimer(TimeSpan.FromSeconds(1), () => ESTE ME DICE QUE ESTA OBSOLETO
                    //{
                    //    vistazo--;
                    //    if (vistazo == 0)
                    //    {
                    //        cartaAuxiliar.ImagenMostrada = cartaAuxiliar.Reverso;
                    //        NotifyPropertyChanged(nameof(cartaAuxiliar));
                    //        cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Reverso;
                    //        return false;
                    //    }
                    //    else
                    //    {
                    //        return true;
                    //    }
                    //}); 
                    //Creo un contador de tiempo
                    int vistazo = 1;
                    //Inicio una variable de tiempo.
                    var VistazoTimer = Application.Current.Dispatcher.CreateTimer();
                    //Ajusto el intervalo de visualizado.
                    VistazoTimer.Interval = TimeSpan.FromSeconds(1);
                    //Resto el tiempo, doy la vuelta a las cartas y notifico el cambio.
                    VistazoTimer.Tick += (s, e) => {
                        vistazo--;
                        if (vistazo == 0)
                        {
                            cartaAuxiliar.ImagenMostrada = cartaAuxiliar.Reverso;
                            NotifyPropertyChanged(nameof(cartaAuxiliar));
                            cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Reverso;                         
                        }                  
                    };
                    //Inicio el tiempo.
                    VistazoTimer.Start();
                    //Actualizo el contador de fallos.
                    contadorFallos++;
                    //Aviso que la siguiente es nueva pareja.
                    haySeleccionada = false;
                    //Compruebo si se han alcanzado las condiciones de victoria.
                    comprobarPartida();
                }
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
        public bool Seguir { get { return seguir; } set { seguir = value; } }
        #endregion

        #region Commands
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método para reiniciar la partida.
        /// Postcondiciones: No tiene.
        /// </summary>
        private async void ReiniciarPartida_Executed()
        {       
            Seguir = false;
            Application.Current.MainPage = new AppShell();
            await Shell.Current.GoToAsync("//TableroPage");
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
                Seguir = false;
                clsJugador jugador = new clsJugador();
                jugador.Tiempo = (60 - Segundos);
                jugador.Nombre = await Application.Current.MainPage.DisplayPromptAsync("¡Enhorabuena!", "Ha encontrado las 9 parejas en " + jugador.Tiempo + " segundos.", "Guardar", "Cancelar", "Introduzca su nombre");
                clsManejadoraBL.insertarJugadorBL(jugador);               
                Application.Current.MainPage = new AppShell();
            }
            else if (ContadorFallos == 16)
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
            baraja = new ObservableCollection<Carta>
            {
                new Carta("capitanamerica.png", "background2.png"),
                new Carta("capitanamerica.png", "background2.png"),
                new Carta("hulk.png", "background2.png"),
                new Carta("hulk.png", "background2.png"),
                new Carta("ironman.png", "background2.png"),
                new Carta("ironman.png", "background2.png"),
                new Carta("spiderman.png", "background2.png"),
                new Carta("spiderman.png", "background2.png"),
                new Carta("thor.png", "background2.png"),
                new Carta("thor.png", "background2.png"),
                new Carta("viudanegra.png", "background2.png"),
                new Carta("viudanegra.png", "background2.png"),
                new Carta("loky.png", "background2.png"),
                new Carta("loky.png", "background2.png"),
                new Carta("vision.png", "background2.png"),
                new Carta("vision.png", "background2.png"),
                new Carta("deadpool.png", "background2.png"),
                new Carta("deadpool.png", "background2.png")
            };
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
                else if (!Seguir)
                {        
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
            Seguir = false;
            bool volverAjugar = await Application.Current.MainPage.DisplayAlert(mensaje, "¿Jugar otra partida?", "Sí", "No");
            if (volverAjugar)
            {
                Application.Current.MainPage = new AppShell();
                await Shell.Current.GoToAsync("//TableroPage");
            }
            else
            {                
                Application.Current.MainPage = new AppShell();
            }           
        }
        #endregion
    }
}
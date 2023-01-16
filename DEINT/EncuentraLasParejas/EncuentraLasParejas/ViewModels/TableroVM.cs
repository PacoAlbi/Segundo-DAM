using EncuentraLasParejas.Models;
using EncuentraLasParejas.ViewModels.Utilidades;
using EncuentraLasParejas.Views;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EncuentraLasParejas.ViewModels
{
    public class TableroVM : clsVMBase
    {
        #region Atributos
        private CartaNotify cartaSeleccionada;
        private CartaNotify cartaAuxiliar;
        private int parejasEncontradas;
        private ObservableCollection<CartaNotify> baraja;
        private ObservableCollection<CartaNotify> barajaMostrada;
        private bool haySeleccionada = false;
        #endregion

        #region Propiedades
        public CartaNotify CartaSeleccionada
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
                    parejasEncontradas++;
                    haySeleccionada = false;
                }
                else
                {
                    cartaAuxiliar.ImagenMostrada = cartaAuxiliar.Reverso;
                    cartaSeleccionada.ImagenMostrada = cartaSeleccionada.Reverso;
                    haySeleccionada = false;
                }
            }
        }
        public ObservableCollection<CartaNotify> BarajaMostrada 
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
        #endregion

        #region Constructores
        public TableroVM()
        {
            parejasEncontradas = 0;
            hacerBaraja();
            BarajaMostrada = barajar(baraja);
        }
        #endregion

        #region Métodos
        private void hacerBaraja()
        {
            baraja = new ObservableCollection<CartaNotify>();     
            baraja.Add(new CartaNotify("capitanamerica.png", "background2.png"));
            baraja.Add(new CartaNotify("capitanamerica.png", "background2.png"));
            baraja.Add(new CartaNotify("hulk.png", "background2.png"));
            baraja.Add(new CartaNotify("hulk.png", "background2.png"));
            baraja.Add(new CartaNotify("ironman.png", "background2.png"));
            baraja.Add(new CartaNotify("ironman.png", "background2.png"));
            baraja.Add(new CartaNotify("spiderman.png", "background2.png"));
            baraja.Add(new CartaNotify("spiderman.png", "background2.png"));
            baraja.Add(new CartaNotify("thor.png", "background2.png"));
            baraja.Add(new CartaNotify("thor.png", "background2.png"));
            baraja.Add(new CartaNotify("viudanegra.png", "background2.png"));
            baraja.Add(new CartaNotify("viudanegra.png", "background2.png"));
            baraja.Add(new CartaNotify("missmarvel.png", "background2.png"));
            baraja.Add(new CartaNotify("missmarvel.png", "background2.png"));
            baraja.Add(new CartaNotify("vision.png", "background2.png"));
            baraja.Add(new CartaNotify("vision.png", "background2.png"));
            baraja.Add(new CartaNotify("deadpool.png", "background2.png"));
            baraja.Add(new CartaNotify("deadpool.png", "background2.png"));
        }
        private ObservableCollection<CartaNotify> barajar (ObservableCollection<CartaNotify> cartas)
        {
            var rnd = new Random();
            var baraja = cartas.OrderBy(x => rnd.Next());
            return new ObservableCollection<CartaNotify>(baraja);
        }
        private void jugar()
        {
            
        }
        private void temporizador()
        {

        }
        public static void StartTimer(TimeSpan interval, Func<bool> callback)
        {

        }
        private async void preguntarJugar(string mensaje)
        {
            bool volverAjugar = await Application.Current.MainPage.DisplayAlert(mensaje, "¿Jugar otra partida?", "Sí", "No");
            if (volverAjugar)
            {
                Application.Current.MainPage = new TableroPage();
            }
            else
            {
                Application.Current.Quit();
            }
        }
        #endregion
    }
}

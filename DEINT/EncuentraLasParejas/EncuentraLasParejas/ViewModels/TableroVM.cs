using EncuentraLasParejas.ViewModels.Utilidades;
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
        private Carta cartaSeleccionada;
        private int parejasEncontradas;
        private List<Carta> baraja;
        private ObservableCollection<Carta> barajaMostrada;
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
                NotifyPropertyChanged(nameof(CartaSeleccionada));
            }
        }
        public ObservableCollection<Carta> BarajaMostrada 
        { 
            get 
            { 
                return barajaMostrada; 
            } 
        }
        #endregion

        #region Constructores
        public TableroVM()
        {
            hacerBaraja();
            barajar();
            jugar();
        }
        #endregion

        #region Métodos
        private void hacerBaraja()
        {
            baraja = new List<Carta>
            {
                new Carta(1, "capitanamerica.png", "background2.png"),
                new Carta(2, "hulk.png", "background2.png"),
                new Carta(3, "ironman.png", "background2.png"),
                new Carta(4, "spiderman.png", "background2.png"),
                new Carta(5, "thor.png", "background2.png"),
                new Carta(6, "viudanegra.png", "background2.png"),
                new Carta(7, "missmarvel.png", "background2.png"),
                new Carta(8, "vision.png", "background2.png"),
                new Carta(9, "deadpool.png", "background2.png")
            };
        }
        private void barajar()
        {
            barajaMostrada = new ObservableCollection<Carta>();
            int contId1 = 0, contId2 = 0, contId3 = 0, contId4 = 0, contId5 = 0, contId6 = 0, contId7 = 0, contId8 = 0, contId9 = 0;
            Carta cartaAinsertar;
            for (int i = 0; i < 18; i++)
            {
                cartaAinsertar = new Carta(baraja[new Random().Next(1, baraja.Count)]);
                if (cartaAinsertar.Id == 1 && contId1 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId1++;
                }
                else if (cartaAinsertar.Id == 2 && contId2 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId2++;
                }
                else if (cartaAinsertar.Id == 3 && contId3 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId3++;
                }
                else if (cartaAinsertar.Id == 4 && contId4 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId4++;
                }
                else if (cartaAinsertar.Id == 5 && contId5 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId5++;
                }
                else if (cartaAinsertar.Id == 6 && contId6 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId6++;
                }
                else if (cartaAinsertar.Id == 7 && contId7 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId7++;
                }
                else if (cartaAinsertar.Id == 8 && contId8 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId8++;
                }
                else if (cartaAinsertar.Id == 9 && contId9 < 2)
                {
                    barajaMostrada[i] = cartaAinsertar;
                    contId9++;
                }
            }
        }
        private void jugar()
        {
            foreach (Carta carta in barajaMostrada)
            {
                cartaSeleccionada = carta;
            }
        }
        private async void preguntarJugar(string mensaje)
        {
            bool volverAjugar = await Application.Current.MainPage.DisplayAlert(mensaje, "¿Jugar otra partida?", "Sí", "No");
            if (volverAjugar)
            {
                //iniciarJuego();
            }
            else
            {
                Application.Current.Quit();
            }
        }
        #endregion
    }
}

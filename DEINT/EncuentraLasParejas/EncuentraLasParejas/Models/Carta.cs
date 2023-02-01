using EncuentraLasParejas.ViewModels.Utilidades;
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace EncuentraLasParejas.Models
{
    public class Carta : clsVMBase
    {
        #region Atributos
        private string anverso;
        private string reverso;
        private string imagenMostrada;       
        #endregion

        #region Propiedades
        public string Anverso { get { return anverso; } set { anverso = value; } }
        public string Reverso { get { return reverso; } set { reverso = value; } }
        public string ImagenMostrada 
        { 
            get 
            { 
                return imagenMostrada; 
            } 
            set 
            { 
                //Notifico aquí el cambio de la imagen.
                imagenMostrada = value;
                NotifyPropertyChanged(nameof(ImagenMostrada));
            } 
        }
        #endregion

        #region Constructores
        public Carta() { }
        public Carta(string anverso, string reverso)
        {
            Anverso = anverso;
            Reverso = reverso;
            ImagenMostrada = reverso;
        }
        public Carta(Carta carta)
        {
            anverso = carta.Anverso;
            reverso = carta.Reverso;
            ImagenMostrada = carta.reverso;
        }
        #endregion
    }
}
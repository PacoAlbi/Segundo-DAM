using Entidades;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EncuentraLasParejas.Models
{
    public class CartaNotify : Carta, INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;
        protected virtual void NotifyPropertyChanged(string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
        public new string ImagenMostrada 
        { 
            get 
            {
                return base.ImagenMostrada;
            } 
            set 
            {
                base.ImagenMostrada = value;
                NotifyPropertyChanged(nameof(ImagenMostrada));
            }
        }
        #region Constructores
        public CartaNotify() { }
        public CartaNotify(string anverso, string reverso)
        {
            Anverso = anverso;
            Reverso = reverso;
            ImagenMostrada = reverso;
        }
        public CartaNotify(Carta carta)
        {
            base.Anverso = carta.Anverso;
            base.Reverso = carta.Reverso;
            base.ImagenMostrada = carta.Reverso;
        }
        #endregion
    }
}

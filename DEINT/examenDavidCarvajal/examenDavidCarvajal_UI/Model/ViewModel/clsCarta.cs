
using examenDavidCarvajal_UI.ViewModel.Utilidades;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace examenDavidCarvajal_UI.Model
{
    public class clsCarta : clsVMBase
    {
        #region Atributos;
        public string TipoCarta { get; }
        private string imagenMostrada;
        public bool BuenaMala { get; set; }//sera true si la carta es buena y false si la carta es mala
        public bool Destapada { get; set; }
        #endregion
        public string ImagenMostrada
        {
            get { return imagenMostrada; }
            set
            {
                imagenMostrada = value;
                NotifyPropertyChanged(nameof(ImagenMostrada));
            }
        }
        #region Contructores
        public clsCarta()
        {
            TipoCarta = "";
            ImagenMostrada = "";
            BuenaMala = false;
            Destapada = false;
        }

        public clsCarta(string tipoCarta, bool buenaMala)
        {
            TipoCarta = tipoCarta;
            ImagenMostrada = "reverso.jpg";
            BuenaMala = buenaMala;
            Destapada = false;
        }

        #endregion
    }
}

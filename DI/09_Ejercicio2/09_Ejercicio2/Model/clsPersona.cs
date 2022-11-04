using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace _09_Ejercicio2.Model  //hay que pasar este namespace al xaml o peta
{
    public class clsPersona : INotifyPropertyChanged
    {
        #region Atributos
        private string nombre;
        #endregion

        #region Propiedades
        public string Nombre
        {
            get { return nombre; }
            set
            {
                nombre = value;
                NotifyPropertyChanged();  //Dentro de los parentesis pasamos las propiedades que deben mandarse, o 
                //ninguna cosa, porque abajo pilla el nombre de la propiedad que lo esta llamando
            }
        }
        
        public clsPersona()
        {
            Nombre = "Paco";
        }    
        public clsPersona(string nombre)
        {
            Nombre = nombre;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName] String propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
        #endregion
    }
}

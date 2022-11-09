using Entities;
using System.ComponentModel;
using System.Runtime.CompilerServices;

namespace _09_Ejercicio3.ViewModels
{
    public class PersonaVM : INotifyPropertyChanged
    {
        private string nombre;
        private clsPersona persona;

        public string Nombre
        {
            get { return nombre; }
            set
            {
                nombre = value;
                this.persona.Nombre = nombre;
                NotifyPropertyChanged();
            }
        }

        public PersonaVM()
        {
            persona = new clsPersona();
            this.nombre = "Paco";            
        }

     
        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName] string propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}

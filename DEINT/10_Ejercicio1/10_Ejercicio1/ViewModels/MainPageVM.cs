using _10_Ejercicio1.ViewModels.Utilidades;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10_Ejercicio1.ViewModels
{
    public class MainPageVM : clsVMBase
    {
        #region Atributos
        private DelegateCommand mostrarDescripcion;
        private ObservableCollection<clsPersona> listadoDePersonas;
        private clsPersona personaSeleccionada;
        private bool visibilidadBoton;
        private bool visibilidadLupa;
        #endregion

        public DelegateCommand MostrarDescripcion
        {
            get
            {
                mostrarDescripcion = new DelegateCommand(MostrarDescripcion_Executed, MostrarDescripcion_CanExecute);
                return mostrarDescripcion;
            }
        }




    }
}

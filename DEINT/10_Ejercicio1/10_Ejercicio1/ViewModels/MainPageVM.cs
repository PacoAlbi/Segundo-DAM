using _10_Ejercicio1.ViewModels.Utilidades;
using DAL;
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
        private DelegateCommand eliminarCommand;
        private ObservableCollection<clsPersona> listadoDePersonasCompleto;
        private ObservableCollection<clsPersona> listadoDePersonasMostrado;
        private clsPersona personaSeleccionada;
        #endregion

        #region Constructores
        public MainPageVM()
        {
            listadoDePersonasCompleto = new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasCompleto());
        }
        #endregion

        #region Propiedades
        public clsPersona PersonaSeleccionada
        {
            get
            {
                return personaSeleccionada;
            }
            set
            {
                personaSeleccionada = value;
                eliminarCommand.RaiseCanExecuteChanged();
            }
        }

        public ObservableCollection<clsPersona> ListadoDePersonas
        {
            get { return listadoDePersonasCompleto; }
        }

        public ObservableCollection<clsPersona> ListadoSeleccionado
        {
            get { return listadoDePersonasMostrado; }
        }


        #endregion

    }
}

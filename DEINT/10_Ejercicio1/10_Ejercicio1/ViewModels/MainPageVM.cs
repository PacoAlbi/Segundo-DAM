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
        private DelegateCommand buscarCommand;
        private ObservableCollection<clsPersona> listadoDePersonasCompleto;
        private ObservableCollection<clsPersona> listadoDePersonasMostrado;
        private clsPersona personaSeleccionada;
        private string cadena;
        private Boolean estasBuscando = false;
        #endregion

        #region Constructores
        public MainPageVM()
        {
            eliminarCommand = new DelegateCommand(EliminarCommand_Executed, EliminarCommand_CanExecute);
            listadoDePersonasCompleto = new ObservableCollection<clsPersona>(clsListadoPersonasDAL.getListadoPersonasCompleto());
            listadoDePersonasMostrado = new ObservableCollection<clsPersona>(listadoDePersonasCompleto);
            cadena = null;
            personaSeleccionada= null;
        }
        #endregion

        #region Propiedades
        public Boolean EstasBuscando
        {
            get
            { 
                return estasBuscando; 
            }

        }
        public string Cadena
        {
            get
            { return cadena; }
            set
            {
                cadena = value;
                buscarCommand.RaiseCanExecuteChanged();
                if (!String.IsNullOrEmpty(Cadena))
                {
                    estasBuscando = true;
                }
                else
                {
                    estasBuscando=false;                    
                }
                NotifyPropertyChanged("EstasBuscando");
            }
        }
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

        public ObservableCollection<clsPersona> ListadoDePersonasCompleto
        {
            get 
            { 
                return listadoDePersonasCompleto; 
            }
            set 
            {
                listadoDePersonasCompleto = value;
                NotifyPropertyChanged();
            }
        }

        public ObservableCollection<clsPersona> ListadoDePersonasMostrado
        {
            get 
            { 
                return listadoDePersonasMostrado; 
            }
            set
            {
                listadoDePersonasMostrado = value;
                NotifyPropertyChanged();
            }
        }

        public DelegateCommand EliminarCommand
        {

            get
            {
                return eliminarCommand;
            }
        }

        public DelegateCommand BuscarCommand
        {
            get
            {
                buscarCommand = new DelegateCommand(BuscarCommand_Executed, BuscarCommand_CanExecute);
                return buscarCommand;
            }
        }
        #endregion

        #region Commands
        private void EliminarCommand_Executed()
        {
            listadoDePersonasCompleto.Remove(personaSeleccionada);
            personaSeleccionada = null;
            eliminarCommand.RaiseCanExecuteChanged();
            //NotifyPropertyChanged(); //Si es una observableCol, ya notifica el cambio, pero si es de una BBDD, hay que ponerlo, ya que es el bloque entero.
        }

        private bool EliminarCommand_CanExecute()
        {
            bool btnEliminar = true;
            if (personaSeleccionada == null)
            {
                btnEliminar = false;
            }
            return btnEliminar;
        }

        private void BuscarCommand_Executed()
        {
            

            NotifyPropertyChanged();
        }

        private bool BuscarCommand_CanExecute()
        {
            bool btnBuscador = true;
            if (String.IsNullOrEmpty(cadena))
            {
                btnBuscador = false;
            }
            return btnBuscador;
        }

        #endregion

        #region Metodos
        private ObservableCollection<clsPersona> BuscarPersonasCon (string cadena)
        {
            List<clsPersona> listadoCompletoPersonas = clsListadoPersonasDAL.getListadoPersonasCompleto();
            ObservableCollection<clsPersona> listadoDePersonasMostrado = new ObservableCollection<clsPersona>();

            listadoDePersonasMostrado.Add(listadoCompletoPersonas.Find(x => x.Nombre.Contains(cadena) || x.Apellido.Contains(cadena)));

            return listadoDePersonasMostrado;
        }
        #endregion
    }
}

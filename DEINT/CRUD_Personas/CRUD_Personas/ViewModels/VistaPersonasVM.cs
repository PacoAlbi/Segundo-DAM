using BL.Listados;
using CRUD_Personas.ViewModels.Utilidades;
using DAL.Listados;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CRUD_Personas.ViewModels
{
    public class VistaPersonasVM : clsVMBase
    {
        #region Atributos
        private DelegateCommand eliminarCommand;
        private DelegateCommand editarCommand;
        private DelegateCommand buscarCommand;
        private ObservableCollection<clsPersona> listadoDePersonasCompleto;
        private ObservableCollection<clsPersona> listadoDePersonasMostrado;
        private clsPersona personaSeleccionada;
        private string cadena;
        #endregion

        #region Constructores
        public VistaPersonasVM() 
        {
            buscarCommand = new DelegateCommand(BuscarCommand_Executed, BuscarCommand_CanExecute);
            eliminarCommand = new DelegateCommand(EliminarCommand_Executed, EliminarCommand_CanExecute);
            editarCommand = new DelegateCommand(EditarCommand_Executed);
            listadoDePersonasCompleto = new ObservableCollection<clsPersona>(clsListadoPersonasBL.getListadoPersonasBL());
            listadoDePersonasMostrado = new ObservableCollection<clsPersona>(listadoDePersonasCompleto);
            personaSeleccionada = null;
            cadena = null;
        }
        #endregion

        #region Propiedades
        public string Cadena
        {
            get
            { return cadena; }
            set
            {
                cadena = value;
                buscarCommand.RaiseCanExecuteChanged();
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
                editarCommand.RaiseCanExecuteChanged();
                eliminarCommand.RaiseCanExecuteChanged();
            }
        }
        public ObservableCollection<clsPersona> ListadoPersonasCompleto
        {
            get
            {
                return listadoDePersonasCompleto;   
            }
            set
            {
                listadoDePersonasCompleto = value;
            }
        }
        public DelegateCommand BuscarCommand { get { return buscarCommand; } }
        public DelegateCommand EliminarCommand { get { return eliminarCommand;} }
        public DelegateCommand EditarCommand { get { return editarCommand; } }
        #endregion

        #region Commands
        private void BuscarCommand_Executed()
        {
            BuscarPersonas(cadena);
            NotifyPropertyChanged();
            buscarCommand.RaiseCanExecuteChanged();
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
        private void EliminarCommand_Executed() 
        {
            listadoDePersonasCompleto.Remove(personaSeleccionada);
            personaSeleccionada = null;
            eliminarCommand.RaiseCanExecuteChanged();
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
        private void EditarCommand_Executed() { }
        #endregion

        #region Metodos
        private ObservableCollection<clsPersona> BuscarPersonas (string cadenaABuscar)
        {
            ObservableCollection<clsPersona> listadoCompletoPersonas = clsListadoPersonasBL.getListadoPersonasBL();
            ObservableCollection<clsPersona> listadoDePersonasMostrado = new ObservableCollection<clsPersona>();

            //listadoDePersonasMostrado.Add(listadoCompletoPersonas.Find(x => x.Nombre.Contains(cadena) || x.Apellido.Contains(cadena)));
            return listadoDePersonasMostrado;
        }
        #endregion
    }
}

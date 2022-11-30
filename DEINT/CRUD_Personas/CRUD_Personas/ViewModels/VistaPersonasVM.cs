using BL.Listados;
using BL.Manejadoras;
using CRUD_Personas.ViewModels.Utilidades;
using Entidades;
using System.Collections.ObjectModel;

namespace CRUD_Personas.ViewModels
{
    public class VistaPersonasVM : clsVMBase
    {
        #region Atributos
        private DelegateCommand crearCommand;
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
            crearCommand = new DelegateCommand(CrearCommand_Executed);
            buscarCommand = new DelegateCommand(BuscarCommand_Executed, BuscarCommand_CanExecute);
            eliminarCommand = new DelegateCommand(EliminarCommand_Executed, EliminarCommand_CanExecute);
            editarCommand = new DelegateCommand(EditarCommand_Executed, EditarCommand_CanExecute);
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
                NotifyPropertyChanged();
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
                NotifyPropertyChanged("PersonaSeleccionada");
                editarCommand.RaiseCanExecuteChanged();
                eliminarCommand.RaiseCanExecuteChanged();
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
            }
        }
        public DelegateCommand CrearCommand { get { return crearCommand; } }
        public DelegateCommand BuscarCommand { get { return buscarCommand; } }
        public DelegateCommand EliminarCommand { get { return eliminarCommand;} }
        public DelegateCommand EditarCommand { get { return editarCommand; } }
        #endregion

        #region Commands
        /// <summary>
        /// Comando para crear a la persona.
        /// </summary>
        private void CrearCommand_Executed()
        {

        }
        /// <summary>
        /// Comando para buscar a la persona.
        /// </summary>
        private void BuscarCommand_Executed()
        {
            BuscarPersonas(cadena);
            NotifyPropertyChanged();
            buscarCommand.RaiseCanExecuteChanged();
        }
        /// <summary>
        /// Comando para habilitar o deshabilitar el botón de buscar.
        /// </summary>
        /// <returns>Un booleano que avisa de que hay que habilitar o deshabilitar el botón.</returns>
        private bool BuscarCommand_CanExecute()
        {
            bool btnBuscador = true;
            if (String.IsNullOrEmpty(cadena))
            {
                btnBuscador = false;
            }
            return btnBuscador;
        }
        /// <summary>
        /// Comando para eliminar a la persona.
        /// </summary>
        private async void EliminarCommand_Executed() 
        {
            bool eliminar = await App.Current.MainPage.DisplayAlert("Eliminar", "¿Seguro que desea eliminar a la persona?", "Si", "No");
            if (eliminar == true)
            {
                listadoDePersonasCompleto.Remove(personaSeleccionada);
                listadoDePersonasMostrado.Remove(personaSeleccionada);
                try
                {
                    clsManejadoraPersonas.borrarPersonaBL(personaSeleccionada.Id);
                    personaSeleccionada = null;
                    eliminarCommand.RaiseCanExecuteChanged();
                    editarCommand.RaiseCanExecuteChanged();
                    NotifyPropertyChanged("ListadoDePersonasMostrado");
                }
                catch
                {
                    await App.Current.MainPage.DisplayAlert("Alerta", "Error eliminanado la persona de la BBDD", "OK");
                }
            }
        }
        /// <summary>
        /// Comando para habilitar o deshabilitar el botón de eliminar.
        /// </summary>
        /// <returns>Un booleano que avisa de que hay que habilitar o deshabilitar el botón.</returns>
        private bool EliminarCommand_CanExecute() 
        {
            bool btnEliminar = false;
            if (personaSeleccionada != null)
            {
                btnEliminar = true;
            }
            return btnEliminar;
        }
        /// <summary>
        /// Comando para editar a la persona.
        /// </summary>
        private void EditarCommand_Executed() 
        {
            var miDiccionario = new Dictionary<string, object>
            {
                {"personaParaMandar", personaSeleccionada }
            };
            
        }
        /// <summary>
        /// Comando para habilitar o deshabilitar el botón de editar.
        /// </summary>
        /// <returns>Un booleano que avisa de que hay que habilitar o deshabilitar el botón.</returns>
        private bool EditarCommand_CanExecute()
        {
            bool btnEditar = false;
            if (personaSeleccionada != null)
            {
                btnEditar = true;
            }
            return btnEditar;
        }
        #endregion

        #region Metodos
        /// <summary>
        /// Método para buscar dentro de la lista una persona o varias personas en concreto mediante una cadena que buscará dentro de la lista.
        /// </summary>
        /// <param name="cadenaABuscar">String con la cadena a buscar.</param>
        /// <returns>Devuelve la ObservableCollection con las personas buscadas.</returns>
        private ObservableCollection<clsPersona> BuscarPersonas (string cadenaABuscar)
        {
            List<clsPersona> listaAuxiliar = new List<clsPersona>(listadoDePersonasCompleto);
            listadoDePersonasMostrado.Add(listaAuxiliar.Find(x=> x.Nombre.Contains(cadena) || x.Apellidos.Contains(cadena)));
            return listadoDePersonasMostrado;
        }
        #endregion
    }
}
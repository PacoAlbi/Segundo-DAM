using BL.Listados;
using BL.Manejadoras;
using CRUD_Personas.ViewModels.Utilidades;
using Entidades;
using System.Collections.ObjectModel;

namespace CRUD_Personas.ViewModels
{
    /// <summary>
    /// ViewModel para mostrar en la vista de la lista de personas con sus nombres de departamentos.
    /// </summary>
    public class VistaPersonasVM : clsVMBase
    {
        #region Atributos
        private DelegateCommand crearCommand;
        private DelegateCommand eliminarCommand;
        private DelegateCommand editarCommand;
        private DelegateCommand buscarCommand;
        private DelegateCommand detallesCommand;
        private ObservableCollection<clsPersona> listadoDePersonasCompleto;
        private ObservableCollection<clsPersona> listadoDePersonasMostrado;
        private clsPersona personaSeleccionada;
        private string cadena;
        #endregion

        #region Constructores
        public VistaPersonasVM() 
        {
            crearCommand = new DelegateCommand(CrearCommand_Executed);
            buscarCommand = new DelegateCommand(BuscarCommand_Executed);
            eliminarCommand = new DelegateCommand(EliminarCommand_Executed, EliminarCommand_CanExecute);
            editarCommand = new DelegateCommand(EditarCommand_ExecutedAsync, EditarCommand_CanExecute);
            detallesCommand = new DelegateCommand(DetallesCommand_Execute, DetallesCommand_CanExecute);
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
                NotifyPropertyChanged();
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
        public DelegateCommand DetallesCommand { get { return detallesCommand; } }
        #endregion

        #region Commands
        /// <summary>
        /// Precondiciones: No tiene.
        /// Command que me manda a la vista de crear personas.
        /// Postcondiciones: Navegas a la vista de crear personas.
        /// </summary>
        private async void CrearCommand_Executed()
        {
            await Shell.Current.GoToAsync("CrearPersona");
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Command que busca una persona en la lista.
        /// Postcondiciones: Muestra las coincidencias.
        /// </summary>
        private void BuscarCommand_Executed()
        {
            BuscarPersonas();
            NotifyPropertyChanged(nameof(ListadoDePersonasMostrado));
            NotifyPropertyChanged(nameof(PersonaSeleccionada));
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando para editar una persona de la BBDD.
        /// Postcondiciones: Edita una persona de la BBDD.
        /// </summary>
        private async void EliminarCommand_Executed() 
        {
            bool eliminar = await App.Current.MainPage.DisplayAlert("Eliminar", "¿Seguro que desea eliminar a la persona?", "Si", "No");
            if (eliminar == true)
            {
                listadoDePersonasCompleto.Remove(PersonaSeleccionada);
                ListadoDePersonasMostrado.Remove(PersonaSeleccionada);
                try
                {
                    clsManejadoraPersonas.borrarPersonaBL(PersonaSeleccionada.Id);
                    PersonaSeleccionada = null;
                    EliminarCommand.RaiseCanExecuteChanged();
                    EditarCommand.RaiseCanExecuteChanged();
                    NotifyPropertyChanged("ListadoDePersonasMostrado");
                }
                catch (Exception)
                {
                    await App.Current.MainPage.DisplayAlert("Alerta", "Error eliminanado la persona de la BBDD", "OK");
                }
            }
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando que devuelve true si hay una persona seleccionada y false si no la hay.
        /// Postcondiciones: Devuelve un booleano según haya una persona seleccionada o no.
        /// </summary>
        /// <returns>bool</returns>
        private bool EliminarCommand_CanExecute() 
        {
            bool btnEliminar = false;
            if (PersonaSeleccionada != null)
            {
                btnEliminar = true;
            }
            return btnEliminar;
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando para editar una persona de la BBDD.
        /// Postcondiciones: Edita una persona de la BBDD.
        /// </summary>
        private async void EditarCommand_ExecutedAsync() 
        {
            var miDiccionario = new Dictionary<string, object>
            {
                {"personaParaMandar", PersonaSeleccionada }
            };
            await Shell.Current.GoToAsync("EditarPersona", miDiccionario);
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando que devuelve true si hay una persona seleccionada y false si no la hay.
        /// Postcondiciones: Devuelve un booleano según haya una persona seleccionada o no.
        /// </summary>
        /// <returns>bool</returns>
        private bool EditarCommand_CanExecute()
        {
            bool btnEditar = false;
            if (PersonaSeleccionada != null)
            {
                btnEditar = true;
            }
            return btnEditar;
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando para ir a la vista de detalles de la persona.
        /// Postcondiciones: No tiene.
        /// </summary>
        private async void DetallesCommand_Execute()
        {
            var miDiccionario = new Dictionary<string, object>
            {
                {"personaParaMandar", PersonaSeleccionada }
            };
            await Shell.Current.GoToAsync("DetallesPersona", miDiccionario);
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Comando que devuelve true si hay una persona seleccionada y false si no la hay.
        /// Postcondiciones: Devuelve un booleano según haya una persona seleccionada o no.
        /// </summary>
        /// <returns>bool</returns>
        private bool DetallesCommand_CanExecute()
        {
            bool btnEditar = false;
            if (PersonaSeleccionada != null)
            {
                btnEditar = true;
            }
            return btnEditar;
        }
        #endregion

        #region Metodos
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método para buscar dentro de la lista una persona o varias personas en concreto mediante una cadena que buscará dentro de la lista.
        /// Postcondiciones: Devuelve una ObservableCollection con las coincidencias.
        /// </summary>
        /// <returns>ObservableCollection</returns>
        private ObservableCollection<clsPersona> BuscarPersonas ()
        {
            List<clsPersona> listaAuxiliar = new List<clsPersona>(listadoDePersonasCompleto);
            ListadoDePersonasMostrado.Clear();
            ListadoDePersonasMostrado.Add(listaAuxiliar.Find(x => x.Nombre.ToLower().Contains(Cadena) || x.Apellidos.ToLower().Contains(Cadena)));
            //OTRO MÉTODO DE BUSQUEDA PERO ME DA EL MISMO RESULTADO QUE EL MIO, HAY QUE REVISARLO.
            //if (string.IsNullOrEmpty(Cadena))
            //{
            //    ListadoDePersonasMostrado = listadoDePersonasCompleto;
            //}
            //else
            //{
            //    List<clsPersona> listadoPersonasMostrado = new List<clsPersona>();

            //        foreach (clsPersona persona in ListadoDePersonasMostrado)
            //        {
            //            if (persona.Nombre.ToLower().StartsWith(Cadena.ToLowerInvariant()) || persona.Apellidos.ToLower().StartsWith(Cadena.ToLowerInvariant()))
            //            {
            //                listadoPersonasMostrado.Add(persona);
            //            }
            //        }
            //    ListadoDePersonasMostrado = new ObservableCollection<clsPersona>(listadoPersonasMostrado);
            //}
            return ListadoDePersonasMostrado;
        }
        #endregion
    }
}
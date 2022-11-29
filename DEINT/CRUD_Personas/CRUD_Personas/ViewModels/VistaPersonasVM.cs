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
        private ObservableCollection<clsPersona> listadoDePersonasCompleto;
        private ObservableCollection<clsPersona> listadoDePersonasMostrado;
        private clsPersona personaSeleccionada;
        private string cadena;
        #endregion

        #region Constructores
        public VistaPersonasVM() 
        {
            eliminarCommand = new DelegateCommand(EliminarCommand_Executed, EliminarCommand_CanExecute);
            editarCommand = new DelegateCommand(EditarCommand_Executed);
            listadoDePersonasCompleto = new ObservableCollection<clsPersona>(clsListadoPersonasBL.getListadoPersonasBL());
            listadoDePersonasMostrado = new ObservableCollection<clsPersona>(listadoDePersonasCompleto);
            personaSeleccionada = null;
            cadena = null;
        }
        #endregion

        #region Propiedades
        
        #endregion

        #region Commands
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
        private ObservableCollection<clsPersona> BuscarPersonasCon(string cadena)
        {
            ObservableCollection<clsPersona> listadoCompletoPersonas = clsListadoPersonasBL.getListadoPersonasBL();
            ObservableCollection<clsPersona> listadoDePersonasMostrado = new ObservableCollection<clsPersona>();

            //listadoDePersonasMostrado.Add(listadoCompletoPersonas.Find(x => x.Nombre.Contains(cadena) || x.Apellido.Contains(cadena)));
            return listadoDePersonasMostrado;
        }
        #endregion
    }
}

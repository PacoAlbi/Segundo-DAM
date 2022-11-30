using BL.Listados;
using CRUD_Personas.ViewModels.Utilidades;
using Entidades;
using System.Collections.ObjectModel;

namespace CRUD_Personas.ViewModels
{
    public class VistaDepartamentosVM : clsVMBase
    {
        #region Atributos
        private DelegateCommand crearCommand;
        private DelegateCommand eliminarCommand;
        private DelegateCommand editarCommand;
        private DelegateCommand buscarCommand;
        private ObservableCollection<clsDepartamentos> listadoDeDepartamentosCompleto;
        private ObservableCollection<clsDepartamentos> listadoDeDepartamentosMostrado;
        private clsDepartamentos departamentoSeleccionado;
        private string cadena;
        #endregion

        #region Constructores
        public VistaDepartamentosVM()
        {
            crearCommand = new DelegateCommand(CrearCommand_Executed);
            buscarCommand = new DelegateCommand(BuscarCommand_Executed, BuscarCommand_CanExecute);
            eliminarCommand = new DelegateCommand(EliminarCommand_Executed, EliminarCommand_CanExecute);
            editarCommand = new DelegateCommand(EditarCommand_Executed, EditarCommand_CanExecute);
            listadoDeDepartamentosCompleto = new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosBL.getListadoDepartamentosBL());
            listadoDeDepartamentosMostrado = new ObservableCollection<clsDepartamentos>();
            departamentoSeleccionado = null;
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
        public clsDepartamentos DepartamentoSeleccionado
        {
            get
            {
                return departamentoSeleccionado;
            }
            set
            {
                departamentoSeleccionado = value;
                editarCommand.RaiseCanExecuteChanged();
                eliminarCommand.RaiseCanExecuteChanged();
            }
        }
        public ObservableCollection<clsDepartamentos> ListadoDeDepartamentosMostrado
        {
            get
            {
                return listadoDeDepartamentosMostrado;
            }
            set
            {
                listadoDeDepartamentosMostrado = value;
            }
        }
        public DelegateCommand CrearCommand { get { return crearCommand; } }
        public DelegateCommand BuscarCommand { get { return buscarCommand; } }
        public DelegateCommand EliminarCommand { get { return eliminarCommand; } }
        public DelegateCommand EditarCommand { get { return editarCommand; } }
        #endregion

        #region Commands
        private void CrearCommand_Executed()
        {

        }
        private void BuscarCommand_Executed()
        {
            BuscarDepartamentos(cadena);
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
            listadoDeDepartamentosCompleto.Remove(departamentoSeleccionado);
            departamentoSeleccionado = null;
            eliminarCommand.RaiseCanExecuteChanged();
        }
        private bool EliminarCommand_CanExecute()
        {
            bool btnEliminar = true;
            if (departamentoSeleccionado == null)
            {
                btnEliminar = false;
            }
            return btnEliminar;
        }
        private void EditarCommand_Executed() { }
        private bool EditarCommand_CanExecute()
        {
            bool btnEditar = true;
            if (departamentoSeleccionado == null)
            {
                btnEditar = false;
            }
            return btnEditar;
        }
        #endregion

        #region Metodos
        private ObservableCollection<clsDepartamentos> BuscarDepartamentos(string cadenaABuscar)
        {
            List<clsDepartamentos> listaAuxiliar= new List<clsDepartamentos>(listadoDeDepartamentosCompleto);
            listadoDeDepartamentosMostrado.Add(listaAuxiliar.Find(x=> x.Nombre.Contains(cadena)));
            return listadoDeDepartamentosMostrado;
        }
        #endregion
    }
}
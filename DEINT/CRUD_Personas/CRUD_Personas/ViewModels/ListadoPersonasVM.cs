using BL.Listados;
using CRUD_Personas.Models;
using CRUD_Personas.ViewModels.Utilidades;
using Entidades;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static Microsoft.Maui.ApplicationModel.Permissions;

namespace CRUD_Personas.ViewModels
{
    public class ListadoPersonasVM : clsVMBase
    {
        #region Propiedades
        //public DelegateCommand ComandoEditar
        //{
        //    get
        //    {
        //        return new DelegateCommand(ComandoEditar_Executed, ComandoEditar_CanExecute);
        //    }
        //}
        public ObservableCollection<clsPersona> ListaPersonasCompleta { get; set; }

        public clsPersona PersonaSeleccionada { get; set; }
        #endregion

        #region Constructores
        public ListadoPersonasVM() 
        {
            ListaPersonasCompleta = clsListadoPersonasBL.getListadoPersonasBL();
        }
        #endregion

        #region Metodos
        //private void ComandoEditar_Executed()
        //{
            
        //    ComandoEditar.RaiseCanExecuteChanged();
        //}

        //private bool ComandoEditar_CanExecute()
        //{
        //    bool btnEditar = true;
        //    if (String.IsNullOrEmpty())
        //    {
        //        btnEditar = false;
        //    }
        //    return btnEditar;
        //}
        #endregion

    }
}

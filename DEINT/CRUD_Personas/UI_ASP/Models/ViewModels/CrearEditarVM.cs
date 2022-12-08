using BL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace UI_ASP.Models.ViewModels
{
    public class CrearEditarVM
    {
        #region Propiedades Autogeneradas
        public clsPersona Persona { get; set; }
        public ObservableCollection<clsDepartamentos> ListaDepartamentos { get; set; }
        #endregion

        #region Constructores
        public CrearEditarVM()
        {
            this.Persona = new clsPersona();
            this.ListaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
        }
        public CrearEditarVM(clsPersona oPersona)
        {
            this.Persona = oPersona;
            this.ListaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
        }
        #endregion
    }
}

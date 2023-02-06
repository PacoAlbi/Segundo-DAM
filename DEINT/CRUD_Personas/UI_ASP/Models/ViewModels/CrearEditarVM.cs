using BL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace UI_ASP.Models.ViewModels
{
    /// <summary>
    /// ViewModel que me sirve para crear o editar personas, que crea una persona y pide una lista departamentos a la BBDD para poder mostrarla y editarla o crearla.
    /// </summary>
    public class CrearEditarVM
    {
        #region Propiedades Autogeneradas
        public clsPersona Persona { get; set; }
        public ObservableCollection<clsDepartamentos> ListaDepartamentos { get; set; }
        #endregion

        #region Constructores
        public CrearEditarVM()
        {
            Persona = new clsPersona();
            ListaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
        }
        public CrearEditarVM(clsPersona oPersona)
        {
            Persona = oPersona;
            ListaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
        }
        #endregion
    }
}

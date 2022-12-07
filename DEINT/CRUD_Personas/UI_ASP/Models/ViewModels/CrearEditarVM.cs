using Entidades;

namespace UI_ASP.Models.ViewModels
{
    public class CrearEditarVM
    {
        #region Propiedades Autogeneradas
        public clsPersona Persona { get; set; }
        public List<clsDepartamentos> Departamentos { get; set; }
        #endregion


        public CrearEditarVM(clsPersona oPersona, List<clsDepartamentos> oDepartamentos)
        {
            this.Persona = oPersona;
            this.Departamentos = oDepartamentos;
        }

    }
}

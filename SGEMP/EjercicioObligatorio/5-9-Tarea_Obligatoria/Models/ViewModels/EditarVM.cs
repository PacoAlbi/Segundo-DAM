using DAL;
using Entidades;

namespace _5_9_Tarea_Obligatoria.Models.ViewModels
{
    public class EditarVM
    {
        #region Propiedades
        public List<clsDepartamento> Departamentos { get; set; }
        public clsPersona Persona { get; set; }

        #endregion

        #region Constructores
        public EditarVM(List<clsDepartamento> departamentos, clsPersona persona)
        {
            Departamentos = departamentos;
            Persona = persona;
        }
        public EditarVM()
        {
            Departamentos = clsListadoDepartamentosDAL.ObtenerListadoCompletoDepartamentos();
            Persona = new clsPersona("Paco", "Albiñana", 42, 4);
        }

        #endregion
    }
}

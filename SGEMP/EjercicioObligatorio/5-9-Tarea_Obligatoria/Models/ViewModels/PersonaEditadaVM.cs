using DAL;
using Entidades;

namespace _5_9_Tarea_Obligatoria.Models.ViewModels
{
    public class PersonaEditadaVM
    {
        #region Propiedades
        public clsPersona Persona { get; set; }
        public clsDepartamento Departamento { get; set; }

        #endregion

        #region Constructores
        public PersonaEditadaVM(clsPersona persona, clsDepartamento departamento)
        {
            Persona = persona;
            Departamento = departamento;
        }

        public PersonaEditadaVM()
        {
            Persona = new clsPersona();
            Departamento = clsManejadoraDepartamentosDAL.ObtenerDepartamentoPorSuId(Persona.IdDepartamento);
        }

        #endregion
    }
}

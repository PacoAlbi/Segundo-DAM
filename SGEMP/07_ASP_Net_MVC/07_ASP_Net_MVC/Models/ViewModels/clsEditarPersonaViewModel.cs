using _07_ASP_Net_MVC.Models.DAL;
using _07_ASP_Net_MVC.Models.Entidades;

namespace _07_ASP_Net_MVC.Models.ViewModels
{
    public class clsEditarPersonaViewModel
    {
        #region Atributos autoimplementados
        public List<clsDepartamento> listaDepartamentos { get; }
        public clsPersona persona { get; set; }
        #endregion

        #region Constructores
        public clsEditarPersonaViewModel()
        {
            listaDepartamentos = clsListadoDepartamentos.listarDepartamentos();
            persona = clsManejadoraPersonas.obtenerPersonaPorId(2);
        }
        #endregion
    }
}

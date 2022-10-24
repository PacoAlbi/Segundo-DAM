using _07_ASP_Net_MVC.Models.DAL;
using _07_ASP_Net_MVC.Models.Entidades;

namespace _07_ASP_Net_MVC.Models.ViewModels
{
    public class clsEditarPersonaViewModel
    {
        public static List<clsDepartamento> listaDepartamentos = clsListadoDepartamentos.listarDepartamentos();
        public static clsPersona persona;

    }
}

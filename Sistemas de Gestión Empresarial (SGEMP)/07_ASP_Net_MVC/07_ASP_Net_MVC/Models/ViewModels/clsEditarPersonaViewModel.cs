using _07_ASP_Net_MVC.Models.DAL;
using _07_ASP_Net_MVC.Models.Entidades;

namespace _07_ASP_Net_MVC.Models.ViewModels
{
    public class clsEditarPersonaViewModel
    {
        public static List<clsDepartamento> listaDepartamentos { get; set; }
        public static clsPersona persona { get; set; }

        public clsEditarPersonaViewModel(clsPersona editarpersona, List<clsDepartamento> lista)
        {
            persona = editarpersona;
            listaDepartamentos = lista;
        }
    }
}

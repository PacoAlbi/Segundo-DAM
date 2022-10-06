using Microsoft.AspNetCore.Mvc;

namespace _06_Hola_Mundo_MVC_UI.Controllers
{
    public class HomeController : Controller
    {
        public String Index()
        {
            return "Hola Mundo desde el controlador";
        }

        public String Paco()
        {
            return "Hola Paco desde el controlador";
        }

        public ViewResult VistaHolaMundo ()
        {
            return View();
        }
    }
}

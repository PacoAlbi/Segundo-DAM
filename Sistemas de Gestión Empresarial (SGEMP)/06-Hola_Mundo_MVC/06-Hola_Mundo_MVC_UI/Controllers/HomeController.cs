using Microsoft.AspNetCore.Mvc;

namespace _06_Hola_Mundo_MVC_UI.Controllers
{
    public class HomeController : Controller
    {
        public String Index()
        {
            return "Hola Mundo desde el action index del controlador home";
        }

        public String Paco()
        {
            return "Hola Paco desde el action Paco del controlador home";
        }

        public ViewResult VistaHolaMundo ()
        {
            return View();
        }
    }
}

using Microsoft.AspNetCore.Mvc;

namespace _06_Hola_Mundo_MVC_UI.Controllers
{
    public class ProductosController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }
}

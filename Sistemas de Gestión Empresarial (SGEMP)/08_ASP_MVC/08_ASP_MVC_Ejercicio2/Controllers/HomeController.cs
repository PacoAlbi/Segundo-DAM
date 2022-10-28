using _08_ASP_MVC_Ejercicio2.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace _08_ASP_MVC_Ejercicio2.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        /// <summary>
        /// escribir [HttpPost] antes del controlador para indicar que estamos recibiendo
        ///  una petición POST e indica lo que se debe hacer cuando el usuario ha pulsado algún
        /// botón tipo “Submit”
        /// </summary>
        /// <param name="nombre"></param>
        /// <returns></returns>
        public IActionResult Index()
        {
            return View();
        }

         [HttpPost]
        public IActionResult Index(string nombre)
        {
            ViewBag.nombre = nombre;
            return View("Saludo");
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
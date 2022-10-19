using _07_ASP_Net_MVC.Models;
using Microsoft.AspNetCore.Mvc;
using Microsoft.VisualBasic;
using System.Diagnostics;

namespace _07_ASP_Net_MVC.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            if(DateTime.Now.Hour >=7 && DateTime.Now.Hour < 12)
                ViewData["Saludo"] = "Buenos dias";
            else if (DateTime.Now.Hour >= 12 && DateTime.Now.Hour < 21)
                ViewData["Saludo"] = "Buenas tardes";
            else
                ViewData["Saludo"] = "Buenas noches";
            ViewBag.FechaLarga = DateAndTime.Now;

            clsPersona paco = new();
            paco.Name = "Paco";
            paco.Apellidos = "Albiñana Ruiz";
            paco.Direccion = "Aquí al lao";
            paco.Telefono = "616058828";
            paco.FechaNac = new DateOnly(1980, 05, 05);

            return View();
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
using _09_Ejercicio1.Models;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace _09_Ejercicio1.Controllers
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
            clsPersona persona = new clsPersona();
            return View(persona);
        }
        [HttpPost]
        public IActionResult Index(clsPersona persona)
        {
            IActionResult action;
            if (!ModelState.IsValid)
            {
                action = View(persona);
            }
            else
            {
                action = View("PersonaModificada",persona);
                //ViewBag.Nombre = persona.Nombre;
                //ViewBag.PrimerApellido = persona.PrimerApellido;
                //ViewBag.SegundoApellido = persona.SegundoApellido;
                //ViewBag.Edad = persona.Edad;
            }
            return action;
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
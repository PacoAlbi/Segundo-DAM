using _08_ASP_MVC_Ejercicio3.Models;
using _08_ASP_MVC_Ejercicio3.Models.Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace _08_ASP_MVC_Ejercicio3.Controllers
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
            return View();        
        }
       
        /// <summary>
       /// Metodo para mostrar la vista Agregar, en la que le introducimos una clase persona, que es la que se muestra
       /// a traves de el html. En el podemos modificar los campos y darle al input submit que realizara una accion.
       /// </summary>
       /// <returns></returns>
       
        public IActionResult Agregar()
        {
            clsPersona persona = new clsPersona();

            return View(persona);
        }
        /// <summary>
        /// Metodo para para mostrar la vista PersonaModificada. Por parametros le pasamos los existentes en la clase persona, 
        /// para a traves de ellos rellenar los campos existentes. En el return, devuelve un String de la vista Personamodificada, que es la vista que queremos que se muestre
        /// cuando le damos al submit en la vista Agregar. AL ser [HttpPost] lo que devuelve es lo que queremos que haga el 
        /// input de submit de dicha vista. Todos recogidos por un ViewBag para poder ser mostrados
        /// </summary>
        /// <param name="Nombre"></param>
        /// <param name="PrimerApellido"></param>
        /// <param name="SegundoApellido"></param>
        /// <param name="Edad"></param>
        /// <returns>Un String de la vista AgregarPersona</returns>
        [HttpPost]
        public ActionResult Agregar(String Nombre, String PrimerApellido, String SegundoApellido, int Edad)
        {
            clsPersona persona = new clsPersona(Nombre, PrimerApellido, SegundoApellido, Edad);
            if (!ModelState.IsValid) 
            { 
                return View(persona);
            }
            else
            {
                ViewBag.Nombre = Nombre;
                ViewBag.PrimerApellido = PrimerApellido;
                ViewBag.SegundoApellido = SegundoApellido;
                ViewBag.Edad = Edad;
            }           
            return View("PersonaModificada") ;
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
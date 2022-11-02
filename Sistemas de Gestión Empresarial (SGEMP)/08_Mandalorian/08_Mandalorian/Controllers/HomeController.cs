using _08_Mandalorian.Models;
using DAL.Listas;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace _08_Mandalorian.Controllers
{
    public class HomeController : Controller
    {
        private IndexViewModel ivm;

        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            ivm = new IndexViewModel(new clsMision(), clsListaMisiones.getListaCompletaMisiones());
            _logger = logger;
        }

        //Le paso a la vista una lista de las misiones, que he declarado antes del viewmodel antes para poder usarla en todo el controlador.
        public IActionResult Index()
        {           
            return View(ivm);
        }
        [HttpPost]
        public IActionResult Index(IndexViewModel ivmPost)
        {   //Recibo de la vista el Id de la misión seleccionada, y le devuelvo la lista con la descripción de la misión.
            ivmPost.ListaMisiones = clsListaMisiones.getListaCompletaMisiones();
            ivmPost.Mision = obtenerMision.obtenerMisionId(ivmPost.Mision.Id);
            return View(ivmPost);
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
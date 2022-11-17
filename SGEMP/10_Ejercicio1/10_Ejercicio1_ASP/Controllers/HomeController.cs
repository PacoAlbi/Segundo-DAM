using _10_Ejercicio1_ASP.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
using Microsoft.Data.SqlClient;
using Microsoft.Data.SqlClient;



namespace _10_Ejercicio1_ASP.Controllers
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
        [HttpPost]
        [ActionName ("Index")]
        public IActionResult IndexPost()
        {
            //Instancio la conexión a sql
            SqlConnection miConexion = new SqlConnection();
            try
            {
                //String de conexión
                miConexion.ConnectionString = "server=falbinana.database.windows.net;database=PacoBBDD;uid=falbinana;pwd=Paquete6";
                miConexion.Open();
                ViewBag.estadoConexion = miConexion.State;

            }
            catch (Exception e)
            {
                ViewBag.estadoConexion = miConexion.State;
            }
            finally { miConexion?.Close(); }
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
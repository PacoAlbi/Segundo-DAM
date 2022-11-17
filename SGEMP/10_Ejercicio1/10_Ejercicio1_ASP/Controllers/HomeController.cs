﻿using _10_Ejercicio1_ASP.Models;
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
            
            SqlConnection miConexion = new SqlConnection();
            try

            {

                miConexion.ConnectionString = "server=falbinana.database.windows.net;database=PacoBBDD;uid=falbinana;pwd=Mandaloriano69";
                miConexion.Open();
                ViewBag.estadoConexion = miConexion.State;

            }
            catch (Exception e)
            {
                return View(); //Mandaré a una vista de error para que el cliente no tenga información extra.
                //ViewBag.estadoConexion = e.Message;
            }
            finally { miConexion?.Close(); }
            return View();
        }

        public ActionResult ListadoPersona()
        {

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
using BL.Listados;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Collections.ObjectModel;
using UI_ASP.Models;
using UI_ASP.Models.ViewModels;

namespace UI_ASP.Controllers
{
    public class ListadoPersonasController : Controller
    {
        public IActionResult ListadoPersonas()
        {
            ListaPersonasNombreDptoVM listadoConDpto = new ListaPersonasNombreDptoVM();
            return View(listadoConDpto.ListadodePersonasconDpto);
        }

        public IActionResult CrearPersona()
        {
            clsPersona oPersona = new clsPersona();
            ObservableCollection<clsDepartamentos> listaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
            return View();
        }

        public IActionResult DetallesPersona(clsPersonasConNombreDpto persona)
        {
            clsPersona oPersona = new clsPersona();
            ObservableCollection<clsDepartamentos> listaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();

            return View();
        }

        public IActionResult EditarPersona(clsPersona persona)
        {
            

            return View();
        }

        public IActionResult BorrarPersona(int id)
        {
           

            return View();
        }
    }
}

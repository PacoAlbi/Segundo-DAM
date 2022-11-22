using BL;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Collections.ObjectModel;

namespace UI_ASP.Controllers
{
    public class ListadoPersonasController : Controller
    {
        public IActionResult ListadoPersonas()
        {
            
            ObservableCollection<clsPersona> lista = new ObservableCollection<clsPersona>(clsListadoPersonasBL.getListadoPersonasBL());
            
            return View(lista);
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

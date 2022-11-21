using BL;
using DAL.Listados;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
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

        public IActionResult EditarPersona()
        {
            ObservableCollection<clsPersona> lista = new ObservableCollection<clsPersona>(clsListadoPersonasBL.getListadoPersonasBL());

            return View(lista);
        }

        public IActionResult BorrarPersona()
        {
            ObservableCollection<clsPersona> lista = new ObservableCollection<clsPersona>(clsListadoPersonasBL.getListadoPersonasBL());

            return View(lista);
        }
    }
}

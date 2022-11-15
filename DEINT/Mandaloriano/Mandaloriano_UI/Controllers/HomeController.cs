using Mandaloriano_DAL;
using Mandaloriano_Entidades;
using Mandaloriano_UI.Models.ViewModels;
using Microsoft.AspNetCore.Mvc;

namespace Mandaloriano_UI.Controllers
{
    public class HomeController : Controller
    {
        /// <summary>
        /// Devolvera la vista Index, como modelo un viewModel con el listado de misiones disponibles y
        /// la misiones seleccionada nula
        /// </summary>
        /// <returns></returns>
        public IActionResult Index()
        {
            clsListadoMisionesYMisionSeleccioneadaVM model=new clsListadoMisionesYMisionSeleccioneadaVM
                (clsListadoMisionesDAL.obtenerListadoMisionesTotal(),new clsMisiones());
            return View(model);
        }

        /// <summary>
        /// Recibira la mision elejida pos post, y enviara una vista con la lista de misiones y la mision
        /// elejida
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        [HttpPost]
        public ViewResult Index(int Id)
        {
            clsListadoMisionesYMisionSeleccioneadaVM model = new clsListadoMisionesYMisionSeleccioneadaVM
                (clsListadoMisionesDAL.obtenerListadoMisionesTotal(), buscarMisionDAL.busrcarMisionPorId(Id) );
            return View(model);
        }
    }
}

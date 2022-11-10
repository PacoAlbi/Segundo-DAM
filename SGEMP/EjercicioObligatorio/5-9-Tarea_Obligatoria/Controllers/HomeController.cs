using Microsoft.AspNetCore.Mvc;
using Entidades;
using DAL;
using _5_9_Tarea_Obligatoria.Models.ViewModels;

namespace _5_9_Tarea_Obligatoria.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Editar()
        {
            EditarVM editarVM = new EditarVM();

            return View(editarVM);
        }

        [HttpPost]
        public IActionResult Editar(EditarVM editarVM)
        {
            PersonaEditadaVM editada = new PersonaEditadaVM();

            editada.Persona = editarVM.Persona;
            editada.Departamento = clsManejadoraDepartamentosDAL.ObtenerDepartamentoPorSuId(editada.Persona.IdDepartamento);

            return View("PersonaEditada",editarVM);
        }

        
        
    }
}
using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using UI_ASP.Models;
using UI_ASP.Models.ViewModels;

namespace UI_ASP.Controllers
{
    public class ListadoPersonasController : Controller
    {
        public IActionResult ListadoPersonas()
        {
            ActionResult action;
            ListaPersonasNombreDptoVM listadoConDpto;
            try
            {
                listadoConDpto = new ListaPersonasNombreDptoVM();
                action = View(listadoConDpto.ListadodePersonasconDpto);
            } catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorPersonas");
            } catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorPersonas");
            }
            return action;
        }

        public IActionResult CrearPersona()
        {
            ActionResult action;
            try
            {
                action = View(new CrearEditarVM());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorPersonas");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorPersonas");
            }
            return action;
        }
        [HttpPost]
        public IActionResult CrearPersona(CrearEditarVM personaVM)
        {
            clsManejadoraPersonas.insertarPersonasBL(personaVM.Persona);
            return View("ListadoPersonas", new ListaPersonasNombreDptoVM().getListaPersonasConDpto());
        }
        
        public IActionResult DetallesPersona(int id)
        {
            ActionResult action;
            try
            {              
                action = View(new ListaPersonasNombreDptoVM().getListaPersonasConDptoPorId(id));
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorPersonas");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorPersonas");
            }
            return action;
        }

        public IActionResult EditarPersona(int id)
        {
            ActionResult action;
            try
            {
                action = View(new ListaPersonasNombreDptoVM().getListaPersonasConDptoPorId(id));
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorPersonas");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorPersonas");
            }
            return action;
        }
        [HttpPost]
        public IActionResult EditarPersona(clsPersonasConNombreDpto oPersona)
        {
            clsManejadoraPersonas.insertarPersonasBL(oPersona);
            return View(oPersona);
        }
        public IActionResult BorrarPersona(int id)
        {
            ActionResult action;
            try
            {
                action = View(new ListaPersonasNombreDptoVM().getListaPersonasConDptoPorId(id));
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorPersonas");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorPersonas");
            }
            return action;
        }
        [HttpDelete]
        public IActionResult BorrarPersona(clsPersonasConNombreDpto oPersona)
        {
            clsManejadoraPersonas.borrarPersonaBL(oPersona.Id);
            return View("ListadoPersonas", new ListaPersonasNombreDptoVM().getListaPersonasConDpto());
        }
    }
}

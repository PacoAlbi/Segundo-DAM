using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using UI_ASP.Models;
using UI_ASP.Models.ViewModels;

namespace UI_ASP.Controllers
{
    /// <summary>
    /// Controlador para la gestión de las personas.
    /// </summary>
    public class ListadoPersonasController : Controller
    {
        /// <summary>
        /// Precondición: No tiene.
        /// Método que recibe una lista de personas con el nombre del partamento del viewmodel y lo manda a la vista para mostrarla.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda una lista de personas con el nombre del departamento a la vista.
        /// </summary>
        /// <returns>ObservableCollection de Personas con nombre de departamento</returns>
        public IActionResult ListadoPersonas()
        {
            ActionResult action;
            try
            {
                //ListaPersonasNombreDptoVM listadoConDpto = new ListaPersonasNombreDptoVM();
                action = View(new ListaPersonasNombreDptoVM().ListadodePersonasconDpto);
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
        /// <summary>
        /// Precondición: No tiene.
        /// Método que crea una persona nueva para mandarla al action de crear.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda una persona del viewmodel al action de crear.
        /// </summary>
        /// <returns>CrearEditarVM</returns>
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
        /// <summary>
        /// Precondición: Debe recibir un objeto del viewmodel.
        /// Método que recibe un viewmododel y manda a la persona a insertar en la BBDD.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Inserta la persona del viewmodel en la BBDD.
        /// </summary>
        /// <param name="personaVM">CrearEditarVM</param>
        /// <returns>View</returns>
        [HttpPost]
        public IActionResult CrearPersona(CrearEditarVM personaVM)
        {
            ActionResult action;
            try
            {
                clsManejadoraPersonas.insertarPersonasBL(personaVM.Persona);
                action = View("ListadoPersonas", new ListaPersonasNombreDptoVM().getListaPersonasConDpto());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error insertando a la persona en la BBDD";
                action = View("ErrorPersonas");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorPersonas");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir la id de una persona.
        /// Método que recibe la id de la persona del viewmodel para mostrar la persona en la vista.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda una persona del viewmodel a la vista.
        /// </summary>
        /// <param name="id">int id</param>
        /// <returns>View</returns>
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
        /// <summary>
        /// Precondición: Debe recibir la id de una persona.
        /// Método que recibe la id de la persona del viewmodel para mandarla action de editar.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda una persona del viewmodel al action de editar.
        /// </summary>
        /// <param name="id">int id</param>
        /// <returns>CrearEditarVM</returns>
        public IActionResult EditarPersona(int id)
        {
            ActionResult action;
            try
            {
                //CrearEditarVM persona = new CrearEditarVM(clsListadoPersonasBL.obtenerPersonaPorIdBL(id));
                action = View(new CrearEditarVM(clsListadoPersonasBL.obtenerPersonaPorIdBL(id)));
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
        /// <summary>
        /// Precondición: Debe recibir un objeto del viewmodel.
        /// Método que recibe una persona del viewmodel y la edita en la BBDD.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Edita una persona en la BBDD.
        /// </summary>
        /// <param name="PersonaVM">CrearEditarVM</param>
        /// <returns>View</returns>
        [HttpPost]
        public IActionResult EditarPersona(CrearEditarVM PersonaVM)
        {
            ActionResult action;
            try
            {
                clsManejadoraPersonas.editarPersonaBL(PersonaVM.Persona);
                action = View("ListadoPersonas", new ListaPersonasNombreDptoVM().getListaPersonasConDpto());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error editando a la persona";
                action = View("ErrorPersonas");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorPersonas");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir la id de una persona.
        /// Método que recibe la id de una persona en el viewmodel para mandarla al action de borrar.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda una persona al action de borrar.
        /// </summary>
        /// <param name="id">int id</param>
        /// <returns>>CrearEditarVM</returns>
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
        /// <summary>
        /// Precondición: Debe recibir un objeto del viewmodel.
        /// Método que manda el id de una persona del viewmodel para borrarlo en la BBDD.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Elimina a una persona de la BBDD.
        /// </summary>
        /// <param name="PersonaBorrar">clsPersonasConNombreDpto</param>
        /// <returns>View</returns>
        [HttpPost]
        public IActionResult BorrarPersona(clsPersonasConNombreDpto PersonaBorrar)
        {           
            ActionResult action;
            try
            {
                clsManejadoraPersonas.borrarPersonaBL(PersonaBorrar.Id);
                action = View("ListadoPersonas", new ListaPersonasNombreDptoVM().getListaPersonasConDpto());
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
    }
}

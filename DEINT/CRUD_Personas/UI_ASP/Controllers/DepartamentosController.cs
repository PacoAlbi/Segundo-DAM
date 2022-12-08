using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;

namespace UI_ASP.Controllers
{
    /// <summary>
    /// Controlador para la gestión de los departamentos.
    /// </summary>
    public class DepartamentosController : Controller
    {
        /// <summary>
        /// Precondición: No tiene.
        /// Método que recibe una lista de departamentos de la BBDD y lo manda a la vista para mostrarla.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda una lista de departamentos a la vista.
        /// </summary>
        /// <returns>ObservableCollection de Departamentos</returns>
        public IActionResult ListadoDepartamentos()
        {
            ActionResult action;
            try
            {
                action = View(clsListadoDepartamentosBL.getListadoDepartamentosBL());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
        /// <summary>
        /// Precondición: No tiene.
        /// Método que crea un departamento nuevo para poder mandarlo al action de insertar.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda un departamento al action de insertar.
        /// </summary>
        /// <returns>clsDepartamentos</returns>
        public IActionResult CrearDepartamento()
        {
            ActionResult action;
            try
            {
                action = View(new clsDepartamentos());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir un objeto departamento.
        /// Método que recibe un departamento y lo inserta en la BBDD.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Inserta un departamento en la BBDD.
        /// </summary>
        /// <param name="departamento">clsDepartamento</param>
        /// <returns>View</returns>
        [HttpPost]
        public IActionResult CrearDepartamento(clsDepartamentos departamento)
        {
            ActionResult action;
            try
            {
                clsManejadoraDepartamentos.insertarDepartamentoBL(departamento);
                action = View("ListadoDepartamentos", clsListadoDepartamentosBL.getListadoDepartamentosBL());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error creando el departamento.";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir la id de un departamento.
        /// Método que recibe la ide de un departamento y lo busca en la BBDD para mostrarlo.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda un objeto departamento a la vista.
        /// </summary>
        /// <param name="id">int id</param>
        /// <returns>clsDepartamentos</returns>
        public IActionResult DetallesDepartamento(int id)
        {
            ActionResult action;
            try
            {
                clsDepartamentos departamento = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(id);
                action = View(departamento);
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir la id de un departamento.
        /// Método que recibe un departamento y lo busca en la BBDD para editarlo.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda un departamento al action de editar.
        /// </summary>
        /// <param name="id">int id</param>
        /// <returns>clsDepartamentos</returns>
        public IActionResult EditarDepartamento(int id)
        {
            ActionResult action;
            try
            {
                clsDepartamentos departamento = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(id);
                action = View(departamento);
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir un objeto departamento.
        /// Método que recibe un departamento y lo edita en la BBDD.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Edita el departamento en la BBDD.
        /// </summary>
        /// <param name="departamento">clsDepartamentos</param>
        /// <returns>View</returns>
        [HttpPost]
        public IActionResult EditarDepartamento(clsDepartamentos departamento)
        {
            ActionResult action;
            try
            {
                clsManejadoraDepartamentos.editarDepartamentoBL(departamento);
                action = View("ListadoDepartamentos", clsListadoDepartamentosBL.getListadoDepartamentosBL());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error editando el departamento.";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir la id de un departamento.
        /// Método que recibe una id de un departamento de la lista de departamentos para enviarlo al action de borrar.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Manda el departamento al action de borrar.
        /// </summary>
        /// <param name="id">int id</param>
        /// <returns>clsDepartamentos</returns>
        public IActionResult BorrarDepartamento(int id)
        {
            ActionResult action;
            try
            {
                clsDepartamentos departamento = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(id);
                action = View(departamento);
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
        /// <summary>
        /// Precondición: Debe recibir un objeto departamento.
        /// Método que recibe un departamento y lo borra de la BBDD.
        /// Muestra un mensaje de error en caso de fallo con la BBDD u error genérico.
        /// Postcondición: Borra el departamento de la BBDD.
        /// </summary>
        /// <param name="departamento">clsDepartamento</param>
        /// <returns>View</returns>
        [HttpPost]
        public IActionResult BorrarDepartamento(clsDepartamentos departamento)
        {
            ActionResult action;
            try
            {
                clsManejadoraDepartamentos.borrarDepartamentosBL(departamento.Id);
                action = View("ListadoDepartamentos", clsListadoDepartamentosBL.getListadoDepartamentosBL());
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error borrando el departamento.";
                action = View("ErrorDepartamentos");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("ErrorDepartamentos");
            }
            return action;
        }
    }
}
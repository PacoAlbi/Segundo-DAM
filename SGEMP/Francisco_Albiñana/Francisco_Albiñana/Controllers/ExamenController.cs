using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Francisco_Albiñana.Models;
using Francisco_Albiñana.Models.ViewModels;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;

namespace Francisco_Albiñana.Controllers
{
    public class ExamenController : Controller
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Action que manda a la vista una lista de Departamentos con lista de personas asociadas.
        /// Postcondiciones: Devuelve un lista de departamentos con personas.
        /// </summary>
        /// <returns>List a la vista</returns>
        public IActionResult ListadoDepartamentos()
        {
            ActionResult action;
            try
            {
                //No se porque me llega solo un empleado en la lista de empleados del departamento
                action = View(new ListaDepartamentosyPersonasVM().Listado);
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error recuperando los departamentos";
                action = View("Error");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("Error");
            }
            return action;
        }
        /// <summary>
        /// Precondiciones: Debe recivir el Id de un departamento.
        /// Recive el id de un departamento y llama al VM para borrar personas y departamentos "on cascade" pero sin usar SQL
        /// Postcondiciones: No tiene.
        /// </summary>
        /// <param name="Id">int IdDepartamento</param>
        /// <returns>vuelve a la vista de borra para confirmar</returns>
        public IActionResult BorrarDepartamento(int Id)
        {
            ActionResult action;
            try
            {
                //Pillo el departamento por la id, y lo pasaría al action de borrar, pero no se como mostrarlo en la vista con HTML
                action = View();
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error borrando el departamento seleccionado";
                action = View("Error");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("Error");
            }
            return action;
        }
        /// <summary>
        /// Precondiciones: Debe recivir el Id de un departamento.
        /// Recive el id de un departamento y llama al VM para borrar personas y departamentos "on cascade" pero sin usar SQL
        /// Postcondiciones: No tiene.
        /// </summary>
        /// <param name="Id">int IdDepartamento</param>
        /// <returns>vuelve a la vista de borra para confirmar</returns>
        [HttpPost]
        public IActionResult BorrarDepartamento2(clsDepartamentos IdDep)
        {
            ActionResult action;
            try
            {
                //Aquí cogería el departamento despues de confirmar que lo quiero borrar, y llamaría a la BL (DAL) para borrarlo de verdad.

                action = View();
            }
            catch (SqlException)
            {
                ViewBag.Error = "Error borrando el departamento seleccionado";
                action = View("Error");
            }
            catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
                action = View("Error");
            }
            return action;
        }
    }
}

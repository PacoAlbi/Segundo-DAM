using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;

namespace ExamenFranciscoAlbiñana.Controllers.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class departamentosController : ControllerBase
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método que devuelve una lista de departamentos de la api.
        /// Postcondiciones: Devuelve una lista de departamentos.
        /// </summary>
        /// <returns>List clsDepart</returns>
        [HttpGet]
        public IEnumerable<clsDepartamentos> Get()
        {
            return clsListadoDepartamentosBL.getListadoDepartamentosBL();
        }
    }
}
using BL.Listados;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Collections.ObjectModel;

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
            ObservableCollection<clsDepartamentos> listaDepartamentos; 
            try
            {
                listaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
            } catch (Exception ex)
            {
                throw ex;
            }
            return listaDepartamentos;
        }
    }
}
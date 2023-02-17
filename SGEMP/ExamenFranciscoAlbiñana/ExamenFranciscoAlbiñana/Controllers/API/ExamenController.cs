using Microsoft.AspNetCore.Mvc;
using BL.Manejadoras;
using Entidades;
using BL.Listados;
using System.Collections.ObjectModel;

namespace ExamenFranciscoAlbiñana.Controllers.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class ExamenController : ControllerBase
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método que devuelve una lista de personas con departamento de la api.
        /// Postcondiciones: Devuelve una lista de personas con departamento.
        /// </summary>
        /// <returns>List clsPersonaDep</returns>
        [HttpGet]
        public IEnumerable<clsPersona> Get()
        {
            ObservableCollection<clsPersona> listaPersonas;
            try
            {
                listaPersonas = clsListadoPersonasBL.getListadoPersonasBL();
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return listaPersonas;
        }
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método que actualiza una persona en la api.
        /// Postcondiciones: Devuelve una lista de personas con departamento.
        /// </summary>
        /// <param name="persona">clsPersona</param>
        [HttpPut]
        public int Put([FromBody] clsPersona persona)
        {
            int registrosAfectados = 0;
            try
            {
                clsManejadoraPersonas.editarPersonaBL(persona);
            }
            catch (Exception ex)
            {
                throw ex;
            }
            return registrosAfectados;
        }
    }
}
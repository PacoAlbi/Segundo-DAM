using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Web.Http;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace UI_ASP.Controllers.API
{
    [Microsoft.AspNetCore.Mvc.Route("api/[controller]")]
    [ApiController]
    public class personasController : ControllerBase
    {
        // GET: api/<ValuesController>
        [Microsoft.AspNetCore.Mvc.HttpGet]
        public IEnumerable<clsPersona> Get()
        {
            return clsListadoPersonasBL.getListadoPersonasBL();
        }

        // GET api/<ValuesController>/5
        [Microsoft.AspNetCore.Mvc.HttpGet("{id}")]
        public clsPersona Get(int id)
        {
            return clsListadoPersonasBL.obtenerPersonaPorIdBL(id);
        }

        // POST api/<ValuesController>
        [Microsoft.AspNetCore.Mvc.HttpPost]
        public void Post([Microsoft.AspNetCore.Mvc.FromBody] clsPersona persona)
        {
            clsManejadoraPersonas.insertarPersonasBL(persona);
        }

        // PUT api/<ValuesController>/5
        [Microsoft.AspNetCore.Mvc.HttpPut("{id}")]
        public void Put([Microsoft.AspNetCore.Mvc.FromBody] clsPersona persona)
        {
            clsManejadoraPersonas.editarPersonaBL(persona);
        }

        // DELETE api/<ValuesController>/5
        [Microsoft.AspNetCore.Mvc.HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            IActionResult result = null;
            int numeroFilasAfectadas = 0;
            try
            {
                numeroFilasAfectadas = clsManejadoraPersonas.borrarPersonaBL(id);
                if (numeroFilasAfectadas == 0)
                {
                    result = NoContent();
                }
                else
                {
                    result = Ok();
                }
            }
            catch (HttpResponseException)
            {
                result = BadRequest();
            }
            return result;
        }
    }
}

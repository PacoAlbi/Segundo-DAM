using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;

namespace UI_ASP.Controllers.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class personasController : ControllerBase
    {
        // GET: api/<ValuesController>
        [HttpGet]
        public IEnumerable<clsPersona> Get()
        {
            return clsListadoPersonasBL.getListadoPersonasBL();
        }

        // GET api/<ValuesController>/5
        [HttpGet("{id}")]
        public clsPersona Get(int id)
        {
            return clsListadoPersonasBL.obtenerPersonaPorIdBL(id);
        }

        // POST api/<ValuesController>
        [HttpPost]
        public void Post([FromBody] clsPersona persona)
        {
            clsManejadoraPersonas.insertarPersonasBL(persona);
        }

        // PUT api/<ValuesController>/5
        [HttpPut("{id}")]
        public void Put([FromBody] clsPersona persona)
        {
            clsManejadoraPersonas.editarPersonaBL(persona);
        }

        // DELETE api/<ValuesController>/5
        [HttpDelete("{id}")]
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
            catch (Exception)
            {
                result = BadRequest();
            }
            return result;
        }
    }
}

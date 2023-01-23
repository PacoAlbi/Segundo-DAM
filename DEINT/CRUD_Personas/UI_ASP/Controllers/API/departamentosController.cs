//using BL.Listados;
//using BL.Manejadoras;
//using Entidades;
//using Microsoft.AspNetCore.Mvc;

//namespace UI_ASP.Controllers.API
//{
//    [Route("api/[controller]")]
//    [ApiController]
//    public class departamentosController : ControllerBase
//    {
//        // GET: api/<departamentosController>
//        [HttpGet]
//        public IEnumerable<clsDepartamentos> Get()
//        {
//            return clsListadoDepartamentosBL.getListadoDepartamentosBL();
//        }

//        // GET api/<departamentosController>/5
//        [HttpGet("{id}")]
//        public clsDepartamentos Get(int id)
//        {
//            return clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(id);
//        }

//        // POST api/<departamentosController>
//        [HttpPost]
//        public void Post([FromBody] clsDepartamentos departamento)
//        {
//            clsManejadoraDepartamentos.insertarDepartamentoBL(departamento);
//        }

//        // PUT api/<departamentosController>/5
//        [HttpPut("{id}")]
//        public void Put(int id, [FromBody] clsDepartamentos departamento)
//        {
//            clsManejadoraDepartamentos.editarDepartamentoBL(departamento);
//        }

//        // DELETE api/<departamentosController>/5
//        [HttpDelete("{id}")]
//        public IActionResult Delete(int id)
//        {
//            IActionResult result = null;
//            int numeroFilasAfectadas = 0;
//            try
//            {
//                numeroFilasAfectadas = clsManejadoraDepartamentos.borrarDepartamentosBL(id);    
//                if (numeroFilasAfectadas == 0)
//                {
//                    result = NoContent();
//                }
//                else
//                {
//                    result = Ok();
//                }
//            }
//            catch (Exception)
//            {
//                result = BadRequest();
//            }
//            return result;
//        }
//    }
//}

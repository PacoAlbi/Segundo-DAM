using UI_ASP.Models;
using UI_ASP.Models.ViewModels;
using Microsoft.AspNetCore.Mvc;

namespace UI_ASP.Controllers.API
{
    [Route("api/[controller]")]
    [ApiController]
    public class PersonasConDepartamentoController : ControllerBase
    {
        // GET: api/<PersonasConDepartamentoController>
        [HttpGet]
        public IEnumerable<clsPersonasConNombreDpto> Get()
        {
            return new ListaPersonasNombreDptoVM().getListaPersonasConDpto();
        }
    }
}
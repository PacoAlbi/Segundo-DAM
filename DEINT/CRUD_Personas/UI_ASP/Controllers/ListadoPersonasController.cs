using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using System.Collections.ObjectModel;
using UI_ASP.Models;
using UI_ASP.Models.ViewModels;

namespace UI_ASP.Controllers
{
    public class ListadoPersonasController : Controller
    {
        public IActionResult ListadoPersonas()
        {
            ListaPersonasNombreDptoVM listadoConDpto = new ListaPersonasNombreDptoVM();
            return View(listadoConDpto.ListadodePersonasconDpto);
        }

        public IActionResult CrearPersona()
        {
            clsPersona oPersona = new clsPersona();
            ObservableCollection<clsDepartamentos> listaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
            return View();
        }
        [HttpPost]
        public IActionResult CrearPersona(clsPersona oPersona)
        {
            //clsPersona oPersona = new clsPersona();
            clsManejadoraPersonas.insertarPersonasBL(oPersona);
            return View();
        }
        
        public IActionResult DetallesPersona(int id)
        {
            clsPersona oPersona = clsListadoPersonasBL.obtenerPersonaPorIdBL(id);
            clsPersonasConNombreDpto personaDetalles = new clsPersonasConNombreDpto();
            personaDetalles.Id = oPersona.Id;
            personaDetalles.Nombre = oPersona.Nombre;
            personaDetalles.Apellidos = oPersona.Apellidos;
            personaDetalles.Direccion = oPersona.Direccion;
            personaDetalles.Telefono = oPersona.Telefono;
            personaDetalles.Foto = oPersona.Foto;
            personaDetalles.FechaNacimiento = oPersona.FechaNacimiento;
            personaDetalles.IdDepartamento = oPersona.IdDepartamento;
            personaDetalles.NombreDpto = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(oPersona.IdDepartamento).Nombre;           
            return View(personaDetalles);
        }

        public IActionResult EditarPersona(clsPersona persona)
        {
            

            return View();
        }

        public IActionResult BorrarPersona(int id)
        {
            clsPersona oPersona = clsListadoPersonasBL.obtenerPersonaPorIdBL(id);
            clsPersonasConNombreDpto personaDetalles = new clsPersonasConNombreDpto();
            personaDetalles.Id = oPersona.Id;
            personaDetalles.Nombre = oPersona.Nombre;
            personaDetalles.Apellidos = oPersona.Apellidos;
            personaDetalles.Direccion = oPersona.Direccion;
            personaDetalles.Telefono = oPersona.Telefono;
            personaDetalles.Foto = oPersona.Foto;
            personaDetalles.FechaNacimiento = oPersona.FechaNacimiento;
            personaDetalles.IdDepartamento = oPersona.IdDepartamento;
            personaDetalles.NombreDpto = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(oPersona.IdDepartamento).Nombre;
            return View(personaDetalles);
        }
    }
}

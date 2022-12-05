using BL.Listados;
using BL.Manejadoras;
using Entidades;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using System.Collections.ObjectModel;
using UI_ASP.Models;
using UI_ASP.Models.ViewModels;

namespace UI_ASP.Controllers
{
    public class ListadoPersonasController : Controller
    {
        public IActionResult ListadoPersonas()
        {
            ListaPersonasNombreDptoVM listadoConDpto = null;
            try
            {
                listadoConDpto = new ListaPersonasNombreDptoVM();
            } catch (SqlException)
            {
                ViewBag.Error = "Error accediendo a la BBDD";
            } catch (Exception)
            {
                ViewBag.Error = "Error inesperado";
            }
            
            return View(listadoConDpto.ListadodePersonasconDpto);
        }

        public IActionResult CrearPersona()
        {

            clsPersona oPersona = new clsPersona();
            ObservableCollection<clsDepartamentos> listaDepartamentos = clsListadoDepartamentosBL.getListadoDepartamentosBL();
            return View(listaDepartamentos);
        }
        [HttpPost]
        public IActionResult CrearPersona(clsPersonasConNombreDpto oPersona)
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

        public IActionResult EditarPersona(int id)
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
        [HttpPost]
        public IActionResult EditarPersona(clsPersonasConNombreDpto oPersona)
        {
            clsManejadoraPersonas.insertarPersonasBL(oPersona);
            return View(oPersona);
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

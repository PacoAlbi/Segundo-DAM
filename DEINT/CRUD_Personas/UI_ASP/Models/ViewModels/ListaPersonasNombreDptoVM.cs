using Entidades;
using BL.Listados;
using System.Collections.ObjectModel;

namespace UI_ASP.Models.ViewModels
{
    /// <summary>
    /// ViewModel que voy a utilizar porque mi vista necesita una lista de personas con el nombre del departamento.
    /// </summary>
    public class ListaPersonasNombreDptoVM
    {
        #region Propiedades autogeneradas
        public ObservableCollection<clsPersonasConNombreDpto> ListadodePersonasconDpto { get; set; }
        #endregion

        #region Constructores
        public ListaPersonasNombreDptoVM () 
        {
            ListadodePersonasconDpto = getListaPersonasConDpto();
        }
        #endregion

        #region Métodos
        /// <summary>
        /// Precondición: No tiene.
        /// Recibe una lista de personas normal y le añado del nombre de departamento para poder enviarla.
        /// Postcondición: Devuelve una lista de personas con el nombre del departamento.
        /// </summary>
        /// <returns>Devuelvo una List de personas con el nombre de departamento.</returns>
        public ObservableCollection<clsPersonasConNombreDpto> getListaPersonasConDpto()
        {
            ObservableCollection<clsPersona> listadoNormal = clsListadoPersonasBL.getListadoPersonasBL();
            ObservableCollection<clsPersonasConNombreDpto> listadoConDpto = new ObservableCollection<clsPersonasConNombreDpto>();
            for (int i = 0; i < listadoNormal.Count; i++)
            {
                clsPersonasConNombreDpto oPersona = new clsPersonasConNombreDpto();
                oPersona.Id = listadoNormal[i].Id;
                oPersona.Nombre = listadoNormal[i].Nombre;
                oPersona.Apellidos = listadoNormal[i].Apellidos;
                oPersona.Direccion = listadoNormal[i].Direccion;
                oPersona.Telefono = listadoNormal[i].Telefono;
                oPersona.Foto = listadoNormal[i].Foto;
                oPersona.FechaNacimiento = listadoNormal[i].FechaNacimiento;
                oPersona.IdDepartamento = listadoNormal[i].IdDepartamento;
                oPersona.NombreDpto = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(listadoNormal[i].IdDepartamento).Nombre;
                listadoConDpto.Add(oPersona);
            }
            return listadoConDpto;
        }
        /// <summary>
        /// Precondición: No tiene.
        /// Busca una persona por su id y le añade el nombre del departamento para enviarla.
        /// Postcondición: Devuelve un persona con el nombre de su departamento encontrada por su id.
        /// </summary>
        /// <param name="id">int id</param>
        /// <returns>clsPersonasConNombreDpto</returns>
        public clsPersonasConNombreDpto getListaPersonasConDptoPorId(int id)
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
            return personaDetalles;
        }
        #endregion
    }
}

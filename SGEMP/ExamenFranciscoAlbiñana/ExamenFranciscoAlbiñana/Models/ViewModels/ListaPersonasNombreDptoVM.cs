using Entidades;
using BL.Listados;
using System.Collections.ObjectModel;

namespace ExamenFranciscoAlbiñana.Models.ViewModels
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
        public ListaPersonasNombreDptoVM()
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
                oPersona.id = listadoNormal[i].id;
                oPersona.nombre = listadoNormal[i].nombre;
                oPersona.apellidos = listadoNormal[i].apellidos;
                oPersona.direccion = listadoNormal[i].direccion;
                oPersona.telefono = listadoNormal[i].telefono;
                oPersona.foto = listadoNormal[i].foto;
                oPersona.fechaNacimiento = listadoNormal[i].fechaNacimiento;
                oPersona.idDepartamento = listadoNormal[i].idDepartamento;
                oPersona.NombreDpto = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(listadoNormal[i].idDepartamento).nombre;
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
            personaDetalles.id = oPersona.id;
            personaDetalles.nombre = oPersona.nombre;
            personaDetalles.apellidos = oPersona.apellidos;
            personaDetalles.direccion = oPersona.direccion;
            personaDetalles.telefono = oPersona.telefono;
            personaDetalles.foto = oPersona.foto;
            personaDetalles.fechaNacimiento = oPersona.fechaNacimiento;
            personaDetalles.idDepartamento = oPersona.idDepartamento;
            personaDetalles.NombreDpto = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(oPersona.idDepartamento).nombre;
            return personaDetalles;
        }
        #endregion
    }
}

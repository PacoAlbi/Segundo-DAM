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
        /// Pillo una lista de personas normal y le añado del nombre de departamento para poder mostrarlo a la vista.
        /// </summary>
        /// <returns>Devuelvo una List de personas con nombre de departamento.</returns>
        public ObservableCollection<clsPersonasConNombreDpto> getListaPersonasConDpto()
        {
            ObservableCollection<clsPersona> listadoNormal = clsListadoPersonasBL.getListadoPersonasBL();
            ObservableCollection<clsPersonasConNombreDpto> listadoConDpto = new ObservableCollection<clsPersonasConNombreDpto>();
            for(int i = 0; i < listadoNormal.Count; i++)
            {
                clsPersonasConNombreDpto oPersona = new clsPersonasConNombreDpto();
                oPersona.Id= listadoNormal[i].Id;
                oPersona.Nombre = listadoNormal[i].Nombre;
                oPersona.Apellidos = listadoNormal[i].Apellidos;
                oPersona.Direccion = listadoNormal[i].Direccion;
                oPersona.Telefono = listadoNormal[i].Telefono;
                oPersona.Foto= listadoNormal[i].Foto;
                oPersona.FechaNacimiento = listadoNormal[i].FechaNacimiento;
                oPersona.IdDepartamento = listadoNormal[i].IdDepartamento;
                oPersona.NombreDpto = clsListadoDepartamentosBL.obtenerDepartamentoPorIdBL(listadoNormal[i].IdDepartamento).Nombre;
                listadoConDpto.Add(oPersona);
            }
            return listadoConDpto;
        }
        #endregion
    }
}

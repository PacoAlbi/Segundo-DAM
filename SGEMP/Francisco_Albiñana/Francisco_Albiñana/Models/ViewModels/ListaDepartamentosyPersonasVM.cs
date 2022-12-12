using BL.Listados;
using BL.Manejadoras;
using Entidades;
using System.Collections.ObjectModel;

namespace Francisco_Albiñana.Models.ViewModels
{
    /// <summary>
    /// ViewModel que me sirve para sacar la lista de departamentos con personas, y borrar despues.
    /// </summary>
    public class ListaDepartamentosyPersonasVM
    {
        #region Propiedades
        public ObservableCollection<DepartamentosConPersonas> Listado { get; set; }
        #endregion

        #region Constructores
        public ListaDepartamentosyPersonasVM() 
        {
            Listado = ListadoDepartamentosyPersonas();
        }
        #endregion

        #region Metodos
        /// <summary>
        /// Precondiciones: No tiene.
        /// Método para sacar la lista de departamentos con lista de personas.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de Departamentos con lista de personas.
        /// </summary>
        /// <returns>List de Departamentos con personas.</returns>
        public ObservableCollection<DepartamentosConPersonas> ListadoDepartamentosyPersonas()
        {
            ObservableCollection<clsDepartamentos> listaDep = new ObservableCollection<clsDepartamentos>(clsListadoDepartamentosBL.getListadoDepartamentosBL());
            ObservableCollection<DepartamentosConPersonas> listaFinal = new ObservableCollection<DepartamentosConPersonas>();
            for (int i = 0; i< listaDep.Count; i++)
            {
                DepartamentosConPersonas miDep = new DepartamentosConPersonas();
                miDep.Id = listaDep[i].Id;
                miDep.Nombre = listaDep[i].Nombre;
                miDep.ListaPersonas = new ObservableCollection<clsPersona>(clsListadoPersonasBL.obtenerPersonasPorIdDepartamentoBL(listaDep[i].Id));
                listaFinal.Add(miDep);
            }
            return listaFinal;
        }
        /// <summary>
        /// Precondiciones: Debe recivir el Id del departamento a borrar.
        /// Método para borrar los departamentos y sus personas asociadas y devolver el número de líneas afectadas.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve el número de filas afectadas.
        /// </summary>
        /// <param name="idDepartamento">int Id</param>
        /// <returns>int número de filas afectadas</returns>
        public int BorrarPersonasyDepartamentos(int idDepartamento)
        {
            int personasBorradas;
            int departamentosBorrados;
            personasBorradas = clsManejadoraPersonas.borrarPersonaPorDepartamentoBL (idDepartamento);
            departamentosBorrados = clsManejadoraDepartamentos.borrarDepartamentosBL (idDepartamento);
            return 0;
        }
        #endregion
    }
}

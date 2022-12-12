using BL.Listados;
using Entidades;
using System.Collections.ObjectModel;

namespace Francisco_Albiñana.Models
{
    /// <summary>
    /// Mi modelo que hereda de departamentos para añadirle la lista de personas.
    /// </summary>
    public class DepartamentosConPersonas : clsDepartamentos
    {
        #region Atributos
        private ObservableCollection<clsPersona> listaPersonas;
        #endregion
        #region Propiedades
        public ObservableCollection<clsPersona> ListaPersonas { get { return listaPersonas; } set { listaPersonas = value; } }
        #endregion
        #region Constructores
        public DepartamentosConPersonas() 
        {
        }
        public DepartamentosConPersonas(int IdDepartamento)
        {
            ListaPersonas = new ObservableCollection<clsPersona>(clsListadoPersonasBL.obtenerPersonasPorIdDepartamentoBL(IdDepartamento));
        }
        #endregion
    }
}

using Entidades;

namespace DAL
{
    public class clsListadoDepartamentosDAL
    {
        /// <summary>
        /// Metodo que nos devuelve un listado completo de los departamentos.
        /// </summary>
        /// <returns> List<clsDepartamento> </returns>
        public static List<clsDepartamento> ObtenerListadoCompletoDepartamentos()
        {
            List<clsDepartamento> departamentos = new List<clsDepartamento>();

            // añadimos los departamentos a la lista
            departamentos.Add(new clsDepartamento(1,"Marketing y Ventas"));
            departamentos.Add(new clsDepartamento(2,"Contabilidad y Finanzas"));
            departamentos.Add(new clsDepartamento(3,"Cadena de Suministro"));
            departamentos.Add(new clsDepartamento(4,"Recursos Humanos"));

            return departamentos;
        }
    }
}
using Entidades;

namespace DAL
{
    public class clsManejadoraDepartamentosDAL
    {
        /// <summary>
        /// Funcion que busca un departamento en la lista en el que IdDepartamento sea igual al del parametro y lo devuelve
        /// </summary>
        /// <param name="Id"></param>
        /// <returns> List<clsDepartamento> </returns>
        public static clsDepartamento ObtenerDepartamentoPorSuId(int Id)
        {
            List<clsDepartamento> listaDptos = clsListadoDepartamentosDAL.ObtenerListadoCompletoDepartamentos();

            // buscamos en la lista de departamentos un departamento en el que su id sea igual al del parametro
            return listaDptos.Find(x => x.IdDepartamento == Id);
        }
    }
}

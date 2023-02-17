using Entidades;
using Microsoft.Data.SqlClient;
using System.Data;

namespace DAL.Listados
{
    public class clsListadoDepartamentosDAL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la BBDD y saco un lista de departamentos de la tabla Departamentos para mandar a la BL.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de departamentos.
        /// </summary>
        /// <returns>List de departamentos.</returns>
        public static List<clsDepartamentos> getListadoDepartamentosDAL()
        {
            List<clsDepartamentos> listadoDepartamentosDAL = new List<clsDepartamentos>();
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsDepartamentos miDepartamento;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Departamentos";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();
                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miDepartamento = new clsDepartamentos();
                        //Pruebo otra forma de sacare los datos del lector a modo de array con el casteo ya hecho.
                        miDepartamento.id = miLector.GetInt32(0);
                        miDepartamento.nombre = miLector.GetString(1);
                        listadoDepartamentosDAL.Add(miDepartamento);
                    }
                }
                miLector.Close();
                miConexion.closeConnection(ref conexion);
            }
            catch (SqlException)
            {
                throw;
            }
            catch (Exception)
            {
                throw;
            }
            return listadoDepartamentosDAL;
        }
    }
}
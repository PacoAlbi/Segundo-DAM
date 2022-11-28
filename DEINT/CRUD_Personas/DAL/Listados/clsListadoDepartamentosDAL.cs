using Entidades;
using Microsoft.Data.SqlClient;
using System.Data;

namespace DAL.Listados
{
    public class clsListadoDepartamentosDAL
    {
        /// <summary>
        /// Conecto con la BBDD y saco un lista de departamentos de la tabla Departamentos para mandar a la BL.
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
                        miDepartamento.Id = miLector.GetInt32(0);
                        miDepartamento.Nombre = miLector.GetString(1);
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

        /// <summary>
        /// Busco en la base de datos un departamento por su Id.
        /// </summary>
        /// <param name="Id">Paso el Id del departamento a buscar.</param>
        /// <returns>Devuelvo un clsDepartamento si lo hemos encontrado.</returns>
        public static clsDepartamentos obtenerDepartamentoPorIdDAL(int Id)
        {
            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsDepartamentos miDepartamento = null;
            try
            {
                miComando.Parameters.Add("@id", System.Data.SqlDbType.Int).Value = Id;
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Departamentos WHERE Id = @Id";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();
                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miDepartamento = new clsDepartamentos();
                        miDepartamento.Id = miLector.GetInt32(0);
                        miDepartamento.Nombre = miLector.GetString(1);
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
            return miDepartamento;
        }
    }
}

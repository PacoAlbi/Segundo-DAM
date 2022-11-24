using Entidades;
using Microsoft.Data.SqlClient;

namespace DAL.Listados
{
    public class clsListadoDepartamentosDAL
    {
        /// <summary>
        /// Conecto con la BBDD y saco un lista de departamentos de la tabla Departamentos para mandar a la BL.
        /// </summary>
        /// <returns>List de departamentos</returns>
        public static List<clsDepartamentos> getListadoDepartamentosDAL()
        {
            //DataSet miDataSet = new DataSet(); //Esto es para el modo desconectado, que no tengo aceso a la BBDD
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

                        miDepartamento.Id = (int)miLector["Id"];
                        miDepartamento.Nombre = (String)miLector["Nombre"];
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
        /// Busco en la lista creada antes un departamento por su Id.
        /// </summary>
        /// <param name="Id">Paso el Id del departamento a buscar</param>
        /// <returns>Devuelvo un clsDepartamento si lo hemos encontrado</returns>
        public static clsDepartamentos obtenerDepartamentoPorIdDAL(int Id)
        {
            List<clsDepartamentos> departamentoBuscado = getListadoDepartamentosDAL();
            return departamentoBuscado.Find(x => x.Id == Id);
        }
    }
}

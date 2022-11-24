using Entidades;
using Microsoft.Data.SqlClient;

namespace DAL.Listados
{
    public class clsListadoDepartamentosDAL
    {
        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
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
        /// 
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public static clsDepartamentos obtenerDepartamentoPorIdDAL(int Id)
        {
            List<clsDepartamentos> departamentoBuscado = getListadoDepartamentosDAL();
            return departamentoBuscado.Find(x => x.Id == Id);
        }
    }
}

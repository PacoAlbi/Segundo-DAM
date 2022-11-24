using Entidades;
using Microsoft.Data.SqlClient;
using System.Data;


namespace DAL.Listados
{
    public class clsListadoPersonasDAL
    {
        /// <summary>
        /// 
        /// </summary>
        /// <returns></returns>
        public static List<clsPersona> getListadoPersonasDAL()
        {
            //DataSet miDataSet = new DataSet(); //Esto es para el modo desconectado, que no tengo aceso a la BBDD
            List<clsPersona> listadoPersonasDAL = new List<clsPersona>();

            clsMyConnection miConexion = new clsMyConnection();
            SqlConnection conexion = new SqlConnection();
            SqlCommand miComando = new SqlCommand();
            SqlDataReader miLector;
            clsPersona miPersona;
            try
            {
                conexion = miConexion.getConnection();
                miComando.CommandText = "SELECT * FROM Personas";
                miComando.Connection = conexion;
                miLector = miComando.ExecuteReader();

                if (miLector.HasRows)
                {
                    while (miLector.Read())
                    {
                        miPersona = new clsPersona();

                        miPersona.Id = (int)miLector["Id"];
                        miPersona.Nombre = (String)miLector["Nombre"];
                        miPersona.Apellidos = (String)miLector["Apellidos"];
                        miPersona.Telefono = (String)miLector["Telefono"];
                        miPersona.Direccion = (String)miLector["Direccion"];
                        miPersona.Foto = (String)miLector["Foto"];
                        if (miLector["FechaNacimiento"] != DBNull.Value)
                        {
                            miPersona.FechaNacimiento = (DateTime)miLector["FechaNacimiento"];
                        }

                        miPersona.IdDepartamento = (int)miLector["IdDepartamento"];
                        listadoPersonasDAL.Add(miPersona);

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
            return listadoPersonasDAL;
        }

        /// <summary>
        /// 
        /// </summary>
        /// <param name="Id"></param>
        /// <returns></returns>
        public static clsPersona obtenerPersonaPorIdDAL (int Id)
        {
            List<clsPersona> personaBuscada = getListadoPersonasDAL();
            return personaBuscada.Find(x => x.Id == Id);
        }
    }
}

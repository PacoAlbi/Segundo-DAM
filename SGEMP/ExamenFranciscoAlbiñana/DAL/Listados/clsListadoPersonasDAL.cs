using Entidades;
using Microsoft.Data.SqlClient;
using System.Data;


namespace DAL.Listados
{
    public class clsListadoPersonasDAL
    {
        /// <summary>
        /// Precondiciones: No tiene.
        /// Conecto con la BBDD y saco una lista de personas de la tabla Personas para mandar a la BL.
        /// Lanza los errores a la capa superior.
        /// Postcondiciones: Devuelve una lista de personas de la BBDD.
        /// </summary>
        /// <returns>List de personas.</returns>
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
                        miPersona.id = (int)miLector["id"];
                        miPersona.nombre = (String)miLector["nombre"];
                        miPersona.apellidos = (String)miLector["apellidos"];
                        miPersona.telefono = (String)miLector["telefono"];
                        miPersona.direccion = (String)miLector["direccion"];
                        miPersona.foto = (String)miLector["foto"];
                        if (miLector["fechaNacimiento"] != DBNull.Value)
                        {
                            miPersona.fechaNacimiento = (DateTime)miLector["fechaNacimiento"];
                        }
                        miPersona.idDepartamento = (int)miLector["idDepartamento"];
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
    }
}